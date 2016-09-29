package Feb24;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

 
public class MyApplicationLayout extends Application implements FlowPaneInterface, BorderPaneInterface, DialogPaneInterface{
    private Button btnfp1 = new Button();
    private Button btnfp2 = new Button();
    private Button btnleft = new Button();
    private Button btnDialog = new Button();
    private TextField tffp = new TextField();
    private BorderPane root = new BorderPane();
    private FlowPane fp = new FlowPane();
    private MyGridPane gp = new MyGridPane();
    private Stage ps = new Stage();  

    public void start(Stage primaryStage) {
     			    	    	
        EventBorder eb = new EventBorder();
        EventDialogPane ed = new EventDialogPane();
        
        ps = primaryStage;
        
        gp.init();
        eb.setGUI(this);
        ed.setGUI(this);
        primaryStage.setTitle("Hello World!");
        btnleft.setText("LEFT");
        btnDialog.setText("Open Dialog Box");
        btnleft.setOnAction(eb);
        btnDialog.setOnAction(ed);
        this.makeFlowPane();

        root.setBottom(fp);
        root.setLeft(btnleft);
        root.setCenter(gp);
        root.setRight(btnDialog);
        primaryStage.setScene(new Scene(root));
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public void makeFlowPane(){
        EventFlow ef = new EventFlow();

        ef.setGUI(this);
        btnfp1.setText("Flow Pane 1");
        btnfp1.setOnAction(ef);
        btnfp2.setText("Flow Pane 2");
        btnfp2.setOnAction(ef);
        fp.getChildren().add(btnfp1);
        fp.getChildren().add(btnfp2);
        fp.getChildren().add(tffp);
     }

    public String getText() {
      return (tffp.getText());
    }

    public void changeButtonText(String newText, Button b){
      b.setText(newText);
    }

    public void changeButtonBack(String c, Button b){
      String s = "-fx-background-color: " + c;
      b.setStyle(s);
    }
    
    public void changeFlowColor(String color, Button b) {
    	b.setStyle("-fx-background-color: " + color);
    }
   
	@Override
	public void setContentForDialogPane(DialogPane dig, MyGridPane grid) {		
		dig.setContent(grid);	
	}
}
