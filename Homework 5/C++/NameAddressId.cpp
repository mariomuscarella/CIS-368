//#include <locale>
#include "NameAddressId.h"

using namespace std;

NameAddressId::NameAddressId() {

	name = FullName();
	address = Address();
	int id = 0;

}

NameAddressId::~NameAddressId() {

}

FullName NameAddressId::getFullName() {

	FullName ret = name;
	return ret;

}

void NameAddressId::setFullName(FullName input) {

	name = input;

}

Address NameAddressId::getAddressObj() {

	Address ret = address;
	return ret;

}

void NameAddressId::setAddressObj(Address input) {

	address = input;

}

SingleName NameAddressId::getFirst() {

	SingleName ret = name.getFirst();
	return ret;

}

SingleName NameAddressId::getMiddle() {

	SingleName ret = name.getMiddle();
	return ret;

}

SingleName NameAddressId::getLast() {

	SingleName ret = name.getLast();
	return ret;

}

string NameAddressId::getFullNameSpaces() {

	string space = " ";
	string concat = "";
	AlphaString aFirst = name.getFirst().get();
	AlphaString aMiddle = name.getMiddle().get();
	AlphaString aLast = name.getLast().get();

	concat.append(aFirst.get());
	concat.append(space);
	concat.append(aMiddle.get());
	concat.append(space);
	concat.append(aLast.get());

	return concat;

}

string NameAddressId::getLastCommaFirst() {

	string commaSpace = ", ";
	string concat = "";
	AlphaString aFirst = name.getFirst().get();
	AlphaString aLast = name.getLast().get();

	concat.append(aLast.get());
	concat.append(commaSpace);
	concat.append(aFirst.get());

	return concat;

}

void NameAddressId::setFirst(SingleName input) {

	name.setFirst(input);

}

void NameAddressId::setMiddle(SingleName input) {

	name.setMiddle(input);

}

void NameAddressId::setLast(SingleName input) {

	name.setLast(input);

}

void NameAddressId::setName(SingleName inputFirst, SingleName inputMiddle,
		SingleName inputLast) {

	name.setFirst(inputFirst);
	name.setMiddle(inputMiddle);
	name.setLast(inputLast);

}

void NameAddressId::setStreet(string input) {

	address.setStreet(input);

}

void NameAddressId::setCity(SingleName input) {

	address.setCity(input);

}

void NameAddressId::setState(SingleName input) {

	address.setState(input);

}

void NameAddressId::setZip(int input) {

	address.setZip(input);

}

string NameAddressId::getStreet() {

	return address.getStreet();

}

SingleName NameAddressId::getCity() {

	return address.getCity();

}

SingleName NameAddressId::getState() {

	return address.getState();

}

int NameAddressId::getZip() {

	return address.getZip();

}

void NameAddressId::setID(int input) {

	id = input;

}

int NameAddressId::getID() {

	return id;

}

bool NameAddressId::equals(NameAddressId other) {

	if ((name.equals(other.getFullName())) &&
		(address.equals(other.getAddressObj())) &&
		(id == other.getID()))
		return true;
	else return false;

}

NameAddressId NameAddressId::constructor(NameAddressId other) {

}

NameAddressId NameAddressId::copy(NameAddressId other) {

}
