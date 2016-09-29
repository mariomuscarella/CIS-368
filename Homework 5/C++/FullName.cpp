#include "AlphaString.h"
#include "FullName.h"

using namespace std;

FullName::FullName() {

	first = SingleName();
	middle = SingleName();
	last = SingleName();

}

FullName::~FullName() {

}

SingleName FullName::getFirst() {

	SingleName ret = first;
	return ret;

}

SingleName FullName::getMiddle() {

	SingleName ret = middle;
	return ret;

}

SingleName FullName::getLast() {

	SingleName ret = last;
	return ret;

}

string FullName::getFullNameSpaces() {

	string space = " ";
	string concat = "";
	AlphaString aFirst = first.get();
	AlphaString aMiddle = middle.get();
	AlphaString aLast = last.get();

	concat.append(aFirst.get());
	concat.append(space);
	concat.append(aMiddle.get());
	concat.append(space);
	concat.append(aLast.get());

	return concat;

}

string FullName::getLastCommaFirst() {

	string commaSpace = ", ";
	string concat = "";
	AlphaString aFirst = first.get();
	AlphaString aLast = last.get();

	concat.append(aLast.get());
	concat.append(commaSpace);
	concat.append(aFirst.get());

	return concat;

}

void FullName::setFirst(SingleName input) {

	first = input;

}

void FullName::setMiddle(SingleName input) {

	middle = input;

}

void FullName::setLast(SingleName input) {

	last = input;

}

void FullName::setAll(SingleName inputFirst, SingleName inputMiddle,
		SingleName inputLast) {

	setFirst(inputFirst);
	setMiddle(inputMiddle);
	setLast(inputLast);

}

bool FullName::equals(FullName other) {

	if (first.equals(other.getFirst()) &&
		(middle.equals(other.getMiddle())) &&
		(last.equals(other.getLast())))
		return true;
	else return false;

}

FullName FullName::constructor(FullName other) {

}

FullName FullName::copy(FullName other) {

}
