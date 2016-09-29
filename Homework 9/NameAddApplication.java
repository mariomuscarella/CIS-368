import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class NameAddApplication extends Application implements BorderPaneInterface{
    private NameGridPane ngp = new NameGridPane();
    private BorderPane root = new BorderPane();
    
	public void start(Stage primaryStage) {
		EventBorder eb = new EventBorder();
		
		ngp.init();
		eb.setGUI(this);
		primaryStage.setTitle("Name Address Id");
		root.setCenter(ngp);
		primaryStage.setScene(new Scene(root));
        primaryStage.sizeToScene();
        primaryStage.show();
	}

}
