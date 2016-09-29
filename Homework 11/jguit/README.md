###PROJECT DESCRIPTION:
	The continuation of the Main Project of the First, Second,
	and Third Quarter of CIS 368:
	
	A JavaFX GUI Application and a Java Multi-Threaded Server.
	
	The JavaFX GUI Application connects to the Java Server to access
	a database of NameAddressId Records (Full Name, Full Address, ID).
	
	The app has features to add, delete, and edit records.  However, it
	can only hold a small amount of records in memory at a time.  There-
	fore, clients using the JavaFX Application can request to load more
	records through an option in the Menu Bar.
	
	To add a new record, select "New Record" in the Records Menu List in
	the Menu Bar.  To edit a record, select a record in the List View,
	and then select "Edit Record" in the Edit Menu.  To delete a record,
	select a record in the List View, and then select "Delete Record" in
	the Edit Menu.
	
	The JavaFX GUI Application uses three threads: the Main Thread is the
	JavaFX Thread, which allows users to interact with the Application.
	The second thread is an Update Thread, which updates values of edited
	records to the server approximately every minute.  The third thread
	is created on demand when the user requests new records to be loaded.
	
	The Java Server has three main threads: a thread which initializes
	the server and waits for client connections, a thread which updates
	the file used to maintain the server's database of records, and a
	thread which backups up the file that contains the records.  In
	addition to those three threads, whenever a new client connects, the
	ClientManager launches another thread just for that client.

###RUN INSTRUCTIONS (WINDOWS OS):
	make.bat (This prepares two jars: jguit.jar & jserver.jar)
	java -jar jguit.jar (You should also be able to double click the jar)
	java -jar jserver.jar (You can also double click the runserver.bat file)
	clean.bat (This removes the jar files and the class files)
	
	To connect to the server from the client, select "Connect to Server"
	in the Server Menu List in the Menu Bar.

###RUN INSTRUCTIONS (MAC/LINUX OS):
	(SERVER STARTING INSTRUCTIONS)
	Open a terminal window
	Navigate to the base of the folder containing the make.sh file
	In the terminal window type ./make.sh 
		This will clean up, compile and run the Server
	Type the port number for clients to use. 

	(CLIENT STARTING INSTRUCTIONS)
	Open a terminal window
	Navigate to the base of the folder containing the make.sh file
	In the terminal window type ./make.sh 
		This will clean up, compile and run the GUI application interface
	
	To connect to the server from the client, select "Connect to Server"
	in the Server Menu List in the Menu Bar.

###FILES:
- README.md             (***README***)  (This File)
- records.csv           (***RECORDS FILE***)
- jguit/                (***JGUIT FOLDER***)
- jserver/              (***JSERVER FILE***)
- make.bat              (***COMPILATION FILE***)
- clean.bat             (***CLEAN BAT FILE***)

