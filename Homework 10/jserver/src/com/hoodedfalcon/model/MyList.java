
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

