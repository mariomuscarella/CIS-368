package Feb24;

import javafx.scene.control.Button;
 
public interface FlowPaneInterface{
    public void changeButtonText(String newText, Button b);
    public String getText();
    public void changeFlowColor(String color, Button b);
}