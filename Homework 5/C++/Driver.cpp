
#include <iostream>
#include "SingleName.h"
#include "CheckAlphaString.h"
#include "Address.h"
#include "FullName.h"
#include "NameAddress.h"
#include <ctype.h>

using namespace std;

int main() {

	Address address;
	char input[100];
	string street;
	SingleName city;
	SingleName state;
	int zip;
	AlphaString alpha;
	SingleName single;
	CheckAlphaString check;
	SingleName first;
	SingleName middle;
	SingleName last;
	FullName full;
	NameAddress nameaddress;

	cout << "Please enter your first name: ";

	do {

		cin >> input;
		alpha.set(input);
		if (check.check(alpha.get()) == false) {

			cout << "Please do not enter non alphabetic characters." << endl;
			cout << "Please try again: ";

		}

	} while (check.check(alpha.get()) == false);

	first.set(alpha);
	alpha.set("");

	cout << "Please enter your middle name: ";

	do {

		cin >> input;
		alpha.set(input);
		if (check.check(alpha.get()) == false) {

			cout << "Please do not enter non alphabetic characters." << endl;
			cout << "Please try again: ";

		}

	} while (check.check(alpha.get()) == false);

	middle.set(alpha);
	alpha.set("");

	cout << "Please enter your last name: ";

	do {

		cin >> input;
		alpha.set(input);
		if (check.check(alpha.get()) == false) {

			cout << "Please do not enter non alphabetic characters." << endl;
			cout << "Please try again: ";

		}

	} while (check.check(alpha.get()) == false);

	last.set(alpha);

	// All name data collected, set it to the FullName
	// Since setAll() calls induvidual set methods it's a nice all-in-one test
	nameaddress.setName(first, middle, last);


	cout << "Enter a street address (number and name): ";
	cin.ignore();
	cin.getline(input, 100);
	nameaddress.setStreet(input);


	cout << "Enter a city: ";

	do {

		cin >> input;
		alpha.set(input);
		if (check.check(alpha.get()) == false) {

			cout << "Please do not enter non alphabetic characters." << endl;
			cout << "Please try again: ";

		}

	} while (check.check(alpha.get()) == false);

	single.set(alpha);
	nameaddress.setCity(single);
	alpha.set("");

	cout << "Enter a state: ";

	do {

		cin >> input;
		alpha.set(input);
		if (check.check(alpha.get()) == false) {

			cout << "Please do not enter non alphabetic characters." << endl;
			cout << "Please try again: ";

		}

	} while (check.check(alpha.get()) == false);

	single.set(alpha);
	nameaddress.setState(single);
	alpha.set("");

	cout << "Enter a zip-code: ";
	
	do {

		cin >> input;
		if (!address.checkZip(input)) {

			cout << "Please enter numerals only." << endl;
			cout << "Please try again: ";

		}

	} while (!address.checkZip(input));

	zip = stoi(input);

	nameaddress.setZip(zip);

	cout << endl;
	cout << "The full address and name is: \n";
	cout << endl;
	cout << nameaddress.getFullNameSpaces();
	cout << endl;
	cout << nameaddress.getStreet();
	cout << endl;
	cout << nameaddress.getCity().get().get() << ", " << nameaddress.getState().get().get() << " " << nameaddress.getZip();
	cout << endl;
	cout << endl;
	cout << "Your name in \"last, first\" is: " << nameaddress.getLastCommaFirst() << endl;
	cout << endl;
	system("pause");

}
