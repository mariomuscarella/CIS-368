/** CIS 368 QUARTER 4 GROUP 2
 * MEMBERS:
 * GLEN FANNIN
 * JOHN LIGGETT
 * MARIO MUSCARELLA
 * CHRISTINA VECCHIO
 */

package com.hoodedfalcon.model;

/**
 * MyBoolean is a boolean primitive type wrapper, which has methods
 * for setting, getting, and comparing the boolean value.
 */
public class MyBoolean
{
    final private Lock lock = new Lock();
    private boolean value;

    /**
     * Constructs a new MyBoolean.
     */
    public MyBoolean()
    {
        value = false;
    }

    /**
     * Constructs a new MyBoolean from a boolean value.
     * @param value The boolean value to set the value to.
     */
    public MyBoolean(boolean value)
    {
        this.value = value;
    }

    /**
     * Constructs a new MyBoolean from another MyBoolean.
     * @param myBoolean The MyBoolean which gets copied.
     */
    public MyBoolean(MyBoolean myBoolean)
    {
        this.value = myBoolean.get();
    }

    /**
     * Sets the value of the MyBoolean.
     * @param value The value to set.
     */
    public void set(boolean value)
    {
        this.value = value;
    }

    /**
     * Returns the value of the MyBoolean.
     * @return The value of the MyBoolean.
     */
    public boolean get()
    {
        return value;
    }

    /**
     * Checks whether the value of the MyBoolean is equal to the argument
     * MyBoolean's value.
     * @param myBoolean MyBoolean to compare with.
     * @return True if the values of the MyBooleans are equal, false otherwise.
     */
    public boolean equals(MyBoolean myBoolean)
    {
        return (this.value == myBoolean.get());
    }

    /**
     * Checks whether the value of the MyBoolean is equal to the boolean argument.
     * @param value boolean value to compare with.
     * @return True if the value of the MyBoolean equals the argument, false otherwise.
     */
    public boolean equalTo(boolean value)
    {
        return (this.value == value);
    }

    public Lock getLock()
    {
        return lock;
    }


}
