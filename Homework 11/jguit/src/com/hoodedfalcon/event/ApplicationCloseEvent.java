

package com.hoodedfalcon.event;

import com.hoodedfalcon.control.AlertManager;
import com.hoodedfalcon.control.ConnectionManager;
import com.hoodedfalcon.control.LoadNextTenTask;
import com.hoodedfalcon.control.ThreadManager;
import com.hoodedfalcon.interfaces.MainAppInterface;
import com.hoodedfalcon.model.AlertMessage;
import com.hoodedfalcon.model.MyBoolean;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.ArrayList;
import java.util.Optional;

/**
 * ApplicationCloseEvent is triggered when the user closes out of the JavaFX Application.
 * This event closes the JavaFX main stage, and attempts to stop the entire program if possible.
 * If another thread is currently active, this event will wait 30 seconds before trying to exit again.
 *
 * @see com.hoodedfalcon.control.MyApplication
 * @see LoadNextTenTask
 * @see com.hoodedfalcon.control.UpdateThread
 */
public class ApplicationCloseEvent implements EventHandler<WindowEvent>
{
	private MainAppInterface mai;
	private MyBoolean[] statuses;
	private long time = 1000 * 30;
	private Stage stage;
	private ConnectionManager connectionManager;
	private MyBoolean pendingRecords[];
	private AlertManager alertManager;
	private ArrayList<Integer> deletedRecords;
	private ThreadManager threadManager;

	public void handle(WindowEvent event)
    {
		if (connectionManager.doesConnectionExist())
		{
			if (!areAllRecordsUpdated())
			{
				Optional<ButtonType> response = alertManager.alert(AlertMessage.CLOSE_UNSAVED_RECORDS);
				if (!response.isPresent() || response.get() == ButtonType.CANCEL)
				{
					threadManager.forceUpdate();
					event.consume();
					return;
				}
			}
		}

		stage.close();
		while(true)
		{
			if (!(areThreadsActive()))
			{
				System.out.println("Application Closing!");
				connectionManager.disconnect();
				System.exit(0);
			}
			System.out.println("Another thread is active, sleeping for 30 seconds.");
			sleep();
		}
	}

	public boolean areThreadsActive()
	{
		for (int i = 0; i < statuses.length; i++)
		{
			synchronized (statuses[i])
			{
				if (statuses[i].get()) return true;
			}
		}
		return false;
	}

	public void sleep()
	{
		try
		{
			Thread.sleep(time);
		}
		catch(Throwable t)
		{
			t.printStackTrace();
		}
	}

	public void setStage(Stage stage)
	{
		this.stage = stage;
	}

	public void setStatuses(MyBoolean...statuses)
	{
		this.statuses = statuses;
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

	public void setDeletedRecords(ArrayList<Integer> deletedRecords)
	{
		this.deletedRecords = deletedRecords;
	}

	public void setThreadManager(ThreadManager threadManager)
	{
		this.threadManager = threadManager;
	}


}

