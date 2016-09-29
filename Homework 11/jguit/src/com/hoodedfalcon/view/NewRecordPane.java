
package com.hoodedfalcon.view;

import com.hoodedfalcon.event.SubmitRecordEvent;
import com.hoodedfalcon.event.SubmitRecordKeyEvent;
import com.hoodedfalcon.interfaces.RecordPaneInterface;
import com.hoodedfalcon.interfaces.NewRecordInterface;
import com.hoodedfalcon.model.nameaddress.NameAddressId;

/**
 * NewRecordPane is a GridPane View which lets the user add a new record.  When the user clicks
 * "Submit" in the view, SubmitRecordEvent is triggered, which adds the record to the main record list
 * and the list pane.
 *
 * @see SubmitRecordEvent
 */
public class NewRecordPane extends RecordGridPane implements NewRecordInterface, RecordPaneInterface
{
	private NewRecordInterface nri;

	private SubmitRecordEvent submitEvent = new SubmitRecordEvent();
	private SubmitRecordKeyEvent submitRecordKeyEvent = new SubmitRecordKeyEvent();

	/**
	 * Prepares the View by calling super.start(), sets the event for the View's button,
	 * and sets the Button's Text.
	 */
	public void start() 
    {
		super.start();
		super.setButtonAction(submitEvent);
		super.setSubmitButtonText("Submit Record");
		super.setOnKeyPressed(submitRecordKeyEvent);

		submitEvent.setGUI(this, this);
		submitRecordKeyEvent.setGUI(this, this);
	}

	/**
	 * Adds the NameAddressId object to the main list and the list pane, through
	 * the NewRecordInterface (which is called from NewRecordEvent.
	 * @param nameAddressID The NameAddressId object to add.
     */
	public void add(NameAddressId nameAddressID)
    {
		nri.add(nameAddressID);
	}

	/**
	 * Sets the NewRecordInterface Controller.  This is called by the NewRecordEvent, so that
	 * the View can add new NameAddressId objects.
	 * @param nri NewRecordInterface (NewRecordEvent Controller)
     */
	public void setNRI(NewRecordInterface nri) 
    {
		this.nri = nri;
	}

}
