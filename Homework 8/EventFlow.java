package Feb24;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
 
public class EventFlow implements EventHandler<ActionEvent> {
  private FlowPaneInterface fpi;

  public void setGUI(FlowPaneInterface fpi) {
     this.fpi = fpi;
  }
     
  public void handle(ActionEvent event) {
     Object o;
     Button b;
     String s;

     o = event.getSource();
     if (o instanceof Button) {
        b = (Button) o;
        s = fpi.getText();
        fpi.changeButtonText(s, b);
        fpi.changeFlowColor(s, b);
     }
     else {}
  }
}