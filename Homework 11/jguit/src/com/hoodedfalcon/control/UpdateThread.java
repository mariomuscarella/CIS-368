/** CIS 368 QUARTER 4 GROUP 2
 * MEMBERS:
 * GLEN FANNIN
 * JOHN LIGGETT
 * MARIO MUSCARELLA
 * CHRISTINA VECCHIO
 */

package com.hoodedfalcon.control;

import com.hoodedfalcon.model.Lock;
import com.hoodedfalcon.model.MyBoolean;
import com.hoodedfalcon.interfaces.MainAppInterface;

/**
 * UpdateThread is a thread that automatically updates the contents of the
 * connected database from pending (updated records) in the GUI.  The thread
 * runs approximately every minute.
 */
public class UpdateThread implements Runnable
{
    private MainAppInterface mai;
    private Lock lock;
    private UpdateAction action;

    private long minute = 1000 * 60;

    private MyBoolean state;

    public void run()
    {
        while (true)
        {
            try
            {
                synchronized (lock)
                {
                    lock.wait(minute);
                }
            }
            catch (Throwable t)
            {
                t.printStackTrace();
            }
            synchronized (state)
            {
                state.set(true);
            }
            update();
            synchronized (state)
            {
                state.set(false);
            }
        }
    }

    private void update()
    {
        action.update();
    }

    public void setLock(Lock lock)
    {
        this.lock = lock;
    }

    public void setAction(UpdateAction action)
    {
        this.action = action;
    }

    public void setState(MyBoolean state)
    {
        this.state = state;
    }

    public MainAppInterface getMAI()
    {
        return mai;
    }

    public void setMAI(MainAppInterface mai)
    {
        this.mai = mai;
    }

}

