import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class EventBorder implements EventHandler<ActionEvent> {
	  private BorderPaneInterface bpi;

	  public void setGUI(BorderPaneInterface bpi) {
	     this.bpi = bpi;
	  }
	     
	  public void handle(ActionEvent event) {
		  
	  }
}
