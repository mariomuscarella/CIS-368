
#ifndef NAMEADDRESS_H
#include "Address.h"
#include "FullName.h"

class NameAddress
{
private:
	FullName name;
	Address address;
public:
	NameAddress();
	~NameAddress();
	SingleName getFirst();
	SingleName getMiddle();
	SingleName getLast();
	string getFullNameSpaces();
	string getLastCommaFirst();
	void setFirst(SingleName input);
	void setMiddle(SingleName input);
	void setLast(SingleName input);
	void setName(SingleName inputFirst, SingleName inputMiddle, SingleName inputLast);

	string getStreet();
	SingleName getCity();
	SingleName getState();
	int getZip();
	string getAddress();
	void setStreet(string input);
	void setCity(SingleName input);
	void setState(SingleName input);
	void setZip(int input);

	bool equals(NameAddress other);
	NameAddress constructor(NameAddress other);
	NameAddress copy(NameAddress other);

	FullName getFullName();
	void setFullName(FullName input);
	Address getAddressObj();
	void setAddressObj(Address input);

#endif NAMEADDRESS_H

};