/** CIS 368 QUARTER 4 GROUP 2
 * MEMBERS:
 * GLEN FANNIN
 * JOHN LIGGETT
 * MARIO MUSCARELLA
 * CHRISTINA VECCHIO
 */

package com.hoodedfalcon.control;

import com.hoodedfalcon.model.AlertMessage;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;

import java.util.Optional;

/**
 * AlertManager is a convenience object that creates alerts based on a
 * specified AlertMessage.
 *
 * @see AlertMessage
 */
public class AlertManager
{
    public Optional<ButtonType> alert(AlertMessage message)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        switch (message)
        {
            case NO_SPACE:
                alert.setTitle("No Available Space");
                alert.setHeaderText("There is no available space for another record!");
                alert.setContentText("There are currently ten records in memory, and each of " +
                        "these records are yet to be updated in the database.  Please wait one " +
                        "minute before trying to add a new record.");
                break;
            case CONNECTION_REFUSED:
                alert.setTitle("Connection Refused!");
                alert.setHeaderText("The connection with the server was refused!");
                alert.setContentText("The requested server could not be connected to!  Please make sure that " +
                        "the server is running, and then try to reconnect again.");
                break;
            case UNKNOWN_HOST:
                alert.setTitle("Unknown Host!");
                alert.setHeaderText("Could not connect to the server!");
                alert.setContentText("Could not connect to the requested server!  Please make sure that the " +
                        "server and port are correct, and that the server is running!");
                break;
            case READ_ONLY_MODE:
                alert.setAlertType(Alert.AlertType.WARNING);
                alert.setTitle("Read Only Mode!");
                alert.setHeaderText("You are accessing the server in Read Only Mode.");
                alert.setContentText("A client is already connected to the server with write access, so " +
                        "your client can only read records.  Connect again at a later time to gain write access " +
                        "to the database.");
                break;
            case EMPTY_DATABASE:
                alert.setAlertType(Alert.AlertType.WARNING);
                alert.setTitle("Empty Database!");
                alert.setHeaderText("The server you connected to does not store any records.");
                alert.setContentText("There are no records in the database of the server you connected " +
                        "to!  Create new records, and these will be added to the server!");
                break;
            case EMPTY_DATABASE_ROM:
                alert.setAlertType(Alert.AlertType.WARNING);
                alert.setTitle("Empty Database!");
                alert.setHeaderText("The server you connected to does not store any records.");
                alert.setContentText("There are no records in the database of the server you connected " +
                        "to!  Unfortunately, you are in Read Only Mode, as there is someone else connected " +
                        "to the server!  To add new records or edit the records that get added, please connect " +
                        "at a later time!");
                break;
            case NO_PREVIOUS_RECORDS:
                alert.setTitle("No Previous Records!");
                alert.setHeaderText("There were no records found before the current records!");
                alert.setContentText("The server could not find any records before the currently loaded " +
                        "records.  To load other records, try \"Load Next Ten Records\"");
                break;
            case NO_ADDITIONAL_RECORDS:
                alert.setTitle("No Additional Records!");
                alert.setHeaderText("Could not find additional records!");
                alert.setContentText("The server could not find any additional records!  The currently loaded " +
                        "records will remain in memory.");
                break;
            case CONNECTION_OVERRIDING:
                alert.setAlertType(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirm Connection!");
                alert.setHeaderText("Your new connection will terminate your existing confirmation!");
                alert.setContentText("Your current connection will terminated.  Are you sure you wish to disconnect?");
                break;
            case DISCONNECT_UNSAVED_RECORDS:
                alert.setAlertType(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Unsaved Records!");
                alert.setHeaderText("You have unsaved records!  Confirm you wish to disconnect!");
                alert.setContentText("Your records are not yet updated at the server!  The records should be updated " +
                        "shortly.  Do you still wish to disconnect from the current server?");
                break;
            case CLOSE_UNSAVED_RECORDS:
                alert.setAlertType(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Unsaved Records!");
                alert.setHeaderText("You have unsaved records!  Confirm you wish to exit!");
                alert.setContentText("Your records are not yet updated!  They should be updated shortly.  Do you still " +
                        "wish to close the application?");
                break;
            case LOAD_UNSAVED_RECORDS:
                alert.setAlertType(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Unsaved Records!");
                alert.setHeaderText("You have unsaved records!  Confirm you wish to load records!");
                alert.setContentText("Your records are not yet updated!  They should be updated shortly.  Do you still " +
                        "wish to load new records (removing your existing records from memory)?");
                break;
            case SERVER_ERROR:
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setTitle("Server Error!");
                alert.setTitle("There was an error with the server!");
                alert.setContentText("There was an error with the server, and the client was forced to disconnect! " +
                        "Check whether the server was stopped, and connect at a later time.");
                break;
            case SERVER_ERROR_UPDATING:
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setTitle("Server Error!");
                alert.setTitle("There was an error with the server!");
                alert.setContentText("There was an error connecting to the server while updating!  Please make sure " +
                        "to save your recent revisions to records and then disconnect from the server.");
                break;
        }

        alert.initModality(Modality.APPLICATION_MODAL);
        return alert.showAndWait();
    }


}

