
package com.hoodedfalcon.control;

import com.hoodedfalcon.model.MyFile;
import com.hoodedfalcon.model.MyList;
import com.hoodedfalcon.model.nameaddress.NameAddressId;
import com.hoodedfalcon.thread.BackupThread;
import com.hoodedfalcon.thread.UpdateThread;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * RecordServer is a server which stores a database of NameAddressId objects.
 * Clients can connect to the server to access the database.  Every minute,
 * clients will check for edited records, and deliver that information to this
 * server, which will then update the file accordingly.
 *
 * As clients are only allowed to have ten records in memory at any given, they
 * also can request to load the next ten records through their Menu.
 */
public class RecordServer
{
    private ClientManager clientManager = new ClientManager();

    private UpdateThread updateThread = new UpdateThread();
    private BackupThread backupThread = new BackupThread();
    private UpdateAction updateAction = new UpdateAction();
    private BackupAction backupAction = new BackupAction();

    private MyFile recordsFile = new MyFile();
    private MyList<NameAddressId> recordsList = new MyList<>();
    private MyList<Integer> deletedRecords = new MyList<>();
    private MyList<Integer> editedRecords = new MyList<>();

    public void start(int port)
    {
        System.out.println("Record Server Starting!");
        File file = new File("records.csv");
        if (!file.exists())
        {
            try
            {
                file.createNewFile();
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter writer = new BufferedWriter(fileWriter);
                writer.write("ID,Zip Code,First Name,Middle Name,Last Name,Street,City,State");
                writer.close();
                fileWriter.close();
            }
            catch(Throwable t)
            {
                t.printStackTrace();
                System.out.println("\n\n\nERROR: The server could not create a new records file, and one does " +
                        "not already exist!  Server shutting down!");
                System.exit(1);
            }
        }
        recordsFile.setFile(file);

        prepareThreads();
        startBackupThread();
        startUpdateThread();

        clientManager.initialize(recordsFile, recordsList, deletedRecords, editedRecords);
        clientManager.run(port);
    }


    /**
     * Private helper method, which prepares the Backup and Update Threads.
     */
    private void prepareThreads()
    {
        updateThread.setAction(updateAction);
        updateAction.setMyFile(recordsFile);
        updateAction.setChanges(recordsList, deletedRecords, editedRecords);

        backupThread.setAction(backupAction);
        backupAction.setMyFile(recordsFile);
    }

    /**
     * Private helper method, which starts the Backup Thread.
     */
    private void startBackupThread()
    {
        try
        {
            Runnable runnable = backupThread;
            Thread thread = new Thread(runnable);

            thread.start();
        }
        catch(Throwable t)
        {
            t.printStackTrace();
        }
    }

    /**
     * Private helper method, which starts the Update Thread.
     */
    private void startUpdateThread()
    {
        try
        {
            Runnable runnable = updateThread;
            Thread thread = new Thread(runnable);

            thread.start();
        }
        catch(Throwable t)
        {
            t.printStackTrace();
        }
    }

}


