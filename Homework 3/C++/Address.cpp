//#include <locale>
#include "Address.h"

using namespace std;

Address::Address()
{
	street = string();
	city = SingleName();
	state = SingleName();
	int zip = 0;
}

Address::~Address()
{
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
