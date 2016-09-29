/** CIS 368 QUARTER 4 GROUP 2
 * MEMBERS:
 * GLEN FANNIN
 * JOHN LIGGETT
 * MARIO MUSCARELLA
 * CHRISTINA VECCHIO
 */

package com.hoodedfalcon.model;

import java.util.ArrayList;

public class MyList<E>
{
    final private Lock lock = new Lock();
    private ArrayList<E> list = new ArrayList<>();

    public ArrayList<E> getList()
    {
        return list;
    }

    public Lock getLock()
    {
        return lock;
    }

}

