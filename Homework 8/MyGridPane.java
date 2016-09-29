package Feb24;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
 
public class MyGridPane extends GridPane implements GridPaneInterface{
    private Button btngp1 = new Button();
    private Button btngp2 = new Button();
    private Button btngp3 = new Button();
    private Button btngp4 = new Button();
    private Label lblgp = new Label("grid pane label");
    private Label lblgp2 = new Label("Type a color in the box below, then click a Flow");

    public void init(){
        EventGrid eg = new EventGrid();

        eg.setGUI(this);
        btngp1.setText("Grid Pane 1");
        btngp2.setText("Grid Pane 2");
        btngp3.setText("Grid Pane 3");
        btngp4.setText("Grid Pane 4");
        btngp1.setOnAction(eg);
        btngp2.setOnAction(eg);
        btngp3.setOnAction(eg);
        btngp4.setOnAction(eg);
        this.add(btngp1,0,0);
        this.add(btngp2,0,1);
        this.add(btngp3,1,0);
        this.add(lblgp,0,2);
        this.add(btngp4, 1, 1);
        this.add(lblgp2,0,3);
     }

    public void changeLabelText(String newText){
      lblgp.setText(newText);
    }
    
    public void changeColorButton(String color) {
		lblgp.setStyle("-fx-background-color: " + color);
	}
}
