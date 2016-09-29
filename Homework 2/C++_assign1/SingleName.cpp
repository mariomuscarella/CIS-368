//need to include alphastring in preprocessing?

#include <string>
#include <locale>

namespace std;

class SingleName : public AlphaString
{

private:
	string s;

public:

	locale loc;

	SingleName(string s) : AlphaString(s)
	{
		this->s = set(s);
	}

	SingleName::SingleName()
	{
	}

	String SingleName::get(string s)
	{
		return this->s;
	}

	String SingleName::set(string s)
	{
		// change to "Aaaa" format
		//needs debugging!!
		 for (int i=0; i<s.length(); ++i)
		 {
			tolower(s[i],loc);
		 }
		 std::toupper(s[0],loc);
		return s;
	}
};
