/** CIS 368 QUARTER 4 GROUP 2
 * MEMBERS:
 * GLEN FANNIN
 * JOHN LIGGETT
 * MARIO MUSCARELLA
 * CHRISTINA VECCHIO
 */

package com.hoodedfalcon.control;

import com.hoodedfalcon.interfaces.MainAppInterface;
import com.hoodedfalcon.model.AlertMessage;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ConnectionManager
{
    private Socket socket;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    private MainAppInterface mai;
    private AlertManager alertManager;

    public boolean connect(String server, int port)
    {
        try
        {
            socket = new Socket(server, port);
            mai.setSocket(socket);

            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());

            String response = (String) objectInputStream.readObject();

            if (!response.equals("edit enabled"))
            {
                System.out.println("Edit Not Enabled");
                mai.setEditMenuDisable(true);
                mai.setReadOnlyStyle(true);
                alertManager.alert(AlertMessage.READ_ONLY_MODE);
            }
            else
            {
                System.out.println("Edit Enabled");
                mai.setEditMenuDisable(false);
                mai.setReadOnlyStyle(false);
            }

            mai.setStreams(objectOutputStream, objectInputStream);
            mai.setLoadDisable(false);
            return true;
        }
        catch(ConnectException exception)
        {
            alertManager.alert(AlertMessage.CONNECTION_REFUSED);
            return false;
        }
        catch(UnknownHostException exception)
        {
            alertManager.alert(AlertMessage.UNKNOWN_HOST);
            return false;
        }
        catch(Throwable t)
        {
            t.printStackTrace();
            return false;
        }
    }

    public boolean disconnect()
    {
        try
        {
            if (objectOutputStream == null) return false;

            objectOutputStream.writeObject("client shutting down");

            objectOutputStream.close();
            objectInputStream.close();
            socket.close();
        }
        catch (Exception e)
        {
            System.out.println("Server Error!");
        }

        socket = null;
        objectOutputStream = null;
        objectInputStream = null;

        mai.clearList();
        mai.setReadOnlyStyle(false);
        mai.setSocket(null);
        mai.setStreams(null, null);
        mai.setLoadDisable(true);
        mai.setEditMenuDisable(true);
        return true;
    }

    public void setMAI(MainAppInterface mai)
    {
        this.mai = mai;
    }

    public boolean doesConnectionExist()
    {
        return objectOutputStream != null;
    }

    public void setAlertManager(AlertManager alertManager)
    {
        this.alertManager = alertManager;
    }
}
