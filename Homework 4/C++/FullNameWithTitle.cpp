#include "FullNameWithTitle.h"
#include "SingleName.h"
#include "FullName.h"


FullNameWithTitle::FullNameWithTitle()
{
	title = SingleName();
}

FullNameWithTitle::~FullNameWithTitle()
{
}

AlphaString FullNameWithTitle::getTitle()
{
	AlphaString ret = title;
	return ret;
}

string FullNameWithTitle::getNameWithTitle()
{
	string space = " ";
	string concat = "";

	concat.append(title.get());
	concat.append(space);
	concat.append(FullName::getFullNameSpaces());

	return concat;
}

void FullNameWithTitle::setTitle(AlphaString input)
{
	SingleName set;
	set.set(input);
	title = set.get();
}
