#include <string>
#include "AlphaString.h"

using namespace std;

AlphaString::AlphaString() {

	storedString = "";

}

AlphaString::~AlphaString() {

}

string AlphaString::get() {

	string ret = storedString;
	return ret;

}

void AlphaString::set(string input) {

	storedString = input;

}

bool AlphaString::equals(AlphaString other) {

	if (storedString == other.get())
		return true;

	else return false;

}

AlphaString AlphaString::constructor(AlphaString other) {

}

AlphaString AlphaString::copy(AlphaString other) {

}
