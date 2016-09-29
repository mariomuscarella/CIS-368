/** CIS 368 QUARTER 4 GROUP 2
 * MEMBERS:
 * GLEN FANNIN
 * JOHN LIGGETT
 * MARIO MUSCARELLA
 * CHRISTINA VECCHIO
 */

//This file is "Control"

package com.hoodedfalcon.event;

import com.hoodedfalcon.interfaces.NewRecordInterface;
import com.hoodedfalcon.interfaces.RecordPaneInterface;
import com.hoodedfalcon.model.nameaddress.AlphaString;
import com.hoodedfalcon.model.nameaddress.NameAddressId;
import com.hoodedfalcon.model.nameaddress.SingleName;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * SubmitRecordEvent is triggered when the user clicks "Submit" in NewRecordPane.
 * This event checks that all fields within NewRecordPane were filled, and then
 * adds the record to the main records list and list pane.
 *
 * @see com.hoodedfalcon.view.NewRecordPane
 * @see NewRecordInterface
 */
public class SubmitRecordKeyEvent implements EventHandler<KeyEvent>
{
	private RecordPaneInterface gpi;
	private NewRecordInterface nri;

	public void setGUI(RecordPaneInterface gpi, NewRecordInterface nri)
    {
		this.gpi = gpi;
		this.nri = nri;
	}

	public RecordPaneInterface getGUI()
    {
		return gpi;
	}

	public void handle(KeyEvent event)
    {
		if (!(event.getCode() == KeyCode.ENTER))
		{
			return;
		}

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
		
		nri.add(nameAddress);
	}
}

