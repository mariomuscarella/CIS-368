#ifndef SINGLENAME_H
#define SINGLENAME_H
#include "AlphaString.h"

class SingleName : public AlphaString
{
private:
	AlphaString storedAlpha;
public:
	SingleName();
	~SingleName();
	AlphaString get();
	void set(AlphaString input);

	bool equals(SingleName other);
	SingleName constructor(SingleName other);
	SingleName copy(SingleName other);
};

#endif /* SINGLENAME_H */