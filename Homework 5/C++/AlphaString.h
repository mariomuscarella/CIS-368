#ifndef ALPHASTRING_H
#define ALPHASTRING_H
#include <string>

using namespace std;

class AlphaString
{
private:
	string storedString;
public:
	AlphaString();
	~AlphaString();
	string get();
	void set(string input);

	bool equals(AlphaString other);
	AlphaString constructor(AlphaString other);
	AlphaString copy(AlphaString other);
};

#endif /* ALPHASTRING_H */