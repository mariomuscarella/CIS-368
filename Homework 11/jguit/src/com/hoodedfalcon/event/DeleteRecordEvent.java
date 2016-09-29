

package com.hoodedfalcon.event;

import com.hoodedfalcon.interfaces.MainAppInterface;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * DeleteRecordsEvent is triggered when the user clicks "Delete Selected Record"
 * from the Menu.  This event removes the selected record from the records list
 * and the list pane.
 */
public class DeleteRecordEvent implements EventHandler<ActionEvent>
{

	private MainAppInterface mai;
	private int index;

	public void handle(ActionEvent event)
	{
		index = mai.getSelectedIndex();
		if (index == -1) return;

		mai.delete(index);
	}

	public MainAppInterface getMAI()
	{
		return mai;
	}

	public void setMAI(MainAppInterface mai)
	{
		this.mai = mai;
	}

}

