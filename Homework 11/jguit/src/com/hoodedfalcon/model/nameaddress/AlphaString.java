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
 * AlphaString is a String-like object, which is used to store alphabetical
 * Strings.  Also, see: CheckAlphaString.
 */
public class AlphaString implements Serializable, Comparable<AlphaString> {
	private static final long serialVersionUID = 1L;
	private String name;

	/**
	 * Constructs a new AlphaString.
	 */
	public AlphaString() {
		/* DEFAULT CONSTRUCTOR */
	}

	/**
	 * Constructs a new AlphaString from another AlphaString.
	 * @param clone
	 * 				The AlphaString which gets cloned.
     */
	public AlphaString(AlphaString clone) {
		name = clone.get();
	}

	/**
	 * Sets the (String) name.
	 *
	 * @param input
	 *     			The String to set the object's value to.
	 */
	public void set(String input) {
		name = input;
	}

	/**
	 * Returns name value.
	 *
	 * @return String
	 */
	public String get() {
		return name;
	}

	/**
	 * Returns clone of AlphaString variable. Creates new AlphaString variable
	 * (clone) and sets each variable to the values of the corresponding
	 * original values. Purpose: Make hard copy of AlphaString
	 *
	 * @return Object (to be casted to AlphaString)
	 */
	public Object clone() {
		AlphaString copy = new AlphaString();
		copy.set(name);
		return copy;
	}

	/**
	 * Checks if two AlphaString objects are equal.
	 *
	 * @param as (AlphaString)
	 * @return Boolean
	 */
	public boolean equals(AlphaString as) {
		return name.equals(as.get());
	}

	/**
	 * Compares two AlphaStrings lexicographically.
	 *
	 * @param anotherAS The AlphaString to be compared.
	 * @return int The value 0 if the argument AlphaString is equal to this
	 * AlphaString; a value less than 0 if the AlphaString's value is lexicographically
	 * less than the AlphaString argument's value; and a value greater than 1 if the
	 * AlphaString's value is lexicographically greater than the AlphaString argument's
     */
	public int compareTo(AlphaString anotherAS)
	{
		return name.compareTo(anotherAS.get());
	}
}
