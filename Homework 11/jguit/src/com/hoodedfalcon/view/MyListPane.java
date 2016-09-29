
package com.hoodedfalcon.view;

import com.hoodedfalcon.interfaces.ListPaneInterface;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;

/**
 * MyListPane is a View which features a ListView of the NameAddressId records,
 * which are represented by a String.
 */
public class MyListPane extends StackPane implements ListPaneInterface
{
	private ListView<String> list = new ListView<>();
	private ObservableList<String> items  = FXCollections.observableArrayList();

    /**
     * Starts the MylistPane object, and adds the ListView to the View.
     */
	public void start()
    {
        list.prefWidthProperty().bind(this.widthProperty());
        list.prefHeightProperty().bind(this.heightProperty());
        this.getChildren().add(list);
    }

    /**
     * Returns the index of the selected record in the ListView.
     * @return The index of the selected record in the ListView.
     */
    public int getSelectedIndex()
    {
        return list.getSelectionModel().getSelectedIndex();
    }

    /**
     * Updates a String representation of a record.
     * @param revision The new String representation for a record.
     * @param index The index of the record to get updated.
     */
    public void update(String revision, int index)
    {
        items.set(index, revision);
        list.setItems(items);
    }

    /**
     * Removes a record from the ListView.
     * @param index The index of the record to be removed.
     */
    public void remove(int index)
    {
        items.remove(index);
        list.setItems(items);
    }

    /**
     * Adds a record to the ListView.
     * @param newEntry The String representation of a record.
     */
	public void add(String newEntry) 
    {
		items.addAll(newEntry);
		list.setItems(items);
	}

    /**
     * Clears the ListView of all its records.
     */
	public void clearListView()
    {
		items.clear();
        list.setItems(items);
	}

}

