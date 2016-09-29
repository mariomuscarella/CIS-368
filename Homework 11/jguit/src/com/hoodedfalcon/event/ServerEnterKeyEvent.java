
package com.hoodedfalcon.event;

import com.hoodedfalcon.interfaces.NewRecordInterface;
import com.hoodedfalcon.interfaces.ServerPaneInterface;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * SubmitServerEvent is triggered when the user clicks "Submit" in ServerGridPane.
 * This event checks that all fields within the view were filled, and then
 * connects to the Server.
 *
 * @see com.hoodedfalcon.view.NewRecordPane
 * @see NewRecordInterface
 */
public class ServerEnterKeyEvent implements EventHandler<KeyEvent>
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

	public void handle(KeyEvent event)
    {
		if (!(event.getCode() == KeyCode.ENTER))
		{
			return;
		}

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

