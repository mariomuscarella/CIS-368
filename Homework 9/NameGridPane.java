import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;

public class NameGridPane extends GridPane implements GridPaneInterface{
	
	public void init(){
        EventGrid eg = new EventGrid();

        eg.setGUI(this);
        Label label1 = new Label("Name Address Id: ");
        final TextField text1 = new TextField();
        Button confirm = new Button();
        
        confirm.setText("Confirm");
        this.add(label1, 1, 1);
        this.add(text1, 2, 1);
        this.add(confirm, 2, 2);
     }
}
