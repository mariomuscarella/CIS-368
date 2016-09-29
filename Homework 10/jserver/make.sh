#!/bin/bash
sh ./clean.sh
find . -name "*.java" > source.txt
javac -d . @source.txt
find . -name "*.class" > classes.txt
java com/hoodedfalcon/Driver