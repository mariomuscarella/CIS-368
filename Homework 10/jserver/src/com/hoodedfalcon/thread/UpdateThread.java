/** CIS 368 QUARTER 4 GROUP 2
 * MEMBERS:
 * GLEN FANNIN
 * JOHN LIGGETT
 * MARIO MUSCARELLA
 * CHRISTINA VECCHIO
 */

package com.hoodedfalcon.thread;

import com.hoodedfalcon.control.UpdateAction;
import com.hoodedfalcon.model.MyBoolean;

public class UpdateThread implements Runnable
{
    private UpdateAction action = new UpdateAction();

    private long halfMinute = 1000 * 30;

    public void run()
    {
        while (true)
        {
            try
            {
                Thread.sleep(halfMinute);
            }
            catch (Throwable t)
            {
                t.printStackTrace();
            }
            update();
        }
    }

    private void update()
    {
        action.update();
    }

    public void setAction(UpdateAction action)
    {
        this.action = action;
    }

}

