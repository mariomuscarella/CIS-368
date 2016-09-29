
#ifndef NAMEADDRESSID_H
#include "NameAddress.h"

class NameAddressId
{
private:
	FullName name;
	Address address;
	int id;
public:
	NameAddressId();
	~NameAddressId();
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

	FullName getFullName();
	void setFullName(FullName input);

	Address getAddressObj();
	void setAddressObj(Address input);

	void setID(int input);
	int getID();

	bool equals(NameAddressId other);
	NameAddressId constructor(NameAddressId other);
	NameAddressId copy(NameAddressId other);

#endif NAMEADDRESSID_H

};