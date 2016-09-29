
#include <iostream>
#include "SingleName.h"
#include "CheckAlphaString.h"
#include "Address.h"

using namespace std;

int main()
{
	Address address;
	char input[100];
	string street;
	SingleName city;
	SingleName state;
	int zip;
	AlphaString alpha;
	SingleName single;
	CheckAlphaString check;

	cout << "Enter a street address (number and name): ";
	cin.ignore();
	cin.getline(input, 100);
	address.setStreet(input);


	cout << "Enter a city: ";
	do
	{
		cin >> input;
		alpha.set(input);
		if (check.check(alpha.get()) == false)
		{
			cout << "Please do not enter non alphabetic characters." << endl;
			cout << "Please try again: ";
		}
	} while (check.check(alpha.get()) == false);

	single.set(alpha);
	address.setCity(single);
	alpha.set("");

	cout << "Enter a state: ";
	do
	{
		cin >> input;
		alpha.set(input);
		if (check.check(alpha.get()) == false)
		{
			cout << "Please do not enter non alphabetic characters." << endl;
			cout << "Please try again: ";
		}
	} while (check.check(alpha.get()) == false);

	single.set(alpha);
	address.setState(single);
	alpha.set("");

	cout << "Enter a zip-code: ";
	cin >> zip;

	address.setZip(zip);


	cout << endl;
	cout << "The full address is: ";
	cout << endl;
	cout << address.getStreet();
	cout << endl;
	cout << address.getCity().get().get() << ", " << address.getState().get().get() << " " << address.getZip();
	cout << endl;

}

