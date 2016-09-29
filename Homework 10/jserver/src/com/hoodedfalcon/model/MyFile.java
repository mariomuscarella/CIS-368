
package com.hoodedfalcon.model;

import java.io.File;

public class MyFile
{
    final private Lock lock = new Lock();
    private File file;

    public void setFile(File file)
    {
        this.file = file;
    }

    public File getFile()
    {
        return file;
    }

    public Lock getLock()
    {
        return lock;
    }
}

