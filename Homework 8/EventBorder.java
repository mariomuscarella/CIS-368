package Feb24;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
 
public class EventBorder implements EventHandler<ActionEvent> {
  private BorderPaneInterface bpi;
  private boolean bool = true;

  public void setGUI(BorderPaneInterface bpi) {
     this.bpi = bpi;
  }
     
  public void handle(ActionEvent event) {
     Object o;
     Button b;

     o = event.getSource();
     if (o instanceof Button) {
        b = (Button) o;
        if (bool) {
          bpi.changeButtonBack("BURLYWOOD", b);
        }
        else {
          bpi.changeButtonBack("AQUAMARINE", b);
        }
        bool = !bool;
     }
     else {}
  }
}