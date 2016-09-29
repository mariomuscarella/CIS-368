#include <locale>
#include "SingleName.h"

using namespace std;

SingleName::SingleName()
{
	storedAlpha = AlphaString();
}

SingleName::~SingleName()
{
}

AlphaString SingleName::get()
{
	AlphaString ret = storedAlpha;
	return ret;
}

void SingleName::set(AlphaString input)
{
	string set = input.get();
	for (int i = 0; i < set.length(); ++i)
	{
		set[i] = tolower(set[i]);
	}
	set[0] = toupper(set[0]);
	storedAlpha.set(set);
}