#include <string>

namespace std;

class AlphaString
{
private:
string s;

public:
	AlphaString::AlphaString(string s)
	{
		this->s = s;
	}
	AlphaString::AlphaString()
	{
	}

	String AlphaString::get(void)
	{
		return s;
	}

	String AlphaString::set(string s)
	{
		this->s = s;
		return this->s;

	}
};
