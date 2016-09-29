/** CIS 368 QUARTER 4 GROUP 2
 * MEMBERS:
 * GLEN FANNIN
 * JOHN LIGGETT
 * MARIO MUSCARELLA
 * CHRISTINA VECCHIO
 */

package com.hoodedfalcon.event;

import com.hoodedfalcon.interfaces.GridPaneInterface;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * GridMouseEvent is triggered when the user clicks within a LimitedTextField, and changes
 * the style of the LimitedTextField from red to the default style.  This is used in all
 * NewRecordPane, EditRecordPane, and ServerGridPane.
 *
 * @see com.hoodedfalcon.view.LimitedTextField
 * @see com.hoodedfalcon.view.NewRecordPane
 * @see com.hoodedfalcon.view.ServerGridPane
 * @see com.hoodedfalcon.view.EditRecordPane
 */
public class GridMouseEvent implements EventHandler<MouseEvent>
{
	private GridPaneInterface gpi;

	public void setGUI(GridPaneInterface gpi)
	{
		this.gpi = gpi;
	}

	public GridPaneInterface getGUI(GridPaneInterface gpi)
	{
		return gpi;
	}

	@Override
	public void handle(MouseEvent event) 
    {
		Object object;
		TextField ltf;

		object = event.getSource();

		if (!(object instanceof Button))
        {
			ltf = (TextField) event.getSource();

			ltf.setStyle("-fx-border-width: 0.5px; -fx-border-color: black; -fx-background-color: white;");
		}
		else
        {
			event.consume();
		}
	}
}
