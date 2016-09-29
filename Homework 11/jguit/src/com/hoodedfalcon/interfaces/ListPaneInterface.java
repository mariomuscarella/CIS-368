/** CIS 368 QUARTER 4 GROUP 2
 * MEMBERS:
 * GLEN FANNIN
 * JOHN LIGGETT
 * MARIO MUSCARELLA
 * CHRISTINA VECCHIO
 */

package com.hoodedfalcon.interfaces;

public interface ListPaneInterface 
{
    void update(String revision, int index);
    void remove(int index);
	void add(String newEntry);
	void clearListView();

}

