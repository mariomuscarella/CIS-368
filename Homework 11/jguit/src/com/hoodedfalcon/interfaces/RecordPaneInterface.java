
package com.hoodedfalcon.interfaces;

public interface RecordPaneInterface extends GridPaneInterface
{
	String getFirst();
	String getMiddle();
	String getLast();
	String getID();
	String getStreet();
	String getCity();
	String getState();
	String getZip();

	void setText(String text);

	void setFirstRed();
	void setMiddleRed();
	void setLastRed();
	void setIDRed();
	void setStreetRed();
	void setCityRed();
	void setZipRed();
	void setStateRed();

}

