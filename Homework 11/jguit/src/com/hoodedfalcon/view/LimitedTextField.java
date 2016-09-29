
package com.hoodedfalcon.view;

import com.hoodedfalcon.event.LimitedKeyEvent;
import javafx.scene.control.TextField;

/**
 * LimitedTextField is a TextField which supports limiting the characters a user
 * can enter through the event LimitedKeyEvent.
 *
 * @see LimitedKeyEvent
 */
public class LimitedTextField extends TextField 
{
    /**
     * Constructs a new LimitedTextField.
     */
    public LimitedTextField(){}

    /**
     * Constructs a new LimitedTextField with a given Prompt Text.
     * @param promptText The String to display as a Prompt Text for the LimitedTextField.
     */
    public LimitedTextField(String promptText)
    {
        this.setPromptText(promptText);
    }

    /**
     * Initiates the LimitedTextField by specifying what the allowed text of the
     * LimitedTextField is.
     * @param allowedText A String of all characters that may be entered in the
     * LimitedTextField.
     */
    public void init(String allowedText)
    {
        LimitedKeyEvent limitedKeyEvent = new LimitedKeyEvent();
        limitedKeyEvent.init(allowedText);
        this.setOnKeyTyped(limitedKeyEvent);
    }
}
