/** CIS 368 QUARTER 4 GROUP 2
 * MEMBERS:
 * GLEN FANNIN
 * JOHN LIGGETT
 * MARIO MUSCARELLA
 * CHRISTINA VECCHIO
 */

package com.hoodedfalcon.control;

import com.hoodedfalcon.model.*;
import com.hoodedfalcon.event.*;
import com.hoodedfalcon.interfaces.MainAppInterface;
import com.hoodedfalcon.model.nameaddress.NameAddressId;
import com.hoodedfalcon.view.MyListPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 * <p>
 * The Main File for the NameAddressId GUI Manager.  MyApplication is an application
 * which allows users to manage a database of NameAddressId objects (which is stored
 * in a connected database server).
 * </p>
 *
 * <p>
 * Only ten records are allowed to be stored in memory at a time, forcing the user to
 * load the next ten records from the menu when necessary.  Edited records are saved
 * to the server every minute.
 * </p>
 *
 * <p>
 * The main view of the Application is a List View along with a Menu, which includes
 * Menu Items to Connect & Disconnect to/from a Server, Load the Next Ten Records, Add
 * a New Record, Edit a Record, and Delete a Record.
 * </p>
 *
 * <p>
 * Both creating and editing a record launches a new view - NewRecordPane or EditRecordPane.
 * Similar to those views, connecting to a server launches a view - ServerGridPane.
 * </p>
 *
 * @see com.hoodedfalcon.view.NewRecordPane
 * @see com.hoodedfalcon.view.EditRecordPane
 * @see com.hoodedfalcon.view.ServerGridPane
 * @see MyListPane
 */
public class MyApplication extends Application implements MainAppInterface
{
	// Views & view components
	private Scene scene;
	private BorderPane bpRoot = new BorderPane();
	private MyListPane listPane = new MyListPane();
	private MenuBar menuBar = new MenuBar();

	final private Menu serverMenu = new Menu("Server");
	final private Menu recordsMenu = new Menu("Records");
	final private Menu editMenu = new Menu("Edit");

	final private MenuItem mniConnectServer = new MenuItem("Connect to Server");
	final private MenuItem mniDisconnectServer = new MenuItem("Disconnect Server");
	final private MenuItem mniLoadNextRecords = new MenuItem("Load Next Ten Records");
	final private MenuItem mniLoadPreviousRecords = new MenuItem("Load Previous Ten Records");
	final private MenuItem mniAddRecord = new MenuItem("New Record");
	final private MenuItem mniEditRecord = new MenuItem("Edit Selected Record");
	final private MenuItem mniDeleteRecord = new MenuItem("Delete Selected Record");

	// Event Controls
	private ServerConnectEvent serverConnectEvent = new ServerConnectEvent();
	private ServerDisconnectEvent serverDisconnectEvent = new ServerDisconnectEvent();
	private LoadNextRecordsEvent loadNextRecordsEvent = new LoadNextRecordsEvent();
	private LoadPrevRecordsEvent loadPrevRecordsEvent = new LoadPrevRecordsEvent();
	private NewRecordEvent recordEvent = new NewRecordEvent();
	private EditRecordEvent updateEvent = new EditRecordEvent();
	private DeleteRecordEvent deleteEvent = new DeleteRecordEvent();
	private ApplicationCloseEvent closeEvent = new ApplicationCloseEvent();
	private DeleteRecordKeyEvent deleteRecordKeyEvent = new DeleteRecordKeyEvent();

	// Main Controllers
	private ThreadManager threadManager = new ThreadManager();
	private ConnectionManager connectionManager = new ConnectionManager();
	private AlertManager alertManager = new AlertManager();

	// Miscellaneous Data
	private Socket socket;
	private ObjectOutputStream objectOutputStream;
	private ObjectInputStream objectInputStream;

	private Stage stage;

	private ArrayList<NameAddressId> recordsList = new ArrayList<>();

	// MyBoolean States
	private MyBoolean isEditEnabled = new MyBoolean();
	private MyBoolean loadState = new MyBoolean();
	private MyBoolean updateState = new MyBoolean();

	// Records that still need to be saved to the file.
	private MyBoolean pendingRecords[] = new MyBoolean[10];
	private ArrayList<Integer> deletedRecords = new ArrayList<>();

	/**
	 * The main entry point of the Application, inherited from Application.  This
	 * method prepares the primary stage for the application, by adding a MyListPane
	 * and a Menu Bar to itself.  It also sets the events of each Menu Item, prepares
	 * the threads, and starts the Update Thread and Backup Thread.
	 *
	 * @param primaryStage The primary stage for this application.
     */
	public void start(Stage primaryStage)
    {
		stage = primaryStage;
		primaryStage.setTitle("NameAddressId Database Client");
		primaryStage.setOnCloseRequest(closeEvent);

		for (int i = 0; i < pendingRecords.length; i++)
		{
			pendingRecords[i] = new MyBoolean();
		}

		threadManager.initialize(this, socket, objectOutputStream, objectInputStream, recordsList,
									deletedRecords, pendingRecords, loadState, updateState, isEditEnabled,
									connectionManager);
		threadManager.prepareUpdateThread();

		connectionManager.setMAI(this);

		mniConnectServer.setOnAction(serverConnectEvent);
		mniDisconnectServer.setOnAction(serverDisconnectEvent);
		mniLoadNextRecords.setOnAction(loadNextRecordsEvent);
		mniLoadPreviousRecords.setOnAction(loadPrevRecordsEvent);
		mniAddRecord.setOnAction(recordEvent);
		mniEditRecord.setOnAction(updateEvent);
		mniDeleteRecord.setOnAction(deleteEvent);

		serverConnectEvent.setMAI(this);
		serverDisconnectEvent.setMAI(this);
	    loadNextRecordsEvent.setMAI(this);
		loadPrevRecordsEvent.setMAI(this);
		recordEvent.setMAI(this);
		updateEvent.setMAI(this);
		deleteEvent.setMAI(this);
		deleteRecordKeyEvent.setMAI(this);

		loadNextRecordsEvent.setThreadManager(threadManager);
		loadPrevRecordsEvent.setThreadManager(threadManager);
		serverConnectEvent.setThreadManager(threadManager);
		closeEvent.setThreadManager(threadManager);
		serverDisconnectEvent.setThreadManager(threadManager);

		closeEvent.setMAI(this);
		closeEvent.setStatuses(updateState, loadState);
		closeEvent.setStage(primaryStage);

		serverConnectEvent.setConnectionManager(connectionManager);
		serverDisconnectEvent.setConnectionManager(connectionManager);
		closeEvent.setConnectionManager(connectionManager);
		loadNextRecordsEvent.setConnectionManager(connectionManager);
		loadPrevRecordsEvent.setConnectionManager(connectionManager);

		serverConnectEvent.setPendingRecords(pendingRecords);
		serverDisconnectEvent.setPendingRecords(pendingRecords);
		closeEvent.setPendingRecords(pendingRecords);
		loadNextRecordsEvent.setPendingRecords(pendingRecords);
		loadPrevRecordsEvent.setPendingRecords(pendingRecords);

		connectionManager.setAlertManager(alertManager);
		closeEvent.setAlertManager(alertManager);
		loadNextRecordsEvent.setAlertManager(alertManager);
		loadPrevRecordsEvent.setAlertManager(alertManager);
		serverConnectEvent.setAlertManager(alertManager);
		serverDisconnectEvent.setAlertManager(alertManager);

		deleteRecordKeyEvent.setIsEditEnabled(isEditEnabled);
		serverConnectEvent.setIsEditEnabled(isEditEnabled);

		closeEvent.setDeletedRecords(deletedRecords);
		serverConnectEvent.setDeletedRecords(deletedRecords);
		serverDisconnectEvent.setDeletedRecords(deletedRecords);

		listPane.start();

		serverMenu.getItems().addAll(mniConnectServer, mniDisconnectServer);
		recordsMenu.getItems().addAll(mniLoadNextRecords, mniLoadPreviousRecords, mniAddRecord);
		editMenu.getItems().addAll(mniEditRecord, mniDeleteRecord);
		
		menuBar.getMenus().addAll(serverMenu, recordsMenu, editMenu);

		listPane.setOnKeyPressed(deleteRecordKeyEvent);

		bpRoot.setTop(menuBar);
		bpRoot.setCenter(listPane);

		scene = new Scene(bpRoot, 350, 450);

		setLoadDisable(true);
		setEditMenuDisable(true);

		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.show();

		threadManager.startUpdateThread();
	}

	/**
	 * Sets whether the two Record Loading MenuItems are disabled:
	 * Load Next Ten Records & Load Previous Ten Records.
	 *
	 * @param value true will disable the MenuItems, false will enable them.
	 */
	public void setLoadDisable(boolean value)
	{
		mniLoadNextRecords.setDisable(value);
		mniLoadPreviousRecords.setDisable(value);
		mniDisconnectServer.setDisable(value);
	}

	/**
	 * Sets whether the three Record Editing MenuItems are disabled: Add Record,
	 * Edit Record, and Delete Record.
	 *
	 * @param value true will disable the MenuItems, false will enable them.
     */
	public void setEditMenuDisable(boolean value)
	{
		synchronized (isEditEnabled.getLock())
		{
			isEditEnabled.set(!value);
		}
		mniAddRecord.setDisable(value);
		mniEditRecord.setDisable(value);
		mniDeleteRecord.setDisable(value);
	}

	public void setReadOnlyStyle(boolean value)
	{
		if (value)
		{
			scene.getStylesheets().add(this.getClass().getResource("/com/hoodedfalcon/view/list.css").toExternalForm());
			stage.setTitle("[READ-ONLY] NameAddressId Database Client");
		}
		else
		{
			if (!scene.getStylesheets().contains(this.getClass().
					getResource("/com/hoodedfalcon/view/list.css").toExternalForm())) return;
			scene.getStylesheets().remove(this.getClass().getResource("/com/hoodedfalcon/view/list.css").toExternalForm());
			stage.setTitle("NameAddressId Database Client");
		}
	}

    /**
	 * Updates a record in the GUI.
	 *
	 * @param nameAddress The revised record.
	 * @param index The index at which the record is stored in the GUI.
     */
    public void update(NameAddressId nameAddress, int index)
	{
		NameAddressId clonedNameAddress = new NameAddressId(nameAddress);
		String text = clonedNameAddress.getFirst().get() + " " +
				clonedNameAddress.getMiddle().get() + " " +
				clonedNameAddress.getLast().get() + ", " +
				clonedNameAddress.getID() + "\n" +
				clonedNameAddress.getStreet() + "\n" +
				clonedNameAddress.getCity().get() + ", " +
				clonedNameAddress.getState().get() + "\n" +
				clonedNameAddress.getZip();
		synchronized (recordsList)
		{
			recordsList.set(index,  clonedNameAddress);
		}
		listPane.update(text, index);
		synchronized (pendingRecords)
		{
			pendingRecords[index].set(true);
		}
	}

    /**
	 * Removes a record from the GUI.
	 *
	 * @param index The index of the record to remove.
     */
    public void delete(int index)
    {
		synchronized (pendingRecords)
		{
			if (index != 10)
			{
				for (int i = index; i < 9; i++)
				{
					pendingRecords[i].set(pendingRecords[i+1].get());
				}
				pendingRecords[9].set(false);
			}
		}
		synchronized (deletedRecords)
		{
			deletedRecords.add(Integer.valueOf(recordsList.get(index).getID()));
		}
		synchronized (recordsList)
		{
			recordsList.remove(index);
		}
		listPane.remove(index);
    }

	/**
	 * Adds a NameAddressId if possible.  May fail if there is no file loaded.
	 * In the case of a failure, the Application will inform the user to either
	 * load a file, or create a new file (both of these are available under the
	 * File Menu).
	 *
	 * In the case that there are already ten records in memory, one of the records
	 * will be removed from memory.
	 *
	 * @param nameAddress The NameAddressId to add to the GUI
     */
	public void add(NameAddressId nameAddress, boolean wasLoaded)
    {
		boolean outcome = true;

		if (recordsList.size() > 9)
		{
			outcome = removeAnEntry();
		}

		if (!outcome)
		{
			alertManager.alert(AlertMessage.NO_SPACE);
			threadManager.forceUpdate();
			return;
		}

		NameAddressId clonedNameAddress = new NameAddressId(nameAddress);
		String text = clonedNameAddress.getFirst().get() + " " + 
            clonedNameAddress.getMiddle().get() + " " +
			clonedNameAddress.getLast().get() + ", " + 
            clonedNameAddress.getID() + "\n" +
			clonedNameAddress.getStreet() + "\n" +
			clonedNameAddress.getCity().get() + ", " + 
            clonedNameAddress.getState().get() + "\n" +
			clonedNameAddress.getZip();

		synchronized (recordsList)
		{
			recordsList.add(clonedNameAddress);
		}

		synchronized (pendingRecords)
		{
			if (!wasLoaded)	pendingRecords[recordsList.size() -1].set(true);
		}

		listPane.add(text);
	}

	public void add(NameAddressId nameAddressId)
	{
		this.add(nameAddressId, false);
	}

	/**
	 * Removes an entry from the GUI, which has not been edited recently.
	 * @return false if failed, true if succeeded.
	 */
	private boolean removeAnEntry()
	{
		for (int i = 0; i < recordsList.size(); i++)
		{
			synchronized (pendingRecords)
			{
				if (!(pendingRecords[i].get()))
				{
					delete(i);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Returns the list of NameAddressId objects.
	 * @return The list of NameAddressId objects.
     */
	public ArrayList<NameAddressId> getList() 
    {
		return recordsList;
	}

	/**
	 * Clears all records from the GUI.
	 */
	public void clearList() 
    {
		synchronized (recordsList)
		{
			recordsList.clear();
		}

		listPane.clearListView();

		synchronized (pendingRecords)
		{
			for (int i = 0; i < pendingRecords.length; i++)
			{
				pendingRecords[i].set(false);
			}
		}
	}

	/**
	 * Returns the primary Stage.
	 * @return The primary Stage of the Application.
     */
	public Stage getStage()
    {
		return (Stage) bpRoot.getScene().getWindow();
	}

	/**
	 * Returns the index of the selected record in the GUI.
	 * @return The index of the selected record. -1 if no record is selected.
     */
	public int getSelectedIndex()
	{
		return listPane.getSelectedIndex();
	}

	/**
	 * Gets the NameAddressId, which will be updated.  This is used by EditRecordEvent.
	 *
	 * @see EditRecordEvent
	 * @param index The index of the record in the GUI.  This index is obtained through
	 *              the method getSelectedIndex() in this file.
	 * @return The NameAddressId currently in memory, to be edited.
     */
	public NameAddressId getRecordToUpdate(int index)
	{
		synchronized (recordsList)
		{
			return recordsList.get(index);
		}
	}

	public void setSocket(Socket socket)
	{
		this.socket = socket;
		threadManager.setSocket(socket);
	}

	public void setStreams(ObjectOutputStream objectOutputStream, ObjectInputStream objectInputStream)
	{
		this.objectOutputStream = objectOutputStream;
		this.objectInputStream = objectInputStream;
		threadManager.setStreams(objectOutputStream, objectInputStream);
	}


}


