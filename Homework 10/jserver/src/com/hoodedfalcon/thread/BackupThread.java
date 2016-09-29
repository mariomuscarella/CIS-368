/** CIS 368 QUARTER 4 GROUP 2
 * MEMBERS:
 * GLEN FANNIN
 * JOHN LIGGETT
 * MARIO MUSCARELLA
 * CHRISTINA VECCHIO
 */

package com.hoodedfalcon.thread;

import com.hoodedfalcon.control.BackupAction;
import com.hoodedfalcon.model.MyBoolean;

public class BackupThread implements Runnable
{
    private BackupAction action;

    private long minutes = 10;
    private long minute = 1000 * 60;

    public void run()
    {
        while (true)
        {
            try
            {
                Thread.sleep(minute * minutes);
            }
            catch (Throwable t)
            {
                t.printStackTrace();
            }
            backup();
        }
    }

    private void backup()
    {
        action.backup();
    }

    public void setAction(BackupAction action)
    {
        this.action = action;
    }

}

