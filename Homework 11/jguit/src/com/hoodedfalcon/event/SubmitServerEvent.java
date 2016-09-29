
package com.hoodedfalcon.event;

import com.hoodedfalcon.interfaces.NewRecordInterface;
import com.hoodedfalcon.interfaces.ServerPaneInterface;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * SubmitServerEvent is triggered when the user clicks "Submit" in ServerGridPane.
 * This event checks that all fields within the view were filled, and then
 * connects to the Server.
 *
 * @see com.hoodedfalcon.view.NewRecordPane
 * @see NewRecordInterface
 */
public class SubmitServerEvent implements EventHandler<ActionEvent>
{
	private ServerPaneInterface spi;

	public void setGUI(ServerPaneInterface spi)
    {
		this.spi = spi;
	}

	public ServerPaneInterface getGUI()
    {
		return spi;
	}

	public void handle(ActionEvent event) 
    {
		boolean error = false;

		if (spi.getServer().equals(""))
		{
			spi.setServerRed();
			error = true;
		}
		if (spi.getPort().equals(""))
		{
			spi.setPortRed();
			error = true;
		}

		if (error) return;

		spi.connect(spi.getServer(), Integer.parseInt(spi.getPort()));
	}
}

