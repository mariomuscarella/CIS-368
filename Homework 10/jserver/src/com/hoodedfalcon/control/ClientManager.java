
package com.hoodedfalcon.control;

import com.hoodedfalcon.model.MyBoolean;
import com.hoodedfalcon.model.MyFile;
import com.hoodedfalcon.model.MyList;
import com.hoodedfalcon.model.nameaddress.NameAddressId;
import com.hoodedfalcon.thread.ServerWorker;

import java.net.ServerSocket;
import java.net.Socket;


public class ClientManager
{
    private MyFile myFile;
    private MyList<NameAddressId> recordsList;
    private MyList<Integer> deletedRecords;
    private MyList<Integer> editedRecords;

    private MyBoolean isEditBlocked = new MyBoolean();

    public void run(int port)
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket;
            Thread thread;
            ServerWorker serverWorker = new ServerWorker();

            while (true)
            {
                socket = serverSocket.accept();
                System.out.println("New Client Connected.");
                serverWorker = new ServerWorker();
                serverWorker.initialize(socket, myFile, recordsList, deletedRecords, editedRecords);

                // A client already has Write Permissions
                synchronized (isEditBlocked.getLock())
                {
                    if (isEditBlocked.get())
                    {
                        System.out.println("Client Entering Read Only Mode!");
                        serverWorker.setMyBooleans(isEditBlocked, new MyBoolean(false));
                    }
                    else
                    {
                        isEditBlocked.set(true);
                        serverWorker.setMyBooleans(isEditBlocked, new MyBoolean(true));
                    }
                }

                thread = new Thread(serverWorker);
                thread.start();
            }
        }
        catch(Throwable t)
        {
            t.printStackTrace();
        }
    }

    public void initialize(MyFile recordsFile, MyList<NameAddressId> recordsList, MyList<Integer> deletedRecords,
                           MyList<Integer> editedRecords)
    {
        this.myFile = recordsFile;
        this.recordsList = recordsList;
        this.deletedRecords = deletedRecords;
        this.editedRecords = editedRecords;
    }
}
