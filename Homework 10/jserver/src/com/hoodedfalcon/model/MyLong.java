
package com.hoodedfalcon.model;

public class MyLong
{
    private long value;

    public MyLong()
    {
        value = 0;
    }

    public MyLong(long value)
    {
        this.value = value;
    }

    public MyLong(MyLong myLong)
    {
        this.value = myLong.get();
    }

    public void set(long value)
    {
        this.value = value;
    }

    public void add(long value)
    {
        this.value = this.value + value;
    }

    public long get()
    {
        return value;
    }

    public boolean equals(MyLong myLong)
    {
        return this.value == myLong.get();
    }

    public boolean equalTo(long value)
    {
        return this.value == value;
    }

}
