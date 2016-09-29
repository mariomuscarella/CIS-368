package sixth;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ClickSecondButtonEvent implements EventHandler<ActionEvent> {
	   private boolean a = true;
	   private ChangeBgColorInterface y;

	   public void setGUI(ChangeBgColorInterface y) {
	     this.y = y;
	   }
	  
	   @Override
	   public void handle(ActionEvent event) {
		   System.out.println("Background Color Changed");
	     if(a) 
	     {
	    	 y.changeBgColor("blue");	 
	     }
	     else
	     {
	    	 y.changeBgColor("orange");
	     }
	     a = !a;
	   }
}
