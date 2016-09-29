#include "FullName.h"

class FullNameWithTitle :
	public FullName
{
private:
	AlphaString title;
public:
	FullNameWithTitle();
	~FullNameWithTitle();
	AlphaString getTitle();
	string getNameWithTitle();
	void setTitle(AlphaString input);
};
