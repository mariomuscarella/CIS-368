#include "FullNameWithTitle.h"
#include "SingleName.h"
#include "FullName.h"


FullNameWithTitle::FullNameWithTitle() {

	title = SingleName();
	name = FullName();

}

FullNameWithTitle::~FullNameWithTitle() {

}

FullName FullNameWithTitle::getFullName() {

	return name;

}

void FullNameWithTitle::setFullName(FullName input) {

	name = input;

}

AlphaString FullNameWithTitle::getTitle() {

	AlphaString ret = title;
	return ret;

}

string FullNameWithTitle::getNameWithTitle() {

	string space = " ";
	string concat = "";

	concat.append(title.get());
	concat.append(space);
	concat.append(name.getFullNameSpaces());

	return concat;

}

void FullNameWithTitle::setTitle(AlphaString input) {

	SingleName set;
	set.set(input);
	title = set.get();

}

bool FullNameWithTitle::equals(FullNameWithTitle other) {

	if ((title.equals(other.getTitle())) &&
		(name.equals(other.getFullName())))
		return true;
	else return false;

}

FullNameWithTitle FullNameWithTitle::constructor(FullNameWithTitle other) {

}

FullNameWithTitle FullNameWithTitle::copy(FullNameWithTitle other) {

}
