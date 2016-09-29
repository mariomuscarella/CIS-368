#ifndef FULLNAME_H
#define FULLNAME_H
#include "SingleName.h"
#include <string>

class FullName
{
private:
	SingleName first;
	SingleName middle;
	SingleName last;
public:
	FullName();
	~FullName();
	SingleName getFirst();
	SingleName getMiddle();
	SingleName getLast();
	string getFullNameSpaces();
	string getLastCommaFirst();
	void setFirst(SingleName input);
	void setMiddle(SingleName input);
	void setLast(SingleName input);
	void setAll(SingleName inputFirst, SingleName inputMiddle, SingleName inputLast);
};

#endif /* FULLNAME_H */