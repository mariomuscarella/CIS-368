#!/bin/bash
sh ./clean.sh
find . -name "*.java" > source.txt
javac -d . @source.txt
cp -i src/com/hoodedfalcon/view/list.css com/hoodedfalcon/view/
find . -name "*.class" > classes.txt
java com/hoodedfalcon/Driver