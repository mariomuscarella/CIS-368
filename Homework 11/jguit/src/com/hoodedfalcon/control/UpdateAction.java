/** CIS 368 QUARTER 4 GROUP 2
 * MEMBERS:
 * GLEN FANNIN
 * JOHN LIGGETT
 * MARIO MUSCARELLA
 * CHRISTINA VECCHIO
 */

package com.hoodedfalcon.control;

import com.hoodedfalcon.model.AlertMessage;
import com.hoodedfalcon.model.MyBoolean;
import com.hoodedfalcon.interfaces.MainAppInterface;
import com.hoodedfalcon.model.nameaddress.NameAddressId;
import javafx.application.Platform;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 * UpdateAction is the object which handles the actual updating of pending records,
 * which is called from UpdateThread approximately every minute.
 */
public class UpdateAction
{
	private MainAppInterface mai;
	private AlertManager alertManager = new AlertManager();
	private ArrayList<NameAddressId> updatedRecords = new ArrayList<>();
	private ArrayList<NameAddressId> recordsList = new ArrayList<>();
	private MyBoolean[] pendingRecords;
	private MyBoolean isEditEnabled;
	private ArrayList<Integer> deletedRecords = new ArrayList<>();
	private ArrayList<Integer> recordsToUpdate = new ArrayList<>();
	private Socket socket;
	private ObjectOutputStream objectOutputStream;
	private ObjectInputStream objectInputStream;
	private ConnectionManager connectionManager;
	private UpdateErrorAlert updateErrorAlert = new UpdateErrorAlert();

	public void update()
	{
		synchronized (isEditEnabled.getLock())
		{
			if (!isEditEnabled.get())
			{
				System.out.println("Edit is not enabled.  UpdateAction not occurring.");
				return;
			}
		}

		synchronized (recordsList)
		{
			if ((recordsList == null || recordsList.size() == 0) && deletedRecords.size() == 0)
			{
				return;
			}
		}

		synchronized (recordsList)
		{
			for (int i = 0; i < recordsList.size(); i++)
			{
				synchronized (pendingRecords)
				{
					if (pendingRecords[i].get())
					{
						recordsToUpdate.add(Integer.valueOf(recordsList.get(i).getID()));
						updatedRecords.add((NameAddressId) recordsList.get(i).clone());

						if (deletedRecords.contains(Integer.valueOf(recordsList.get(i).getID())))
						{
							deletedRecords.remove(Integer.valueOf(recordsList.get(i).getID()));
						}
					}
				}
			}

			// Set the MyBoolean array of pendingRecords to false (they are being updated)
			for (int i = 0; i < pendingRecords.length; i++)
			{
				synchronized (pendingRecords[i])
				{
					pendingRecords[i].set(false);
				}
			}
		}

		String message = "update";

		for (int i = 0; i < deletedRecords.size(); i++)
		{
			message += ";" + deletedRecords.get(i);
		}

		for (int i = 0; i < updatedRecords.size(); i++)
		{
			message += ";" + recordToString(i);
		}

		try
		{
			if (socket != null)
			{
				objectOutputStream.writeObject(message);
			}
		}
		catch (Exception e)
		{
			Platform.runLater(updateErrorAlert);
			return;
		}

		deletedRecords.clear();
		recordsToUpdate.clear();
		updatedRecords.clear();
	}

	public void setSocket(Socket socket)
	{
		this.socket = socket;
	}

	public void setStreams(ObjectOutputStream objectOutputStream, ObjectInputStream objectInputStream)
	{
		this.objectOutputStream = objectOutputStream;
		this.objectInputStream = objectInputStream;
	}

	private String recordToString(int i)
	{
		return updatedRecords.get(i).getID() + "," + updatedRecords.get(i).getZip() + "," +
			updatedRecords.get(i).getFirst().get() + "," +
			updatedRecords.get(i).getMiddle().get() + "," +
			updatedRecords.get(i).getLast().get() + "," +
			updatedRecords.get(i).getStreet() + "," +
			updatedRecords.get(i).getCity().get() + "," +
			updatedRecords.get(i).getState().get();
	}

	public void setDeletedRecords(ArrayList<Integer> deletedRecords)
	{
		this.deletedRecords = deletedRecords;
	}

	public void setPendingRecords(MyBoolean[] pendingRecords)
	{
		this.pendingRecords = pendingRecords;
	}

	public void setRecordsList(ArrayList<NameAddressId> list)
	{
		this.recordsList = list;
	}

	public void setMAI(MainAppInterface mai) 
    {
		this.mai = mai;
	}

	public void setIsEditEnabled(MyBoolean isEditEnabled)
	{
		this.isEditEnabled = isEditEnabled;
	}

	public void setConnectionManager(ConnectionManager connectionManager)
	{
		this.connectionManager = connectionManager;
	}

}

