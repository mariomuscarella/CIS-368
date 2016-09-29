import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.util.Callback;

public class EventGrid implements EventHandler<ActionEvent> {
	private GridPaneInterface gpi;

	public void setGUI(GridPaneInterface gpi) {
	     this.gpi = gpi;
	}

	
	@Override
	public void handle(ActionEvent arg0) {
		
	}
}
