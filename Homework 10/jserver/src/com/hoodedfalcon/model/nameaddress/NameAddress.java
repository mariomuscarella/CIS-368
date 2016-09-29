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
 * NameAddress is an object which extends FullName and stores an Address.
 * It can be used to store an individual's name and Address.
 */
public class NameAddress extends FullName implements Serializable {
	private static final long serialVersionUID = 1L;
	private Address address = new Address();

	/**
	 * Constructs a new NameAddress.
	 */
	public NameAddress() {
		/* DEFAULT CONSTRUCTOR */
	}

	/**
	 * Constructs a new NameAddress from another NameAddress.
	 * @param clone
	 * 				The NameAddress which gets cloned.
     */
	public NameAddress(NameAddress clone) {
		address.setStreet(clone.getStreet());
		address.setCity(clone.getCity());
		address.setState(clone.getState());
		address.setZip(clone.getZip());
		super.setAll(clone.getFirst(), clone.getMiddle(), clone.getLast());
	}

	/**
	 * Sets the (SingleName) firstName in the FullName class.
	 *
	 * @param fName
	 *            User's input when prompted to 'ENTER FIRST NAME'
	 */
	public void setFirst(SingleName fName) {
		super.setFirst(fName);
	}

	/**
	 * Sets the (SingleName) middleName in the FullName class.
	 *
	 * @param mName
	 *            User's input when prompted to 'ENTER MIDDLE NAME'
	 */
	public void setMiddle(SingleName mName) {
		super.setMiddle(mName);
	}

	/**
	 * Sets the (SingleName) lastName in the FullName class.
	 *
	 * @param lName
	 *            User's input when prompted to 'ENTER LAST NAME'
	 */
	public void setLast(SingleName lName) {
		super.setLast(lName);
	}

	/**
	 * Sets the (SingleName) firstName, middleName, lastName in the FullName
	 * class.
	 *
	 * @param fName First Name (SingleName)
	 * @param mName Middle Name (SingleName)
	 * @param lName Last Name (SingleName)
	 */
	public void setAll(SingleName fName, SingleName mName, SingleName lName) {
		super.setAll(fName, mName, lName);
	}

	/**
	 * Returns firstName value.
	 *
	 * @return SingleName
	 */
	public SingleName getFirst() {
		return super.getFirst();
	}

	/**
	 * Returns middleName value.
	 *
	 * @return SingleName
	 */
	public SingleName getMiddle() {
		return super.getMiddle();
	}

	/**
	 * Returns lastName value.
	 *
	 * @return SingleName
	 */
	public SingleName getLast() {
		return super.getLast();
	}

	/**
	 * Returns full name with each name (first, middle, last) separated by a
	 * space. Example: Jimmy Bob Smith
	 *
	 * @return String
	 */
	public String getFullNameSpaces() {
		return super.getFullNameSpaces();
	}

	/**
	 * Returns lastName first, followed by a comma and firstName.
	 * <p>
	 * Example: Smith, Jimmy
	 *
	 * @return String
	 */
	public String getLastCommaFirst() {
		return super.getLastCommaFirst();
	}

	/**
	 * Sets the (String) street variable in the Address class.
	 *
	 * @param input
	 *            User's input when prompted to 'ENTER STREET ADDRESS'
	 */
	public void setStreet(String input) {
		address.setStreet(input);
	}

	/**
	 * Sets the (SingleName) city variable in the Address class.
	 *
	 * @param input
	 *            User's input when prompted to 'ENTER CITY'
	 */
	public void setCity(SingleName input) {
		address.setCity(input);
	}

	/**
	 * Sets the (SingleName) state variable in the Address class.
	 *
	 * @param input
	 *            User's input when prompted to 'ENTER STATE'
	 */
	public void setState(SingleName input) {
		address.setState(input);
	}

	/**
	 * Sets the (int) zip variable in the Address class.
	 *
	 * @param input
	 *            User's input when prompted to 'ENTER ZIP'
	 */
	public void setZip(int input) {
		address.setZip(input);
	}

	/**
	 * Returns street from (Address) address variable.
	 *
	 * @return String
	 */
	public String getStreet() {
		return address.getStreet();
	}

	/**
	 * Returns city from (Address) address variable.
	 *
	 * @return SingleName
	 */
	public SingleName getCity() {
		return address.getCity();
	}

	/**
	 * Returns state from (Address) address variable.
	 *
	 * @return SingleName
	 */
	public SingleName getState() {
		return address.getState();
	}

	/**
	 * Returns zip from (Address) address variable.
	 *
	 * @return int
	 */
	public int getZip() {
		return address.getZip();
	}

	/**
	 * Returns clone of NameAddress variable. Creates new NameAddress variable
	 * (clone) and sets each variable to the values of the corresponding
	 * original values. Purpose: Make hard copy of NameAddress
	 *
	 * @return Object (to be casted to NameAddress)
	 */
	public Object clone() {
		NameAddress clone = new NameAddress();

		clone.setAll(getFirst(), getMiddle(), getLast());
		clone.setStreet(getStreet());
		clone.setCity(getCity());
		clone.setState(getState());
		clone.setZip(getZip());

		return clone;
	}

	/**
	 * Checks if two NameAddress objects are equal.
	 *
	 * @param na (NameAddress)
	 * @return Boolean
	 */
	public boolean equals(NameAddress na) {
		return address.getStreet().equals(na.getStreet()) && address.getCity().equals(na.getCity())
				&& address.getState().equals(na.getState()) && address.getZip() == na.getZip()
				&& getFullNameSpaces().equals(na.getFullNameSpaces());
	}
}
