
//This file is "Control"

package com.hoodedfalcon.event;

import com.hoodedfalcon.interfaces.RecordPaneInterface;
import com.hoodedfalcon.model.nameaddress.AlphaString;
import com.hoodedfalcon.model.nameaddress.NameAddressId;
import com.hoodedfalcon.model.nameaddress.SingleName;
import com.hoodedfalcon.interfaces.EditRecordInterface;
import com.hoodedfalcon.view.EditRecordPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * SubmitEditEvent, similar to SubmitRecordEvent, is triggered when the user clicks "Submit"
 * within the EditRecordPane.  The event checks that all fields within the Grid Pane are
 * filled, and then updates the record in the main records list and in the list pane.
 *
 * @see EditRecordPane
 * @see EditRecordInterface
 */
public class SubmitEditEvent implements EventHandler<ActionEvent>
{
	private RecordPaneInterface gpi;
	private EditRecordInterface uri;

	public void setGUI(RecordPaneInterface gpi, EditRecordInterface uri)
    {
		this.gpi = gpi;
		this.uri = uri;
	}

	public RecordPaneInterface getGUI()
    {
		return gpi;
	}

	public EditRecordInterface getURI()
	{
		return uri;
	}

	public void handle(ActionEvent event) 
    {
		NameAddressId nameAddress = new NameAddressId();
		AlphaString alpha = new AlphaString();
		SingleName single = new SingleName();
		boolean error = false;

		if (gpi.getFirst().equals(""))
		{
			gpi.setFirstRed();
			error = true;
		}
		if (gpi.getMiddle().equals(""))
		{
			gpi.setMiddleRed();
			error = true;
		}
		if (gpi.getLast().equals(""))
		{
			gpi.setLastRed();
			error = true;
		}
		if (gpi.getID().equals(""))
		{
			gpi.setIDRed();
			error = true;
		}
		if (gpi.getStreet().equals(""))
		{
			gpi.setStreetRed();
			error = true;
		}
		if (gpi.getCity().equals(""))
		{
			gpi.setCityRed();
			error = true;
		}
		if (gpi.getState().equals(""))
		{
			gpi.setStateRed();
			error = true;
		}
		if (gpi.getZip().equals(""))
		{
			gpi.setZipRed();
			error = true;
		}
		
		if (error) return;
		
		alpha.set(gpi.getFirst());
		single.set(alpha);
		nameAddress.setFirst(single);
		
		alpha.set(gpi.getMiddle());
		single.set(alpha);
		nameAddress.setMiddle(single);
		
		alpha.set(gpi.getLast());
		single.set(alpha);
		nameAddress.setLast(single);
		
		nameAddress.setStreet(gpi.getStreet());
		
		alpha.set(gpi.getCity());
		single.set(alpha);
		nameAddress.setCity(single);
		
		alpha.set(gpi.getState());
		single.set(alpha);
		nameAddress.setState(single);

		nameAddress.setID(Integer.parseInt(gpi.getID()));

		nameAddress.setZip(Integer.parseInt(gpi.getZip()));
		
		uri.update(nameAddress);
	}
}

