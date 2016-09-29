package Feb24;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
 
public class EventGrid implements EventHandler<ActionEvent> {
  private GridPaneInterface gpi;

  public void setGUI(GridPaneInterface gpi) {
     this.gpi = gpi;
  }
     
  public void handle(ActionEvent event) {
     Object o;
     Button b;
     Color c;

     o = event.getSource();
     if (o instanceof Button) {
        b = (Button) o;
        gpi.changeLabelText(b.getText());
        gpi.changeColorButton("yellow");
     }
     else {}
  }
}