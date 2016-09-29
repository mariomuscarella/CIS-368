
package com.hoodedfalcon.interfaces;

public interface ListPaneInterface 
{
    void update(String revision, int index);
    void remove(int index);
	void add(String newEntry);
	void clearListView();

}

