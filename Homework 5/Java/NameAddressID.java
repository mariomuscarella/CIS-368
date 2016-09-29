/*
 * Objective: Creates object that includes a full name (first middle last or last, 
 * 		first middle),	an address (street, city, state, zip), and an ID number.
 * 		Overrides clone and equals.
 */

public class NameAddressID implements Cloneable {

	private String street, spacedName, commaName;
	private SingleName city, state, first, middle, last;
	private int zip, id;

	public NameAddressID(String street, SingleName city, SingleName state,
			int zip, SingleName first, SingleName middle, SingleName last,
			int id) {
		this.first = first;
		this.middle = middle;
		this.last = last;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.id = id;
	}

	public NameAddressID() {
	}

	// copy constructor
	NameAddressID(NameAddressID nameAddID) {
		first = nameAddID.first;
		middle = nameAddID.middle;
		last = nameAddID.last;
		street = nameAddID.street;
		city = nameAddID.city;
		state = nameAddID.state;
		zip = nameAddID.zip;
		id = nameAddID.id;
	}

	void setStreet(String street) {
		this.street = street;
	}

	String getStreet() {

		return street;
	}

	void setCity(SingleName city) {
		this.city = city;
	}

	SingleName getCity() {

		return city;
	}

	void setState(SingleName state) {
		this.state = state;
	}

	SingleName getState() {

		return state;
	}

	void setZip(int zip) {
		this.zip = zip;
	}

	int getZip() {

		return zip;
	}

	void setID(int zip) {
		this.zip = zip;
	}

	int getID() {

		return zip;
	}

	public void setFirst(SingleName first) {
		this.first = first;
	}

	public SingleName getFirst() {
		return first;
	}

	public void setMiddle(SingleName middle) {
		this.middle = middle;
	}

	public SingleName getMiddle() {
		return middle;
	}

	public void setLast(SingleName last) {
		this.last = last;
	}

	public SingleName getLast() {
		return last;
	}

	public void setAll(SingleName first, SingleName middle, SingleName last) {
		this.first = first;
		this.middle = middle;
		this.last = last;
	}

	/*
	 * returns full name formatted with spaces
	 */
	public String getFullNameSpaces() {
		spacedName = first.get() + " " + middle.get() + " " + last.get();
		return spacedName;
	}

	/*
	 * returns full name formatted with last name, first "Smith, Bob T"
	 */
	public String getLastCommaFirst() {
		commaName = last.get() + ", " + first.get() + " " + middle.get();
		return commaName;
	}

	@Override
	public NameAddressID clone() {
		NameAddressID obj;
		try {
			obj = (NameAddressID) super.clone();
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
		if (!NameAddressID.class.isAssignableFrom(obj.getClass())) {
			return false;
		}
		final NameAddressID other = (NameAddressID) obj;
		if (!this.street.equals(other.street)) {
			return false;
		}
		if (!this.city.equals(other.city)) {
			return false;
		}
		if ( !this.state.equals(other.state)) {
			return false;
		}
		if ( !this.first.equals(other.first)) {
			return false;
		}
		if (!this.middle.equals(other.middle)) {
			return false;
		}
		if (!this.last.equals(other.last)) {
			return false;
		}
		if (this.zip != other.zip) {
			return false;
		}
		if (this.id != other.id) {
			return false;
		}
		return true;
	}
}
