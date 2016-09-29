
package com.hoodedfalcon.view;

import com.hoodedfalcon.event.GridMouseEvent;
import com.hoodedfalcon.event.ServerEnterKeyEvent;
import com.hoodedfalcon.event.SubmitServerEvent;
import com.hoodedfalcon.interfaces.ServerConnectInterface;
import com.hoodedfalcon.interfaces.ServerPaneInterface;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 * ServerGridPane is a GridPane View which lets the user connect to a server, which lets them use a database.
 *
 * When the user clicks "Submit" in the view, SubmitServerEvent is triggered, which connects to the server.
 *
 * @see com.hoodedfalcon.event.SubmitServerEvent
 */
public class ServerGridPane extends GridPane implements ServerPaneInterface
{
	private ServerConnectInterface sci;

	private Text txtServerAndPortPrompt = new Text("Enter a Server and Port.");
	private Text txtServerPrompt = new Text("Server:");
	private Text txtPortPrompt = new Text("Port:");

	private TextField txtfServer = new TextField();

	private LimitedTextField ltfPort = new LimitedTextField("Port");

	private Button button = new Button("Submit");

	private SubmitServerEvent submitEvent = new SubmitServerEvent();
	private ServerEnterKeyEvent submitEnterEvent = new ServerEnterKeyEvent();
	private GridMouseEvent gridMouseEvent = new GridMouseEvent();

	// Style values
	private final String strDefaultColor = "-fx-border-width: 0.5px; -fx-border-color: black; " +
			"-fx-background-color: white;";
	private final String strErrorColor = "-fx-border-width: 0.5px; -fx-border-color: black; " +
			"-fx-background-color: #FF5347;";

	/**
	 * Prepares the View by calling super.start(), sets the event for the View's button,
	 * and sets the Button's Text.
	 */
	public void start() 
    {
		txtfServer.setPromptText("Server");
		ltfPort.init("0123456789");

		gridMouseEvent.setGUI(this);
		submitEvent.setGUI(this);
		submitEnterEvent.setGUI(this);

		this.add(txtServerAndPortPrompt, 0, 0, 4, 1);

		this.add(txtServerPrompt, 0, 1);
		this.add(txtfServer, 1, 1, 2, 1);

		this.add(txtPortPrompt, 0, 2);
		this.add(ltfPort, 1, 2);

		this.add(button, 3, 3);

		button.setOnAction(submitEvent);
		this.setOnKeyPressed(submitEnterEvent);

		txtfServer.setStyle(strDefaultColor);
		txtfServer.setOnMouseClicked(gridMouseEvent);
		ltfPort.setStyle(strDefaultColor);
		ltfPort.setOnMouseClicked(gridMouseEvent);
	}

	public void connect(String server, int port)
	{
		sci.connect(server, port);
	}

	public void setSCI(ServerConnectInterface sci)
	{
		this.sci = sci;
	}

	public String getServer()
	{
		return txtfServer.getCharacters().toString();
	}

	public String getPort()
	{
		return ltfPort.getCharacters().toString();
	}

	public void setPortRed()
	{
		ltfPort.setStyle(strErrorColor);
	}

	public void setServerRed()
	{
		txtfServer.setStyle(strErrorColor);
	}



}
