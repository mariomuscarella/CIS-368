package Feb24;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.util.Callback;

public class EventDialogPane implements EventHandler<ActionEvent> {

	private DialogPaneInterface dpi;
	private DialogPane dig = new DialogPane();
	private MyGridPane grid = new MyGridPane();
	
	public void setGUI(DialogPaneInterface dpi) {
		this.dpi = dpi;
	}

	@Override
	public void handle(ActionEvent event) {

		 	Label label1 = new Label("Mobile: ");
	        Label label2 = new Label("Email: ");
	        final TextField text1 = new TextField();
	        final TextField text2 = new TextField();
	        
	        grid.add(label1, 1, 1);
	        grid.add(text1, 2, 1);
	        grid.add(label2, 1, 2);
	        grid.add(text2, 2, 2);
	        
	        dpi.setContentForDialogPane(dig, grid);

			Dialog<ContactInfo> dialog = new Dialog<ContactInfo>();
			dialog.setDialogPane(dig); 
			dialog.setTitle("Contact Information");
			final ButtonType buttonTypeOk = new ButtonType("Okay", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);

			dialog.setResultConverter(new Callback<ButtonType, ContactInfo>() {
			    @Override
			    public ContactInfo call(ButtonType b) {
			        if (b == buttonTypeOk) {
			            return new ContactInfo(text1.getText(), text2.getText());
			        }
			        return null;
			    }			
			});

		Optional<ContactInfo> result = dialog.showAndWait();
		if (result.isPresent()) {
		    System.out.println("Mobile No.: " + result.get().getMobileNo());
		    System.out.println("Email Id: " + result.get().getEmailId());
		}
		
	}
	

}
