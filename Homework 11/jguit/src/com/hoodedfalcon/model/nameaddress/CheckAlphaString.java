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
 * CheckAlphaString is an object which can be used to examine whether
 * a given String only contains letters.
 */
public class CheckAlphaString implements Serializable, Comparable<CheckAlphaString> {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new CheckAlphaString.
	 */
	public CheckAlphaString() {
		/* DEFAULT CONSTRUCTOR */
	}

	/**
	 * Constructs a new CheckAlphaString from another CheckAlphaString.
	 * @param clone
	 * 				The CheckAlphaString which gets cloned.
     */
	public CheckAlphaString(CheckAlphaString clone) {
		/* NOTHING TO CLONE */
	}

	/**
	 * Checks if String contains only letters.
	 *
	 * @param input (String)
	 * @return Boolean
	 */
	public boolean check(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (!(input.charAt(i) >= 'A' && input.charAt(i) <= 'Z')
					&& !(input.charAt(i) >= 'a' && input.charAt(i) <= 'z'))
				return false;
		}
		return true;
	}

	/**
	 * Returns clone of CheckAlphaString variable. Creates new CheckAlphaString variable
	 * (clone). Purpose: Make hard copy of CheckAlphaString
	 *
	 * @return Object (to be casted to CheckAlphaString)
	 */
	public Object clone() {
		return new CheckAlphaString();
	}

	/**
	 * Checks if two CheckAlphaString objects are equal.
	 *
	 * @param cas (CheckAlphaString)
	 * @return Boolean
	 */
	public boolean equals(CheckAlphaString cas) {
		return true; /* NO DATA TO CHECK */
	}

	/**
	 * Compares two CheckAlphaStrings.
	 *
	 * @param cas (CheckAlphaString)
	 * @return 0 (as CheckAlphaStrings are always equal to one another)
     */
	public int compareTo(CheckAlphaString cas)
	{
		return 0;
	}
}
