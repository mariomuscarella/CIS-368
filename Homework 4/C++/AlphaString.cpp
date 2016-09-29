#include <string>
#include "AlphaString.h"

using namespace std;

AlphaString::AlphaString()
{
	storedString = "";
}

AlphaString::~AlphaString()
{
}

string AlphaString::get()
{
	string ret = storedString;
	return ret;
}

void AlphaString::set(string input)
{
	storedString = input;
}