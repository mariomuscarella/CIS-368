/** CIS 368 QUARTER 4 GROUP 2
 * MEMBERS:
 * GLEN FANNIN
 * JOHN LIGGETT
 * MARIO MUSCARELLA
 * CHRISTINA VECCHIO
 */

package com.hoodedfalcon.control;

import com.hoodedfalcon.model.AlertMessage;

public class UpdateErrorAlert implements Runnable
{
    private AlertManager alertManager = new AlertManager();

    public void run()
    {
        alertManager.alert(AlertMessage.SERVER_ERROR_UPDATING);
    }

}

