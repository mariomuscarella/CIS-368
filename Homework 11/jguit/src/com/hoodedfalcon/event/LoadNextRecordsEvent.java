

package com.hoodedfalcon.event;

import com.hoodedfalcon.control.AlertManager;
import com.hoodedfalcon.control.ConnectionManager;
import com.hoodedfalcon.control.ThreadManager;
import com.hoodedfalcon.interfaces.MainAppInterface;
import com.hoodedfalcon.model.AlertMessage;
import com.hoodedfalcon.model.MyBoolean;
import com.hoodedfalcon.model.nameaddress.NameAddressId;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;

import java.util.ArrayList;
import java.util.Optional;

/**
 * LoadNextRecordsEvent is triggered when the user selects "Load Next Ten Records"
 * from the Menu.  This event alerts the Load Thread to load the next ten
 * records from the loaded file.
 */
public class LoadNextRecordsEvent implements EventHandler<ActionEvent>
{
	private MainAppInterface mai;
	private ThreadManager threadManager;
	private ConnectionManager connectionManager;
	private AlertManager alertManager;
	private MyBoolean pendingRecords[];

	@Override
	public void handle(ActionEvent event) 
    {
		if (connectionManager.doesConnectionExist())
		{
			if (!areAllRecordsUpdated())
			{
				Optional<ButtonType> response = alertManager.alert(AlertMessage.LOAD_UNSAVED_RECORDS);
				if (!response.isPresent() || response.get() == ButtonType.CANCEL)
				{
					threadManager.forceUpdate();
					return;
				}
			}
		}

		ArrayList<NameAddressId> records = threadManager.load();

		if (records == null) return;

		if (records.size() == 0)
		{
			alertManager.alert(AlertMessage.NO_ADDITIONAL_RECORDS);
			return;
		}

		mai.clearList();

		for (int i = 0; i < records.size(); i++)
		{
			mai.add(records.get(i), true);
		}
	}

	public void setMAI(MainAppInterface mai)
	{
		this.mai = mai;
	}

	public void setThreadManager(ThreadManager threadManager)
	{
		this.threadManager = threadManager;
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
		return true;
	}

	public void setAlertManager(AlertManager alertManager)
	{
		this.alertManager = alertManager;
	}

}

