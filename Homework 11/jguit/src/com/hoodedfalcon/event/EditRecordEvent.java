

package com.hoodedfalcon.event;

import com.hoodedfalcon.interfaces.MainAppInterface;
import com.hoodedfalcon.model.nameaddress.NameAddressId;
import com.hoodedfalcon.view.EditRecordPane;
import com.hoodedfalcon.interfaces.EditRecordInterface;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * EditRecordEvent is triggered when the user selects "Edit Record" from the Menu.
 * Similar to NewRecordEvent, this event creates a new view - in this case: EditRecordPane,
 * and allows the user to enter the record details through several LimitedTextFields.
 *
 * @see EditRecordPane
 * @see com.hoodedfalcon.view.LimitedTextField
 * @see SubmitEditEvent
 */
public class EditRecordEvent implements EventHandler<ActionEvent>, EditRecordInterface
{

	private MainAppInterface mai;
	private Stage updateRecordStage;

	private int index;
	private NameAddressId recordToUpdate;

	public void handle(ActionEvent event)
	{
		index = mai.getSelectedIndex();
		if (index == -1) return;

		recordToUpdate = new NameAddressId(mai.getRecordToUpdate(index));

		EditRecordPane root = new EditRecordPane();
		root.start();
		root.updatePrompts(recordToUpdate);
		root.setERI(this);
		updateRecordStage = new Stage();
		updateRecordStage.setTitle("Update NameAddressId Record");
		updateRecordStage.setScene(new Scene(root, 400, 250));
		updateRecordStage.sizeToScene();
		updateRecordStage.initModality(Modality.APPLICATION_MODAL);
		updateRecordStage.show();
	}

	public void update(NameAddressId nameAddress)
	{
		mai.update(nameAddress, index);
		updateRecordStage.close();
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

