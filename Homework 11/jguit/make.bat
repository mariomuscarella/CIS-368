call clean.bat
cd jguit
javac -d . src\com\hoodedfalcon\*.java src\com\hoodedfalcon\control\*.java src\com\hoodedfalcon\event\*.java src\com\hoodedfalcon\interfaces\*.java src\com\hoodedfalcon\model\*.java src\com\hoodedfalcon\model\nameaddress\*.java src\com\hoodedfalcon\view\*.java
COPY "src\com\hoodedfalcon\view\list.css" "com\hoodedfalcon\view\list.css"
jar cmf src\META-INF\MANIFEST.MF jguit.jar com\* src\com\hoodedfalcon\resources\list.css
cd ../
COPY "jguit\jguit.jar" "jguit.jar"
cd jserver
javac -d . src\com\hoodedfalcon\*.java src\com\hoodedfalcon\control\*.java src\com\hoodedfalcon\thread\*.java src\com\hoodedfalcon\model\*.java src\com\hoodedfalcon\model\nameaddress\*.java
jar cmf src\META-INF\MANIFEST.MF jserver.jar com\*
cd ../
COPY "jserver\jserver.jar" "jserver.jar"
COPY "jserver\runserver.bat" "runserver.bat"