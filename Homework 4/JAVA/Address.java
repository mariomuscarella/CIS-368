/*
 * Objective: Creates an address object that includes street, city, state and zip
*/

public class Address {
	
	private String street;
	private SingleName city, state;
	private int zip;
	
public Address(String street, SingleName city, SingleName state, int zip) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

public Address() {
	
}

void setStreet(String street ) {
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

//first line with street number and name
//listed in instructions as "getfFrst"
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
}
