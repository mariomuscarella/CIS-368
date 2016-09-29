
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

 
public class ClickFirstButtonEvent implements EventHandler<ActionEvent> {
   
   private ChangeButtonTextInterface x;
   private int counter = 1;
   public void setGUI(ChangeButtonTextInterface x) {
     this.x = x;
   }
  
   @Override
   public void handle(ActionEvent event) {
     System.out.println("Hello World!");
     x.changeButtonText("You Clicked: " + counter + " times");
     counter++;
   }
}