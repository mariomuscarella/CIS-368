

package com.hoodedfalcon.event;

import com.hoodedfalcon.view.EditRecordPane;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

/**
 * LimitedKeyEvent is an event which limits the characters that are allowed to be used
 * in LimitedTextFields.  This is used in NewRecordPane, EditRecordPane, and ServerGridPane.
 *
 * @see com.hoodedfalcon.view.LimitedTextField
 * @see com.hoodedfalcon.view.NewRecordPane
 * @see EditRecordPane
 */
public class LimitedKeyEvent implements EventHandler<KeyEvent> 
{
  private String allowedText;

  public void init(String s)
  {
    allowedText = s;
  }

  public void handle(KeyEvent ke)
  {
    String c = ke.getCharacter();
    if (!allowedText.contains(c))
    {
        ke.consume();
    }
  }

}

