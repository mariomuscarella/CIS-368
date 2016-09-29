
package com.hoodedfalcon.control;

import com.hoodedfalcon.interfaces.MainAppInterface;
import com.hoodedfalcon.model.Lock;
import com.hoodedfalcon.model.MyBoolean;
import com.hoodedfalcon.model.nameaddress.NameAddressId;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ThreadManager
{
    private MainAppInterface mai;
    private Socket socket;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    private ConnectionManager connectionManager;
    final private Lock updateLock = new Lock();

    private ArrayList<NameAddressId> recordsList;
    private ArrayList<Integer> deletedRecords;
    private MyBoolean pendingRecords[];

    private int nextIndex = 0;

    private UpdateThread updateThread = new UpdateThread();
    private UpdateAction updateAction = new UpdateAction();

    private MyBoolean loadState;
    private MyBoolean updateState;
    private MyBoolean isEditEnabled;

    public void initialize(MainAppInterface mai, Socket socket, ObjectOutputStream objectOutputStream,
                           ObjectInputStream objectInputStream, ArrayList<NameAddressId> recordsList,
                           ArrayList<Integer> deletedRecords, MyBoolean pendingRecords[], MyBoolean loadState,
                           MyBoolean updateState, MyBoolean isEditEnabled, ConnectionManager connectionManager)
    {
        this.mai = mai;
        this.socket = socket;
        this.objectOutputStream = objectOutputStream;
        this.objectInputStream = objectInputStream;
        this.recordsList = recordsList;
        this.deletedRecords = deletedRecords;
        this.pendingRecords = pendingRecords;
        this.loadState = loadState;
        this.updateState = updateState;
        this.isEditEnabled = isEditEnabled;
        this.connectionManager = connectionManager;
    }

    public ArrayList<NameAddressId> load()
    {
        synchronized (loadState.getLock())
        {
            if (loadState.get())
            {
                return null;
            }

            loadState.set(true);
        }
        LoadNextTenTask loadNextTenTask = new LoadNextTenTask();
        loadNextTenTask.setSocket(socket);
        loadNextTenTask.setStreams(objectOutputStream, objectInputStream);
        loadNextTenTask.setNextIndex(nextIndex);
        loadNextTenTask.setConnectionManager(connectionManager);
        ArrayList<NameAddressId> records = loadNextTenTask.call();
        if (records != null) nextIndex += records.size();
        else nextIndex = 0;
        synchronized (loadState.getLock())
        {
            loadState.set(false);
        }

        return records;
    }

    public int getNextIndex()
    {
        return nextIndex;
    }

    public void setNextIndex(int nextIndex)
    {
        this.nextIndex = nextIndex;
    }

    public void prepareUpdateThread()
    {
        updateThread.setMAI(mai);
        updateThread.setState(updateState);
        updateThread.setAction(updateAction);
        updateThread.setLock(updateLock);
        updateAction.setRecordsList(recordsList);
        updateAction.setPendingRecords(pendingRecords);
        updateAction.setDeletedRecords(deletedRecords);
        updateAction.setIsEditEnabled(isEditEnabled);
        updateAction.setConnectionManager(connectionManager);
    }

    /**
     * Private helper method, which starts the Update Thread.
     */
    public void startUpdateThread()
    {
        try
        {
            Runnable runnable = updateThread;
            Thread thread = new Thread(runnable);

            thread.start();
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }
    }

    /**
     * Forces the Update Thread to run.
     */
    public void forceUpdate()
    {
        synchronized (updateLock)
        {
            updateLock.notifyAll();
        }
    }

    public void setStreams(ObjectOutputStream objectOutputStream, ObjectInputStream objectInputStream)
    {
        this.objectOutputStream = objectOutputStream;
        this.objectInputStream = objectInputStream;
        updateAction.setStreams(objectOutputStream, objectInputStream);
    }

    public void setSocket(Socket socket)
    {
        this.socket = socket;
        updateAction.setSocket(socket);
    }

}

