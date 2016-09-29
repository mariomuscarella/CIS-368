package sixth;

import javafx.application.Application;
import javafx.scene.Scene; 
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class MyApplication extends Application implements 
                                     ChangeButtonTextInterface, ChangeBgColorInterface {
    private Button btn = new Button();
    private Button btn2 = new Button();
    private Pane root = new Pane();
    
    public void start(Stage primaryStage) {
        ClickFirstButtonEvent mae = new ClickFirstButtonEvent();
        ClickSecondButtonEvent maet = new ClickSecondButtonEvent();
     
        
        final Text text1 = new Text(100, 75, "Click a Button");
        text1.setFill(Color.BLACK);
        root.getChildren().add(text1);
        
        //Button 1
        mae.setGUI(this);
        btn.setLayoutX(15);
        btn.setLayoutY(125);
        changeButtonText("Say Hello World");
        btn.setOnAction(mae);
        root.getChildren().add(btn);
        
        //Button 2
        maet.setGUI(this);
        btn2.setLayoutX(145);
        btn2.setLayoutY(125);
        btn2.setText("Change Background Color");
        btn2.setOnAction(maet);
        root.getChildren().add(btn2);
      
        final Scene scene = new Scene(root, 300, 250, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World!");
        primaryStage.show();
    }
    public void changeButtonText(String newText){
        btn.setText(newText);
    }
  
	public void changeBgColor(String color) {
		root.setStyle("-fx-background-color: " + color);
	}
}