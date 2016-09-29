

package com.hoodedfalcon.control;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import com.hoodedfalcon.interfaces.MainAppInterface;
import com.hoodedfalcon.model.AlertMessage;
import com.hoodedfalcon.model.nameaddress.AlphaString;
import com.hoodedfalcon.model.nameaddress.NameAddressId;
import com.hoodedfalcon.model.nameaddress.SingleName;

import javafx.concurrent.Task;

/**
 * LoadNextTenTask is a JavaFX Task which is called on the JavaFX Application
 * Thread to load the next ten records into memory from the server.
 */
public class LoadNextTenTask extends Task<ArrayList<NameAddressId>> {
	private MainAppInterface mai;
	private ArrayList<NameAddressId> newRecordsList = new ArrayList<>();
	private AlertManager alertManager = new AlertManager();
	private Socket socket;
	private String recordString;
	private ObjectOutputStream objectOutputStream;
	private ObjectInputStream objectInputStream;
	private ConnectionManager connectionManager;
	private boolean error = false;

	// The next index of the starting ten records
	private int nextIndex;

	@Override
	protected ArrayList<NameAddressId> call() {
		requestRecords();

		if (error)
		{
			return null;
		}

		CSVProcessor();

		return newRecordsList;
	}

	private void requestRecords() {
		String response;
		try {
			objectOutputStream.writeObject("load;"+(nextIndex));

			response = (String) objectInputStream.readObject();
			
		} catch(Exception e)
		{
			connectionManager.disconnect();
			alertManager.alert(AlertMessage.SERVER_ERROR);
			error = true;
			return;
		}
		
		setRecordString(response);
	}

	private void CSVProcessor() {
		if (getRecordString() == null || getRecordString().isEmpty()) {
			newRecordsList.clear();
			return;
		}
		SingleName singleName = new SingleName();
		AlphaString alphaString = new AlphaString();

		String[] records = getRecordString().split(";");

		for (String record : records) {
			String[] recordValues = record.split(",");

			NameAddressId naID = new NameAddressId();
			naID.setID(Integer.parseInt(recordValues[0]));

			naID.setZip(Integer.parseInt(recordValues[1]));

			alphaString.set(recordValues[2]);
			singleName.set(alphaString);
			naID.setFirst(singleName);

			alphaString.set(recordValues[3]);
			singleName.set(alphaString);
			naID.setMiddle(singleName);

			alphaString.set(recordValues[4]);
			singleName.set(alphaString);
			naID.setLast(singleName);

			naID.setStreet(recordValues[5]);

			alphaString.set(recordValues[6]);
			singleName.set(alphaString);
			naID.setCity(singleName);

			alphaString.set(recordValues[7]);
			singleName.set(alphaString);
			naID.setState(singleName);

			newRecordsList.add(naID);
			nextIndex++;
		}
	}

	public void setNextIndex(int index) {
		nextIndex = index;
	}

	public void setStreams(ObjectOutputStream objectOutputStream, ObjectInputStream objectInputStream) {
		this.objectOutputStream = objectOutputStream;
		this.objectInputStream = objectInputStream;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public String getRecordString() {
		return recordString;
	}

	public void setRecordString(String recordString)
	{
		this.recordString = recordString;
	}

	public void setConnectionManager(ConnectionManager connectionManager)
	{
		this.connectionManager = connectionManager;
	}

}

