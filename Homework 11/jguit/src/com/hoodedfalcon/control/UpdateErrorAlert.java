
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

