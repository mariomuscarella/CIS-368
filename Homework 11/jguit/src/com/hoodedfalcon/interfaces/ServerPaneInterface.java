
package com.hoodedfalcon.interfaces;

public interface ServerPaneInterface extends ServerConnectInterface, GridPaneInterface
{
	void connect(String server, int port);

	String getServer();
	String getPort();

	void setServerRed();
	void setPortRed();

}

