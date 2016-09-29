//#include <locale>
#include "NameAddress.h"

using namespace std;

NameAddress::NameAddress()
{
	name = FullName();
	address = Address();
}

NameAddress::~NameAddress()
{
}

SingleName NameAddress::getFirst()
{
	SingleName ret = name.getFirst();
	return ret;
}

SingleName NameAddress::getMiddle()
{
	SingleName ret = name.getMiddle();
	return ret;
}

SingleName NameAddress::getLast()
{
	SingleName ret = name.getLast();
	return ret;
}

string NameAddress::getFullNameSpaces()
{
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

string NameAddress::getLastCommaFirst()
{
	string commaSpace = ", ";
	string concat = "";
	AlphaString aFirst = name.getFirst().get();
	AlphaString aLast = name.getLast().get();

	concat.append(aLast.get());
	concat.append(commaSpace);
	concat.append(aFirst.get());

	return concat;
}

void NameAddress::setFirst(SingleName input)
{
	name.setFirst(input);
}

void NameAddress::setMiddle(SingleName input)
{
	name.setMiddle(input);
}
void NameAddress::setLast(SingleName input)
{
	name.setLast(input);
}

void NameAddress::setName(SingleName inputFirst, SingleName inputMiddle, SingleName inputLast)
{
	name.setFirst(inputFirst);
	name.setMiddle(inputMiddle);
	name.setLast(inputLast);
}

void NameAddress::setStreet(string input) {
	address.setStreet(input);
}

void NameAddress::setCity(SingleName input) {
	address.setCity(input);
}

void NameAddress::setState(SingleName input) {
	address.setState(input);
}

void NameAddress::setZip(int input) {
	address.setZip(input);
}

string NameAddress::getStreet() {
	return address.getStreet();
}

SingleName NameAddress::getCity() {
	return address.getCity();
}

SingleName NameAddress::getState() {
	return address.getState();
}

int NameAddress::getZip() {
	return address.getZip();
}