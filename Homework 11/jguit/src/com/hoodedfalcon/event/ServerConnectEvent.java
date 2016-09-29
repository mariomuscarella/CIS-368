/** CIS 368 QUARTER 4 GROUP 2
 * MEMBERS:
 * GLEN FANNIN
 * JOHN LIGGETT
 * MARIO MUSCARELLA
 * CHRISTINA VECCHIO
 */

package com.hoodedfalcon.event;

import com.hoodedfalcon.control.AlertManager;
import com.hoodedfalcon.control.ConnectionManager;
import com.hoodedfalcon.control.ThreadManager;
import com.hoodedfalcon.interfaces.MainAppInterface;
import com.hoodedfalcon.interfaces.ServerConnectInterface;
import com.hoodedfalcon.model.AlertMessage;
import com.hoodedfalcon.model.MyBoolean;
import com.hoodedfalcon.model.nameaddress.NameAddressId;
import com.hoodedfalcon.view.ServerGridPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;

/**
 * ServerConnectEvent launches a new view, at which users can specify the server and port
 * to connect to for the NameAddressId Database Server.  It also loads the first ten records
 * from the database.
 */
@SuppressWarnings("RedundantIfStatement")
public class ServerConnectEvent implements EventHandler<ActionEvent>, ServerConnectInterface
{
	private MainAppInterface mai;
	private Stage connectionPromptStage;
	private ConnectionManager connectionManager;
	private MyBoolean pendingRecords[];
	private ArrayList<Integer> deletedRecords;
	private AlertManager alertManager;
	private ThreadManager threadManager;
	private MyBoolean isEditEnabled;

	public void handle(ActionEvent event) 
    {
		ServerGridPane root = new ServerGridPane();
		root.start();
		root.setSCI(this);
		connectionPromptStage = new Stage();
		connectionPromptStage.setTitle("Connect to a NameAddressId Database Server");
		connectionPromptStage.setScene(new Scene(root, 400, 100));
		connectionPromptStage.sizeToScene();
		connectionPromptStage.initModality(Modality.APPLICATION_MODAL);
		connectionPromptStage.show();
	}

	public void connect(String server, int port)
	{
		if (connectionManager.doesConnectionExist())
		{
			if (!areAllRecordsUpdated())
			{
				Optional<ButtonType> response = alertManager.alert(AlertMessage.DISCONNECT_UNSAVED_RECORDS);
				if (!response.isPresent() || response.get() == ButtonType.CANCEL)
				{
					threadManager.forceUpdate();
					connectionPromptStage.close();
					return;
				}
			}
			else
			{
				Optional<ButtonType> response = alertManager.alert(AlertMessage.CONNECTION_OVERRIDING);
				if (!response.isPresent() || response.get() == ButtonType.CANCEL)
				{
					threadManager.forceUpdate();
					connectionPromptStage.close();
					return;
				}
			}
			connectionManager.disconnect();
		}

		connectionPromptStage.close();
		connectionManager.connect(server, port);

		threadManager.setNextIndex(0);

		if (!connectionManager.doesConnectionExist())
		{
			return;
		}

		ArrayList<NameAddressId> records = threadManager.load();

		if (records == null) return;

		if (records.size() == 0)
		{
			synchronized (isEditEnabled.getLock())
			{
				if (isEditEnabled.get())
				{
					alertManager.alert(AlertMessage.EMPTY_DATABASE);
				}
				else
				{
					alertManager.alert(AlertMessage.EMPTY_DATABASE_ROM);
				}
			}
			return;
		}

		mai.clearList();

		for (int i = 0; i < records.size(); i++)
		{
			mai.add(records.get(i), true);
		}
	}

	public MainAppInterface getMAI() 
    {
		return mai;
	}
	
	public void setMAI(MainAppInterface mai) 
    {
		this.mai = mai;
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

	public void setThreadManager(ThreadManager threadManager)
	{
		this.threadManager = threadManager;
	}

	public void setIsEditEnabled(MyBoolean isEditEnabled)
	{
		this.isEditEnabled = isEditEnabled;
	}

	public void setDeletedRecords(ArrayList<Integer> deletedRecords)
	{
		this.deletedRecords = deletedRecords;
	}


}

