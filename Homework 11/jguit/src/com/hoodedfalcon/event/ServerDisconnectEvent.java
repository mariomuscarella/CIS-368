
package com.hoodedfalcon.event;

import com.hoodedfalcon.control.AlertManager;
import com.hoodedfalcon.control.ConnectionManager;
import com.hoodedfalcon.control.ThreadManager;
import com.hoodedfalcon.interfaces.MainAppInterface;
import com.hoodedfalcon.model.AlertMessage;
import com.hoodedfalcon.model.MyBoolean;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;

import java.util.ArrayList;
import java.util.Optional;

/**
 * This disconnects the current server from the client.  It also clears the currently
 * loaded records in the List Pane and the ArrayList.
 */
public class ServerDisconnectEvent implements EventHandler<ActionEvent>
{
	private MainAppInterface mai;
	private ConnectionManager connectionManager;
	private MyBoolean pendingRecords[];
	private ArrayList<Integer> deletedRecords;
	private AlertManager alertManager;
	private ThreadManager threadManager;

	public void setMAI(MainAppInterface mai) 
    {
		this.mai = mai;
	}

	@Override
	public void handle(ActionEvent event) 
    {
		try
		{
			if (connectionManager.doesConnectionExist() && !areAllRecordsUpdated())
			{
				Optional<ButtonType> response = alertManager.alert(AlertMessage.DISCONNECT_UNSAVED_RECORDS);
				if (!response.isPresent() || response.get() == ButtonType.CANCEL)
				{
					threadManager.forceUpdate();
					return;
				}
			}

			connectionManager.disconnect();
		}
		catch (Throwable t)
        {
			t.printStackTrace();
		}
	}

	public void setConnectionManager(ConnectionManager connectionManager)
	{
		this.connectionManager = connectionManager;
	}

	public void setPendingRecords(MyBoolean[] pendingRecords)
	{
		this.pendingRecords = pendingRecords;
	}

	private boolean areAllRecordsUpdated()
	{
		for (int i = 0; i < pendingRecords.length; i++)
		{
			synchronized (pendingRecords)
			{
				if (pendingRecords[i].get()) return false;
			}
		}
		return deletedRecords.size() <= 0;
	}


	public void setAlertManager(AlertManager alertManager)
	{
		this.alertManager = alertManager;
	}

	public void setDeletedRecords(ArrayList<Integer> deletedRecords)
	{
		this.deletedRecords = deletedRecords;
	}

	public void setThreadManager(ThreadManager threadManager)
	{
		this.threadManager = threadManager;
	}



}
