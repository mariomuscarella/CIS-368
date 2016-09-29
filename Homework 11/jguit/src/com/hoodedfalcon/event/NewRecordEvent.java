/** CIS 368 QUARTER 4 GROUP 2
 * MEMBERS:
 * GLEN FANNIN
 * JOHN LIGGETT
 * MARIO MUSCARELLA
 * CHRISTINA VECCHIO
 */

package com.hoodedfalcon.event;

import com.hoodedfalcon.interfaces.MainAppInterface;
import com.hoodedfalcon.interfaces.NewRecordInterface;
import com.hoodedfalcon.model.nameaddress.NameAddressId;
import com.hoodedfalcon.view.NewRecordPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * NewRecordEvent is triggered when the user selects "New Record" in the Menu.
 * This event launches a new view (NewRecordPane) which then allows the user
 * to enter details for a new record.  After the user submits the record, it
 * gets added to the main records list (and list pane) and the new view is
 * closed.
 *
 * @see com.hoodedfalcon.view.NewRecordPane
 * @see com.hoodedfalcon.view.LimitedTextField
 * @see SubmitRecordEvent
 */
public class NewRecordEvent implements EventHandler<ActionEvent>, NewRecordInterface
{
	
	private MainAppInterface mai;
	private Stage recordStage;
	
	public void handle(ActionEvent event) 
    {
		NewRecordPane root = new NewRecordPane();
		root.start();
		root.setNRI(this);
		recordStage = new Stage();
		recordStage.setTitle("New NameAddressId Record");
		recordStage.setScene(new Scene(root, 400, 250));
		recordStage.sizeToScene();
		recordStage.initModality(Modality.APPLICATION_MODAL);
		recordStage.show();
	}
	
	public void add(NameAddressId nameAddress)
    {
		mai.add(nameAddress);
		recordStage.close();
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

