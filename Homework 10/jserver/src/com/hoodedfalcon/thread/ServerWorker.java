/** CIS 368 QUARTER 4 GROUP 2
 * MEMBERS:
 * GLEN FANNIN
 * JOHN LIGGETT
 * MARIO MUSCARELLA
 * CHRISTINA VECCHIO
 */

package com.hoodedfalcon.thread;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.hoodedfalcon.model.MyBoolean;
import com.hoodedfalcon.model.MyFile;
import com.hoodedfalcon.model.MyList;
import com.hoodedfalcon.model.nameaddress.AlphaString;
import com.hoodedfalcon.model.nameaddress.NameAddressId;
import com.hoodedfalcon.model.nameaddress.SingleName;

public class ServerWorker implements Runnable {
	private Socket socket;
	private MyFile myFile;
	private MyList<NameAddressId> recordsList;
	private MyList<Integer> deletedRecords;
	private MyList<Integer> editedRecords;

	private MyList<NameAddressId> clientNewRecords = new MyList<>();
	private MyList<Integer> clientNewDeletes = new MyList<>();

	private ObjectOutputStream objectOutputStream;
	private ObjectInputStream objectInputStream;

	private MyBoolean isEditBlockedGlobal;
	private MyBoolean isEditEnabled;

	public void initialize(Socket socket, MyFile recordsFile, MyList<NameAddressId> recordsList,
			MyList<Integer> deletedRecords, MyList<Integer> editedRecords) {
		this.socket = socket;
		this.myFile = recordsFile;
		this.recordsList = recordsList;
		this.deletedRecords = deletedRecords;
		this.editedRecords = editedRecords;
	}

	public void setMyBooleans(MyBoolean isEditBlockedGlobal, MyBoolean isEditEnabled) {
		this.isEditBlockedGlobal = isEditBlockedGlobal;
		this.isEditEnabled = isEditEnabled;
	}

	@Override
	public void run() {
		try {
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectInputStream = new ObjectInputStream(socket.getInputStream());

			if (isEditEnabled.get()) {
				System.out.println("edit enabled");
				objectOutputStream.writeObject("edit enabled");
			} else {
				System.out.println("edit disabled");
				objectOutputStream.writeObject("edit disabled");
			}

			String response = (String) objectInputStream.readObject();
			String words[];

			while (response.compareTo("client shutting down") != 0) {
				words = response.split(";");
				if (words[0].compareTo("update") == 0) {
					update(response);
				} else if (words[0].compareTo("load") == 0) {
					load(Integer.parseInt(words[1]));
				}

				response = (String) objectInputStream.readObject();
			}
			objectInputStream.close();
			objectOutputStream.close();
			socket.close();
			System.out.println("Client Disconnected!");

			if (isEditEnabled.get()) {
				synchronized (isEditBlockedGlobal.getLock()) {
					isEditBlockedGlobal.set(false);
					System.out.println("A new client can connect with write permissions!");
				}
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	private void load(int nextIndex) {
		synchronized (myFile.getLock()) {
			StringBuilder sb = new StringBuilder();
			try {
                FileInputStream fs = new FileInputStream(myFile.getFile());
                BufferedReader br = new BufferedReader(new InputStreamReader(fs));
                // skip fist line as it is a header
                br.readLine();
                for (int i = 0; i < nextIndex; ++i) {
                    // skipping unwanted records
                    br.readLine();
                }
                for (int i = 0; i < 10; i++) {
                    // retrieving records from the line we need to start at until
                    // the "nextIndex" line
                    String line;
                    try {
                        line = br.readLine();
                    } catch (EOFException eof) {
                        // End of file, nothing else to parse
                        break;
                    }
                    if (line == null) {
                        break;
                    }
					String words[] = line.split(",");
					// if the record line was edited by the edit client, don't send
					synchronized (deletedRecords.getLock())
					{
						synchronized (editedRecords.getLock())
						{
							if (deletedRecords.getList().contains(Integer.parseInt(words[0])) ||
									editedRecords.getList().contains(Integer.parseInt(words[0])))
							{
								i -= 1;
								continue;
							}
						}
					}
                    sb.append(line);
                    // only appends delimiter if not last record
                    if ((i + 1) < 10) {
                        sb.append(";");
                    }
                }
                br.close();
                objectOutputStream.writeObject(sb.toString());
            } catch (Throwable t) {
                t.printStackTrace();
            }
		}
	}

	private void update(String message) {
		String mainArray[] = message.split(";");
		String words[];
		NameAddressId naID = new NameAddressId();
		AlphaString alphaString = new AlphaString();
		SingleName singleName = new SingleName();

		for (int i = 1; i < mainArray.length; i++) {
			if (isInteger(mainArray[i])) {
				clientNewDeletes.getList().add(Integer.parseInt(mainArray[i]));
				continue;
			}

			words = mainArray[i].split(",");

			naID.setID(Integer.parseInt(words[0]));

			naID.setZip(Integer.parseInt(words[1]));

			alphaString.set(words[2]);
			singleName.set(alphaString);
			naID.setFirst(singleName);

			alphaString.set(words[3]);
			singleName.set(alphaString);
			naID.setMiddle(singleName);

			alphaString.set(words[4]);
			singleName.set(alphaString);
			naID.setLast(singleName);

			naID.setStreet(words[5]);

			alphaString.set(words[6]);
			singleName.set(alphaString);
			naID.setCity(singleName);

			alphaString.set(words[7]);
			singleName.set(alphaString);
			naID.setState(singleName);

			clientNewRecords.getList().add((NameAddressId) naID.clone());
		}

		synchronized (recordsList.getLock()) {
			synchronized (deletedRecords.getLock()) {
				for (int i = 0; i < clientNewDeletes.getList().size(); i++) {
					if (deletedRecords.getList().contains(clientNewDeletes.getList().get(i)))
						continue;

					deletedRecords.getList().add(clientNewDeletes.getList().get(i));
				}

				int max = recordsList.getList().size();
				for (int i = 0; i < max; i++) {
					if (clientNewDeletes.getList().contains(recordsList.getList().get(i).getID())) {
						recordsList.getList().remove(i);
						max--;
					}
				}

				for (int i = 0; i < clientNewRecords.getList().size(); i++) {
					recordsList.getList().add((NameAddressId) clientNewRecords.getList().get(i).clone());
				}

				synchronized (editedRecords.getLock())
				{
					for (int i =0; i < clientNewRecords.getList().size(); i++)
					{
						editedRecords.getList().add(clientNewRecords.getList().get(i).getID());
					}
				}

			}
		}

		clientNewRecords.getList().clear();
		clientNewDeletes.getList().clear();
	}

	private boolean isInteger(String string) {
		for (int i = 0; i < string.length(); i++) {
			if (!Character.isDigit(string.charAt(i)))
				return false;
		}
		return true;
	}
}
