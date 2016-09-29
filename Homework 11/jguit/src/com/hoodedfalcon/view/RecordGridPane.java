/** CIS 368 QUARTER 4 GROUP 2
 * MEMBERS:
 * GLEN FANNIN
 * JOHN LIGGETT
 * MARIO MUSCARELLA
 * CHRISTINA VECCHIO
 */

package com.hoodedfalcon.view;

import com.hoodedfalcon.event.GridMouseEvent;
import com.hoodedfalcon.event.PreviewTextEvent;
import com.hoodedfalcon.interfaces.RecordPaneInterface;
import com.hoodedfalcon.model.nameaddress.NameAddressId;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * RecordGridPane is the root View for adding and editing records.  NewRecordPane
 * and EditRecordPane both extend this object.
 */
public class RecordGridPane extends GridPane implements RecordPaneInterface
{
	// Setup the Text Prompts
	private Text txtNamePrompt = new Text("Enter Full Name.");
	private Text txtIdPrompt = new Text("Enter an ID:");
	private Text txtAddressPrompt = new Text("Enter Address.");

	// Setup the LimitedTextFields (which are restricted to certain characters
	private LimitedTextField ltfFirst = new LimitedTextField("First");
	private LimitedTextField ltfMiddle = new LimitedTextField("Middle");
	private LimitedTextField ltfLast = new LimitedTextField("Last");
	private LimitedTextField ltfId = new LimitedTextField("ID");
	private LimitedTextField ltfStreet = new LimitedTextField("Street");
	private LimitedTextField ltfCity = new LimitedTextField("City");
	private LimitedTextField ltfState = new LimitedTextField("State");
	private LimitedTextField ltfZip = new LimitedTextField("Zip");

	private Button previewButton = new Button("Preview");
	private Button submitButton = new Button();
	
	private Text txtPreviewDisplay = new Text();

	// Style values
	private final String strDefaultColor = "-fx-border-width: 0.5px; -fx-border-color: black; " +
			"-fx-background-color: white;";
	private final String strErrorColor = "-fx-border-width: 0.5px; -fx-border-color: black; " +
			"-fx-background-color: #FF5347;";
	private final String strDisabledColor = "-fx-border-width: 0.5px; -fx-border-color: black; " +
			"-fx-background-color: #A6A6A6;";

	private PreviewTextEvent previewEvent = new PreviewTextEvent();
	private GridMouseEvent gridMouseEvent = new GridMouseEvent();

	/**
	 * Initializes the GridPane, preparing and adding nodes to itself.
	 */
	public void start() 
    {
		String alphaOnly = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String numOnly = "0123456789";

		setLTFStyleAndEvent();

		ltfFirst.init(alphaOnly);
		ltfMiddle.init(alphaOnly);
		ltfLast.init(alphaOnly);
		ltfId.init(numOnly);
		ltfStreet.init(alphaOnly + numOnly + " .-*&@");
		ltfCity.init(alphaOnly);
		ltfState.init(alphaOnly);
		ltfZip.init(numOnly);

		previewEvent.setGUI(this);
		gridMouseEvent.setGUI(this);

		previewButton.setOnAction(previewEvent);
		
		submitButton.setText("Submit Record");

		this.add(txtNamePrompt, 0, 0, 3, 1);
		
		this.add(ltfFirst, 0, 1);
		this.add(ltfMiddle, 1, 1);
		this.add(ltfLast, 2, 1);

		this.add(txtIdPrompt, 0, 2, 2, 1);
		this.add(ltfId, 2, 2);

		this.add(txtAddressPrompt, 0, 3, 3, 1);

		this.add(ltfStreet, 0, 4, 3, 1);

		this.add(ltfCity, 0, 5);
		this.add(ltfState, 1, 5);
		this.add(ltfZip, 2, 5);
		
		this.add(previewButton, 0, 6);
		this.add(submitButton, 2, 6);
		
		this.add(txtPreviewDisplay, 1, 7);
	}

	/**
	 * Sets the EventHandler of the Submit button.
	 *
	 * @param event (EventHandler<ActionEvent>)
	 *            The event to launch when the submit button is pressed
	 */
	public void setButtonAction(EventHandler<ActionEvent> event)
	{
		submitButton.setOnAction(event);
	}

	/**
	 * Sets the Submit button's label.
	 *
	 * @param text
	 *            The label for the Submit button
	 */
	public void setSubmitButtonText(String text)
	{
		submitButton.setText(text);
	}

	/**
	 * Sets the text of each prompt from an existing NameAddressId.
	 *
	 * @param recordToUpdate (NAI)
	 *            The NameAddressId to set the prompt text from
	 */
	public void updatePrompts(NameAddressId recordToUpdate)
	{
		setFirst(recordToUpdate.getFirst().get());
		setMiddle(recordToUpdate.getMiddle().get());
		setLast(recordToUpdate.getLast().get());
		setID("" + recordToUpdate.getID());
		setStreet(recordToUpdate.getStreet());
		setCity(recordToUpdate.getCity().get());
		setState(recordToUpdate.getState().get());
		setZip("" + recordToUpdate.getZip());
	}

	/**
	 * Sets the style and onMouseClicked event for each LTF.
	 *
	 */
	private void setLTFStyleAndEvent()
	{
		ltfFirst.setStyle(strDefaultColor);
		ltfMiddle.setStyle(strDefaultColor);
		ltfLast.setStyle(strDefaultColor);
		ltfId.setStyle(strDefaultColor);
		ltfStreet.setStyle(strDefaultColor);
		ltfCity.setStyle(strDefaultColor);
		ltfState.setStyle(strDefaultColor);
		ltfZip.setStyle(strDefaultColor);

		ltfFirst.setOnMouseClicked(gridMouseEvent);
		ltfMiddle.setOnMouseClicked(gridMouseEvent);
		ltfLast.setOnMouseClicked(gridMouseEvent);
		ltfId.setOnMouseClicked(gridMouseEvent);
		ltfStreet.setOnMouseClicked(gridMouseEvent);
		ltfCity.setOnMouseClicked(gridMouseEvent);
		ltfState.setOnMouseClicked(gridMouseEvent);
		ltfZip.setOnMouseClicked(gridMouseEvent);
	}

	/**
	 * Sets the First Name LimitedTextField's text.
	 *
	 * @param text
	 *            The string to apply to the LTF
	 */
	private void setFirst(String text)
	{
		ltfFirst.setText(text);
	}

	/**
	 * Sets the Middle Name LimitedTextField's text.
	 *
	 * @param text
	 *            The string to apply to the LTF
	 */
	private void setMiddle(String text)
	{
		ltfMiddle.setText(text);
	}

	/**
	 * Sets the Last Name LimitedTextField's text.
	 *
	 * @param text
	 *            The string to apply to the LTF
	 */
	private void setLast(String text)
	{
		ltfLast.setText(text);
	}

	/**
	 * Sets the ID LimitedTextField's text.
	 *
	 * @param text
	 *            The string to apply to the LTF
	 */
	private void setID(String text)
	{
		ltfId.setText(text);
	}

	/**
	 * Sets the Street LimitedTextField's text.
	 *
	 * @param text
	 *            The string to apply to the LTF
	 */
	private void setStreet(String text)
	{
		ltfStreet.setText(text);
	}

	/**
	 * Sets the City LimitedTextField's text.
	 *
	 * @param text
	 *            The string to apply to the LTF
	 */
	private void setCity(String text)
	{
		ltfCity.setText(text);
	}

	/**
	 * Sets the State LimitedTextField's text.
	 *
	 * @param text
	 *            The string to apply to the LTF
	 */
	private void setState(String text)
	{
		ltfState.setText(text);
	}

	/**
	 * Sets the Zip LimitedTextField's text.
	 *
	 * @param text
	 *            The string to apply to the LTF
	 */
	private void setZip(String text)
	{
		ltfZip.setText(text);
	}

	/**
	 * Returns a String representing the data in the First Name LimitedTextField.
	 *
	 * @return 				The value entered in the First Name LimitedTextField.
	 */
	public String getFirst() 
    {
		return ltfFirst.getCharacters().toString();
	}

	/**
	 * Returns a String representing the data in the Middle Name LimitedTextField.
	 *
	 * @return 				The value entered in the Middle Name LimitedTextField.
	 */
	public String getMiddle() 
    {
		return ltfMiddle.getCharacters().toString();
	}

	/**
	 * Returns a String representing the data in the Last Name LimitedTextField.
	 *
	 * @return 				The value entered in the Last Name LimitedTextField.
	 */
	public String getLast() 
    {
		return ltfLast.getCharacters().toString();
	}

	/**
	 * Returns a String representing the data in the ID LimitedTextField.
	 *
	 * @return 				The value entered in the ID LimitedTextField.
	 */
	public String getID() 
    {
		return ltfId.getCharacters().toString();
	}

	/**
	 * Returns a String representing the data in the Street LimitedTextField.
	 *
	 * @return 				The value entered in the Street LimitedTextField.
	 */
	public String getStreet() 
    {
		return ltfStreet.getCharacters().toString();
	}

	/**
	 * Returns a String representing the data in the City LimitedTextField.
	 *
	 * @return 				The value entered in the City LimitedTextField.
	 */
	public String getCity() 
    {
		return ltfCity.getCharacters().toString();
	}

	/**
	 * Returns a String representing the data in the State LimitedTextField.
	 *
	 * @return 				The value entered in the State LimitedTextField.
	 */
	public String getState() 
    {
		return ltfState.getCharacters().toString();
	}

	/**
	 * Returns a String representing the data in the Zip LimitedTextField.
	 *
	 * @return 				The value entered in the Zip LimitedTextField.
	 */
	public String getZip() 
    {
		return ltfZip.getCharacters().toString();
	}

	/**
	 * Sets the text of the Preview Text Display.
	 *
	 * @param text
	 *            The string to apply to the Text Display.
	 */
	public void setText(String text) 
    {
		txtPreviewDisplay.setText(text);
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetY(3.0f);
		txtPreviewDisplay.setEffect(dropShadow);
		txtPreviewDisplay.setFont(Font.font("sans", FontWeight.BOLD, 14));
		setStyle("-fx-background-color: lightblue;");
	}

	/**
	 * Marks the First Name LimitedTextField as red indicating that it is empty.
	 *
	 */
	public void setFirstRed() 
    {
		ltfFirst.setStyle(strErrorColor);
	}

	/**
	 * Marks the Middle Name LimitedTextField as red indicating that it is empty.
	 *
	 */
	public void setMiddleRed() 
    {
		ltfMiddle.setStyle(strErrorColor);
	}

	/**
	 * Marks the Last Name LimitedTextField as red indicating that it is empty.
	 *
	 */
	public void setLastRed() 
    {
		ltfLast.setStyle(strErrorColor);
	}

	/**
	 * Marks the ID LimitedTextField as red indicating that it is empty.
	 *
	 */
	public void setIDRed() 
    {
		ltfId.setStyle(strErrorColor);
	}

	/**
	 * Marks the Street LimitedTextField as red indicating that it is empty.
	 *
	 */
	public void setStreetRed() 
    {
		ltfStreet.setStyle(strErrorColor);
	}

	/**
	 * Marks the City LimitedTextField as red indicating that it is empty.
	 *
	 */
	public void setCityRed() 
    {
		ltfCity.setStyle(strErrorColor);
	}

	/**
	 * Marks the State LimitedTextField as red indicating that it is empty.
	 *
	 */
	public void setStateRed() 
    {
		ltfState.setStyle(strErrorColor);
	}

	/**
	 * Marks the Zip LimitedTextField as red indicating that it is empty.
	 *
	 */
	public void setZipRed() 
    {
		ltfZip.setStyle(strErrorColor);
	}

	/**
	 * Disables the ID LimitedTextField if the argument is true.
	 *
	 * @param value true disables the field, false enables it
	 */
	public void setIDFieldDisabled(boolean value)
	{
		ltfId.setEditable(!value);
		String style = value ? strDisabledColor : strDefaultColor;
		GridMouseEvent event = value ? null : gridMouseEvent;
		ltfId.setStyle(style);
		ltfId.setOnMouseClicked(event);
	}

}


