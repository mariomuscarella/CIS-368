#include "FullName.h"

class FullNameWithTitle
{
private:
	FullName name;
	AlphaString title;
public:
	FullNameWithTitle();
	~FullNameWithTitle();
	AlphaString getTitle();
	string getNameWithTitle();
	void setTitle(AlphaString input);

	void setFullName(FullName input);
	FullName getFullName();

	bool equals(FullNameWithTitle other);
	FullNameWithTitle constructor(FullNameWithTitle other);
	FullNameWithTitle copy(FullNameWithTitle other);
};
