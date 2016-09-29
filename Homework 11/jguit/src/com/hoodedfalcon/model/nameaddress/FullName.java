
package com.hoodedfalcon.model.nameaddress;

import java.io.Serializable;

/**
 * FullName is an object which stores three SingleNames:
 * <ul>
 *     <li>First Name</li>
 *     <li>Middle Name</li>
 *     <li>Last Name</li>
 * </ul>
 */
public class FullName implements Serializable {
	private static final long serialVersionUID = 1L;
	private SingleName firstName = new SingleName();
	private SingleName middleName = new SingleName();
	private SingleName lastName = new SingleName();

	/**
	 * Constructs a new FullName.
	 */
	public FullName() {
		/* DEFAULT CONSTRUCTOR */
	}

	/**
	 * Constructs a new FullName from another FullName.
	 * @param clone
	 * 				The FullName which gets cloned.
     */
	public FullName(FullName clone) {
		firstName = (SingleName) clone.getFirst().clone();
		middleName = (SingleName) clone.getMiddle().clone();
		lastName = (SingleName) clone.getLast().clone();
	}

	/**
	 * Sets the (SingleName) firstName.
	 *
	 * @param fName
	 *            User's input when prompted to 'ENTER FIRST NAME'
	 */
	public void setFirst(SingleName fName) {
		firstName = (SingleName) fName.clone();
	}

	/**
	 * Sets the (SingleName) middleName.
	 *
	 * @param mName
	 *            User's input when prompted to 'ENTER MIDDLE NAME'
	 */
	public void setMiddle(SingleName mName) {
		middleName = (SingleName) mName.clone();
	}

	/**
	 * Sets the (SingleName) lastName.
	 *
	 * @param lName
	 *            User's input when prompted to 'ENTER LAST NAME'
	 */
	public void setLast(SingleName lName) {
		lastName = (SingleName) lName.clone();
	}

	/**
	 * Sets the (SingleName) firstName, middleName, lastName.
	 *
	 * @param fName First Name (SingleName)
	 * @param mName Middle Name (SingleName)
	 * @param lName Last Name (SingleName)
	 */
	public void setAll(SingleName fName, SingleName mName, SingleName lName) {
		firstName = (SingleName) fName.clone();
		middleName = (SingleName) mName.clone();
		lastName = (SingleName) lName.clone();
	}

	/**
	 * Returns firstName value.
	 *
	 * @return SingleName
	 */
	public SingleName getFirst() {
		return firstName;
	}

	/**
	 * Returns middleName value.
	 *
	 * @return SingleName
	 */
	public SingleName getMiddle() {
		return middleName;
	}

	/**
	 * Returns lastName value.
	 *
	 * @return SingleName
	 */
	public SingleName getLast() {
		return lastName;
	}

	/**
	 * Returns full name with each name (first, middle, last) separated by a
	 * space. Example: Jimmy Bob Smith
	 *
	 * @return String
	 */
	public String getFullNameSpaces() {
		return firstName.get() + " " + middleName.get() + " " + lastName.get();
	}

	/**
	 * Returns lastName first, followed by a comma and firstName.
	 * <p>
	 * Example: Smith, Jimmy
	 *
	 * @return String
	 */
	public String getLastCommaFirst() {
		return lastName.get() + ", " + firstName.get();
	}

	/**
	 * Returns clone of FullName variable. Creates new FullName variable
	 * (clone) and sets each variable to the values of the corresponding
	 * original values. Purpose: Make hard copy of FullName
	 *
	 * @return Object (to be casted to FullName)
	 */
	public Object clone() {
		FullName clone = new FullName();

		clone.setAll(firstName, middleName, lastName);

		return clone;
	}

	/**
	 * Checks if two FullName objects are equal.
	 *
	 * @param fn (FullName)
	 * @return Boolean
	 */
	public boolean equals(FullName fn) {
		return fn.getFirst().equals(firstName) && fn.getMiddle().equals(middleName)
				&& fn.getLast().equals(lastName);
	}
}
