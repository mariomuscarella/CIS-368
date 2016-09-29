/** CIS 368 QUARTER 4 GROUP 2
 * MEMBERS:
 * GLEN FANNIN
 * JOHN LIGGETT
 * MARIO MUSCARELLA
 * CHRISTINA VECCHIO
 */

package com.hoodedfalcon.interfaces;

public interface ServerPaneInterface extends ServerConnectInterface, GridPaneInterface
{
	void connect(String server, int port);

	String getServer();
	String getPort();

	void setServerRed();
	void setPortRed();

}

