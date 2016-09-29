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
 * NameAddressId extends NameAddress and contains an ID.  It has all of the functionality of NameAddress,
 * and it also contains an ID which can be set and retrieved.
 */
public class NameAddressId extends NameAddress implements Serializable, Comparable<NameAddressId> {
	private static final long serialVersionUID = 1L;
	private int id;

	/**
	 * Constructs a new NameAddressId.
	 */
	public NameAddressId() {
		/* DEFAULT CONSTRUCTOR */
	}

	/**
	 * Constructs a new NameAddressId from another NameAddressId.
	 * @param clone
	 * 				The NameAddressId which gets cloned.
     */
	public NameAddressId(NameAddressId clone) {
		super.setAll(clone.getFirst(), clone.getMiddle(), clone.getLast());
		super.setStreet(clone.getStreet());
		super.setCity(clone.getCity());
		super.setState(clone.getState());
		super.setZip(clone.getZip());
		id = clone.getID();
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
	 * Sets the (String) street variable in the Address class.
	 *
	 * @param input
	 *            User's input when prompted to 'ENTER STREET ADDRESS'
	 */
	public void setStreet(String input) {
		super.setStreet(input);
	}

	/**
	 * Sets the (SingleName) city variable in the Address class.
	 *
	 * @param input
	 *            User's input when prompted to 'ENTER CITY'
	 */
	public void setCity(SingleName input) {
		super.setCity(input);
	}

	/**
	 * Sets the (SingleName) state variable in the Address class.
	 *
	 * @param input
	 *            User's input when prompted to 'ENTER STATE'
	 */
   	public void setState(SingleName input) {
		super.setState(input);
	}

	/**
	 * Sets the (int) zip variable in the Address class.
	 *
	 * @param input
	 *            User's input when prompted to 'ENTER ZIP'
	 */
	public void setZip(int input) {
		super.setZip(input);
	}

	/**
	 * Sets the (int) id variable.
	 *
	 * @param input
	 *            User's input when prompted to 'ENTER ID'
	 */
	public void setID(int input) {
		id = input;
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
	 * Returns street from (Address) adrs variable.
	 *
	 * @return String
	 */
	public String getStreet() {
		return super.getStreet();
	}

	/**
	 * Returns city from (Address) adrs variable.
	 *
	 * @return SingleName
	 */
	public SingleName getCity() {
		return super.getCity();
	}

	/**
	 * Returns state from (Address) adrs variable.
	 *
	 * @return SingleName
	 */
	public SingleName getState() {
		return super.getState();
	}

	/**
	 * Returns zip from (Address) adrs variable.
	 *
	 * @return int
	 */
	public int getZip() {
		return super.getZip();
	}

	/**
	 * Returns id.
	 *
	 * @return int
	 */
	public int getID() {
		return id;
    }

	/**
	 * Returns clone of NameAddressId variable. Creates new NameAddressId variable
	 * (clone) and sets each variable to the values of the corresponding
	 * original values. Purpose: Make hard copy of NameAddressId
	 *
	 * @return Object (to be casted to NameAddressId)
	 */
	public Object clone() {
		NameAddressId clone = new NameAddressId();

		clone.setAll(getFirst(), getMiddle(), getLast());
		clone.setStreet(getStreet());
		clone.setCity(getCity());
		clone.setState(getState());
		clone.setZip(getZip());
		clone.setID(id);

		return clone;
	}

	/**
	 * Checks if two NameAddressId objects are equal.
	 *
	 * @param nai (NameAddressId)
	 * @return Boolean
	 */
	public boolean equals(NameAddressId nai) {
		return getStreet().equals(nai.getStreet()) && getCity().equals(nai.getCity())
				&& getState().equals(nai.getState()) && getZip() == nai.getZip()
				&& getFullNameSpaces().equals(nai.getFullNameSpaces()) && id == nai.getID();
	}

	/**
	 * Compares two NameAddressIds.
	 *
	 * @param anotherNAID The NameAddressId to be compared.
	 * @return int The value 0 if the argument NameAddressId's ID is equal to this
	 * NameAddressId's ID; a value less than 0 if the NameAddressId's ID is
	 * less than the NameAddressId argument's ID; and a value greater than 1 if the
	 * NameAddressId's ID is greater than the argument NameAddressId's ID
	 *
	 * <i>Note: This class has a natural ordering that is inconsistent with equals.  It
	 * uses the id field to compare objects.</i>
	 */
	public int compareTo(NameAddressId anotherNAID)
	{
		return Integer.compare(id, anotherNAID.getID());
	}
}
