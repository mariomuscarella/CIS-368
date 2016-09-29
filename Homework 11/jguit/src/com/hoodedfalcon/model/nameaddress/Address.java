
package com.hoodedfalcon.model.nameaddress;

import java.io.Serializable;

/**
 * Address is an object which stores a Street, City, State, and ZipCode.
 */
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	private String street;
	private SingleName city = new SingleName();
	private SingleName state = new SingleName();
	private int zip;

	/**
	 * Constructs a new Address.
	 */
	public Address() {
		/* DEFAULT CONSTRUCTOR */
	}

	/**
	 * Constructs a new Address from another Address.
	 * @param clone
	 * 				The Address which gets cloned.
     */
	public Address(Address clone) {
		street = clone.getStreet();
		city = (SingleName) clone.getCity().clone();
		state = (SingleName) clone.getState().clone();
		zip = clone.getZip();
	}
    
    /**
	 * Sets the (String) street.
	 *
	 * @param input
	 *            User's input when prompted to 'ENTER STREET'
	 */
	public void setStreet(String input) {
		street = input;
	}

	/**
	 * Sets the (SingleName) city.
	 *
	 * @param input
	 *            User's input when prompted to 'ENTER CITY'
	 */
	public void setCity(SingleName input) {
		city = (SingleName) input.clone();
	}

	/**
	 * Sets the (SingleName) state.
	 *
	 * @param input
	 *            User's input when prompted to 'ENTER STATE'
	 */
	public void setState(SingleName input) {
		state = (SingleName) input.clone();
	}

	/**
	 * Sets the (int) zip.
	 *
	 * @param input
        *            User's input when prompted to 'ENTER ZIP'
	 */
	public void setZip(int input) {
		zip = input;
	}

    /**
	 * Returns street value.
	 *
	 * @return String
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Returns city value.
	 *
	 * @return SingleName
	 */
	public SingleName getCity() {
		return city;
	}

	/**
	 * Returns state value.
	 *
	 * @return SingleName
	 */
	public SingleName getState() {
		return state;
	}

	/**
	 * Returns zip value.
	 *
	 * @return SingleName
	 */
	public int getZip() {
		return zip;
	}

	/**
	 * Returns clone of Address variable. Creates new Address variable
	 * (clone) and sets each variable to the values of the corresponding
	 * original values. Purpose: Make hard copy of Address
	 *
	 * @return Object (to be casted to Address)
	 */
	public Object clone() {
		Address clone = new Address();

		clone.setStreet(street);
		clone.setCity(city);
		clone.setState(state);
		clone.setZip(zip);

		return clone;
	}

	/**
	 * Checks if two Address objects are equal.
	 *
	 * @param address (Address)
	 * @return Boolean
	 */
	public boolean equals(Address address) {
		return address.getStreet().equals(street) && address.getCity().equals(city)
				&& address.getState().equals(state) && address.getZip() == zip;
	}
}
