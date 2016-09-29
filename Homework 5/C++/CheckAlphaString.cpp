#include "CheckAlphaString.h"

CheckAlphaString::CheckAlphaString() {

}

CheckAlphaString::~CheckAlphaString() {

}

bool CheckAlphaString::check(string input) {

	for (int i = 0; i < input.length(); ++i) {

		if (!isalpha(input[i])) {

			return false;

		}

	}

	return true;

}
