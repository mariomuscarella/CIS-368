

package com.hoodedfalcon.event;

import com.hoodedfalcon.interfaces.MainAppInterface;
import com.hoodedfalcon.model.MyBoolean;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * DeleteRecordKeyEvent is triggered when the user clicks delete on their keyboard
 * This event removes the selected record from the records list
 * and the list pane.
 */
public class DeleteRecordKeyEvent implements EventHandler<KeyEvent>
{
	private MainAppInterface mai;
	private int index;
	private MyBoolean isEditEnabled;

	public void handle(KeyEvent event)
	{
		if (event.getCode() != KeyCode.DELETE)
		{
			return;
		}

		synchronized (isEditEnabled.getLock())
		{
			if (!isEditEnabled.get())
			{
				return;
			}
		}

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

	public void setIsEditEnabled(MyBoolean isEditEnabled)
	{
		this.isEditEnabled = isEditEnabled;
	}


}

