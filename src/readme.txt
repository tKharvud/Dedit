DEDIT- A barebones file explorer.

DESCRIPTION:

	The intention of this program is to provide intuitive tools for 
	file management and parsing through a command-line user-interface. 
	While the basics of a file-manager are present, an effort has been
	made to develop tools to solve more complex and tedious problems.
	This is organized by use of an unbalanced linked tree of custom-
	made "Folder" objects. As an example: the "print" command neatly
	displays the entire FileTree in an easy-to-read manner, "export"
	essentially saves a .txt file with the same format. 


EXECUTION INSTRUCTIONS:

	Required: latest version of java

	1.	Place the "dedit" directory into the directory
		you wish to be root-directory during runtime.

		- "dedit" should contain:

			dedit.java
			Folder.java
	  		FileTree.java
        	readme.txt

	2.	From terminal: navigate into the "dedit" directory.

	3.	Compile and run:
		
		> javac dedit.java
		> java dedit <Command Line Arguments>
			                       

COMMAND LINE ARGUMENTS:

	help: 		Prints out "readme.txt" to console.

	search: 	

	rip:		

	print:		Prints out the FileTree to console.

	export:		Prints a map of the FileTree to a .txt file.