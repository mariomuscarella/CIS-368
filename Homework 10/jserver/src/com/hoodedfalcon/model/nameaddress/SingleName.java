/** CIS 368 QUARTER 4 GROUP 2
 * MEMBERS:
 * GLEN FANNIN
 * JOHN LIGGETT
 * MARIO MUSCARELLA
 * CHRISTINA VECCHIO
 */

package com.hoodedfalcon.model.nameaddress;

import java.io.Serializable;

/**
 * SingleName is an object which extends AlphaString.  In addition to having the
 * functionality of AlphaString, names are in correct case - ie. "Name"
 */
public class SingleName extends AlphaString implements Serializable {
	private static final long serialVersionUID = 1L;
	transient private String name;

	/**
	 * Constructs a new SingleName.
	 */
	public SingleName() {
		/* DEFAULT CONSTRUCTOR */
	}

	/**
	 * Constructs a new SingleName from another SingleName
	 * @param clone
	 * 				The SingleName which gets cloned.
     */
	public SingleName(SingleName clone) {
		name = clone.get();
		super.set(name);
	}

    /**
	 * Sets the (String) name in the AlphaString class.
	 *
	 * @param as
	 *            The AlphaString to set the object's value with.
	 */
	public void set(AlphaString as) {
		name = "" + as.get().toUpperCase().charAt(0) + as.get().toLowerCase().substring(1);
		super.set(name);
	}

	/**
	 * Returns name value from AlphaString class.
	 *
	 * @return String
	 */
	public String get() {
		return super.get();
	}

	/**
	 * Returns clone of SingleName variable. Creates new SingleName variable
	 * (clone) and sets each variable to the values of the corresponding
	 * original values. Purpose: Make hard copy of SingleName
	 *
	 * @return Object (to be casted to SingleName)
	 */
	public Object clone() {
		SingleName copy = new SingleName();
		AlphaString tempAS = new AlphaString();

		tempAS.set(get());
		copy.set(tempAS);

		return copy;
	}

	/**
	 * Checks if two SingleName objects are equal.
	 *
	 * @param sn (SingleName)
	 * @return Boolean
	 */
	public boolean equals(SingleName sn) {
		return get().equals(sn.get());
	}

	/**
	 * Compares two SingleNames lexicographically.
	 *
	 * @param anotherSN The SingleName to be compared.
	 * @return int The value 0 if the argument SingleName is equal to this
	 * SingleName; a value less than 0 if the SingleName's value is lexicographically
	 * less than the SingleName argument's value; and a value greater than 1 if the
	 * SingleName's value is lexicographically greater than the SingleName argument's
	 */
	public int compareTo(SingleName anotherSN)
	{
		return get().compareTo(anotherSN.get());
	}
}


