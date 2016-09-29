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
};

#endif /* SINGLENAME_H */