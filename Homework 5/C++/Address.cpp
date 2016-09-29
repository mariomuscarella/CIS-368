//#include <locale>
#include "Address.h"
#include <ctype.h>

using namespace std;

Address::Address() {
	char  street[] = "";
	city = SingleName();
	state = SingleName();
	int zip = 0;

}

Address::~Address() {

}

void Address::setStreet(string input) {

	street = input;

}

string Address::getStreet() {

	return street;

}

void Address::setCity(SingleName input) {

	city = input;

}

SingleName Address::getCity() {

	return city;

}

void Address::setState(SingleName input) {

	state = input;

}

SingleName Address::getState() {

	return state;

}

void Address::setZip(int input) {

	zip = input;

}

int Address::getZip() {

	return zip;

}

bool Address::checkZip(string input) {

	int i;
	for (i = 0; i < input.length(); i++) {

		if (!isdigit(input[i]))
			return false;

	}

	return true;

}

bool Address::equals(Address other) {

	if ((street == other.getStreet()) &&
		city.equals(other.getCity()) &&
		state.equals(other.getState()) &&
		zip == other.getZip())
		return true;
	else return false;

}

Address Address::constructor(Address other) {

}

Address Address::copy(Address other) {

}
