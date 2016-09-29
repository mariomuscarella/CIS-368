/** CIS 368 QUARTER 4 GROUP 2
 * MEMBERS:
 * GLEN FANNIN
 * JOHN LIGGETT
 * MARIO MUSCARELLA
 * CHRISTINA VECCHIO
 */

package com.hoodedfalcon.interfaces;

import com.hoodedfalcon.model.nameaddress.NameAddressId;
import javafx.stage.Stage;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public interface MainAppInterface 
{
	void update(NameAddressId nameAddress, int index);
	void delete(int index);
	void add(NameAddressId nameAddress);
	void add(NameAddressId nameAddress, boolean wasLoaded);
	ArrayList<NameAddressId> getList();
	void clearList();
	Stage getStage();
	NameAddressId getRecordToUpdate(int index);
	int getSelectedIndex();
	void setSocket(Socket socket);
	void setStreams(ObjectOutputStream objectOutputStream, ObjectInputStream objectInputStream);
	void setLoadDisable(boolean value);
	void setEditMenuDisable(boolean value);
	void setReadOnlyStyle(boolean value);

}

