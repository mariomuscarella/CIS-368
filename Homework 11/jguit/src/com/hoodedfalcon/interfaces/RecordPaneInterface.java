/** CIS 368 QUARTER 4 GROUP 2
 * MEMBERS:
 * GLEN FANNIN
 * JOHN LIGGETT
 * MARIO MUSCARELLA
 * CHRISTINA VECCHIO
 */

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

