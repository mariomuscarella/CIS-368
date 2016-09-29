#ifndef ADDRESS_H
#define ADDRESS_H
#include "SingleName.h"

class Address
{
private:
	string street;
	SingleName city;
	SingleName state;
	int zip;
public:
	Address();
	~Address();
	void setStreet(string input);
	string getStreet();
	void setCity(SingleName input);
	SingleName getCity();
	void setState(SingleName input);
	SingleName getState();
	void setZip(int input);
	int getZip();
	bool checkZip(string input);

};

#endif ADDRESS_H