

//This file is "Control"

package com.hoodedfalcon.event;

import com.hoodedfalcon.interfaces.RecordPaneInterface;
import com.hoodedfalcon.model.nameaddress.AlphaString;
import com.hoodedfalcon.model.nameaddress.NameAddressId;
import com.hoodedfalcon.model.nameaddress.SingleName;
import com.hoodedfalcon.view.EditRecordPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * PreviewTextEvent is triggered when the user clicks "Preview Text" in either
 * NewRecordPane or EditRecordPane.  This checks whether all of the
 * LimitedTextFields within the Grid Pane are filled, and then displays a
 * representation of the NameAddressId's contents.
 *
 * @see com.hoodedfalcon.view.NewRecordPane
 * @see EditRecordPane
 * @see com.hoodedfalcon.view.LimitedTextField
 */
public class PreviewTextEvent implements EventHandler<ActionEvent> 
{
	private RecordPaneInterface gpi;

	public void setGUI(RecordPaneInterface gpi)
    {
		this.gpi = gpi;
	}

	public RecordPaneInterface getGUI()
    {
		return gpi;
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
		
		String text = nameAddress.getFirst().get() + " " + nameAddress.getMiddle().get() + " " +
				nameAddress.getLast().get() + ", " + nameAddress.getID() + "\n" +
				nameAddress.getStreet() + "\n" +
				nameAddress.getCity().get() + ", " + nameAddress.getState().get() + "\n" +
				nameAddress.getZip();
		gpi.setText(text);
	}
}

