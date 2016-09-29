
package com.hoodedfalcon.view;

import com.hoodedfalcon.event.SubmitEditEvent;
import com.hoodedfalcon.event.SubmitEditKeyEvent;
import com.hoodedfalcon.interfaces.EditRecordInterface;
import com.hoodedfalcon.interfaces.RecordPaneInterface;
import com.hoodedfalcon.model.nameaddress.NameAddressId;

/**
 * EditRecordPane is a GridPane View which lets the user edit a record.  When the user clicks
 * "Submit" in the view, SubmitEditEvent is triggered, which edits the record in the main record list
 * and the list pane.
 *
 * @see SubmitEditEvent
 */
public class EditRecordPane extends RecordGridPane implements EditRecordInterface, RecordPaneInterface
{
	private EditRecordInterface eri;

	private SubmitEditEvent submitEvent = new SubmitEditEvent();
	private SubmitEditKeyEvent submitEditKeyEvent = new SubmitEditKeyEvent();

	/**
	 * Prepares the View by calling super.start(), sets the event for the View's button,
	 * and sets the Button's Text.
	 */
	public void start() 
	{
		super.start();
		super.setButtonAction(submitEvent);
		super.setSubmitButtonText("Update Record");
		super.setOnKeyPressed(submitEditKeyEvent);
		super.setIDFieldDisabled(true);

		submitEvent.setGUI(this, this);
		submitEditKeyEvent.setGUI(this, this);
	}

	/**
	 * Updates the NameAddressId object in the main list and the list pane, through
	 * the EditRecordInterface (which is called from EditRecordEvent.
	 * @param nameAddressID The NameAddressId object to add.
	 */
	public void update(NameAddressId nameAddressID)
	{
		eri.update(nameAddressID);
	}

	/**
	 * Sets the EditRecordInterface Controller.  This is called by the EditRecordEvent, so that
	 * the View can update new NameAddressId objects.
	 * @param eri EditRecordInterface (EditRecordEvent Controller)
	 */
	public void setERI(EditRecordInterface eri)
	{
		this.eri = eri;
	}

}
