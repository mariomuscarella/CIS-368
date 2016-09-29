/*
 * Objective: Creates an address object that includes street, city, state and zip.
 * 						Overrides clone and equals.
 */

public class Address implements Cloneable {

	private String street;
	private SingleName city, state;
	private int zip;

	public Address(String street, SingleName city, SingleName state, int zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public Address() {
	}

	// copy constructor
	Address(Address add) {
		street = add.street;
		city = add.city;
		state = add.state;
		zip = add.zip;
	}

	void setStreet(String street) {
		this.street = street;
	}

	void setCity(SingleName city) {
		this.city = city;
	}

	void setState(SingleName state) {
		this.state = state;
	}

	void setZip(int zip) {
		this.zip = zip;
	}

	String getStreet() {

		return street;
	}

	SingleName getCity() {

		return city;
	}

	SingleName getState() {

		return state;
	}

	int getZip() {

		return zip;
	}

	@Override
	public Address clone() {
		Address obj;
		try {
			obj = (Address) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError(e);
		}
		return obj;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!Address.class.isAssignableFrom(obj.getClass())) {
			return false;
		}
		final Address other = (Address) obj;
		if (!this.street.equals(other.street)) {
			return false;
		}
		if (!this.city.equals(other.city)) {
			return false;
		}
		if (!this.state.equals(other.state)) {
			return false;
		}
		if (this.zip != other.zip) {
			return false;
		}
		return true;
	}
}
