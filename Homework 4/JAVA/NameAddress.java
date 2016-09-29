/*
 * Objective: Creates object that includes a full name (first middle last or last, first middle) 
*			and an address (street, city, state, zip)
*/

public class NameAddress {
	
    private String street, spacedName, commaName;
	private SingleName city, state, first, middle, last;
	private int zip;

	public NameAddress(String street, SingleName city, SingleName state, 
			int zip, SingleName first, SingleName middle, SingleName last) {
		this.first = first;
		this.middle = middle;
		this.last = last;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public NameAddress() {
	}
	

void setStreet(String street ) {
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
}
