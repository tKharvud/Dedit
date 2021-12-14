///////////////////////////////////////
// Tyler Harwood & Seth Vaughn      //
// COS225 FINAL PROJECT            //
// Professor Schotter             //
// 15 December 2021              //
//////////////////////////////////

// Imports
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Format;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class dedit {

// Global data



// Functions

	public void rerip(FileTree etzChaim)
	{
		FileTree yggdrasil = new FileTree();
	}

	public static void printUI(Folder p)
	{

		String directoriesString = "Directories";
		String filesString = "Files";
		String typeString = "Type";
		String sizeString = "Size";

		System.out.println(
				"------------------------------------------------------------------------------------------------"
		);
		System.out.format(
			"\n\t%-40s\t%-10s\t%-10s\n\n",
			directoriesString,
			typeString,
			sizeString		
		);

		// Folders
		for(int i = 0; i < p.folders.toArray().length; i++)
		{

			String folderString = "Folder";
			long folderSize = p.folders.get(i).length();

			if(folderSize >= 1073741824){

				folderSize = folderSize / 1073741824;

				System.out.format(
				"\t%-40s\t%-10s\t%-10d GB\n", 
				p.folders.get(i).name(),
				folderString,
				folderSize
				);

			}

			else if(folderSize >= 1048576){

				folderSize = folderSize / 1048576;

				System.out.format(
				"\t%-40s\t%-10s\t%-10d MB\n", 
				p.folders.get(i).name(),
				folderString,
				folderSize
				);

			}

			else if(folderSize >= 1024){

				folderSize = folderSize / 1024;

				System.out.format(
				"\t%-40s\t%-10s\t%-10d KB\n", 
				p.folders.get(i).name(),
				folderString,
				folderSize
				);

			}

			else{

				System.out.format(
				"\t%-40s\t%-10s\t%-10d bytes\n", 
				p.folders.get(i).name(),
				folderString,
				folderSize
				);

			}

		}

		System.out.println(
				"\n------------------------------------------------------------------------------------------------"
		);
		System.out.format(
			"\n\t%-40s\t%-10s\t%-10s\n\n",
			filesString,
			typeString,
			sizeString		
		);

		// Files
		for(int j = 0; j < p.files.toArray().length; j++)
		{

			String fileString = "File";
			long fileSize = p.files.get(j).length();

			if(fileSize >= 1073741824){

				fileSize = fileSize / 1073741824;

				System.out.format(
				"\t%-40s\t%-10s\t%-10d GB\n", 
				p.files.get(j).getName(),
				fileString,
				fileSize
				);

			}

			else if(fileSize >= 1048576){

				fileSize = fileSize / 1048576;

				System.out.format(
				"\t%-40s\t%-10s\t%-10d MB\n", 
				p.files.get(j).getName(),
				fileString,
				fileSize
				);

			}

			else if(fileSize >= 1024){

				fileSize = fileSize / 1024;

				System.out.format(
				"\t%-40s\t%-10s\t%-10d KB\n", 
				p.files.get(j).getName(),
				fileString,
				fileSize
				);

			}

			else{

				System.out.format(
				"\t%-40s\t%-10s\t%-10d bytes\n", 
				p.files.get(j).getName(),
				fileString,
				fileSize
				);

			}
	
		}

		// Description
		String descHeader = "Commands Description";
		String cdString = "cd";
		String cdDesc = "Navigate into given folder.";
		String addString = "add";
		String addDesc = "Creates a new directory with a given name.";
		String removeString = "remove";
		String quitString = "q";
		String quitDesc = "Quits program.";

		System.out.println(
				"\n------------------------------------------------------------------------------------------------"
		);
		System.out.format(
			"\n\t%-40s\n\n",
			descHeader
		);
		System.out.format(
			"\t%-40s\t%-10s\n",
			cdString,
			cdDesc
		);
		System.out.format(
			"\t%-40s\t%-10s\n",
			addString,
			addDesc
		);
		System.out.format(
			"\t%-40s\n",
			removeString
		);
		System.out.format(
			"\t%-40s\t%-10s\n",
			quitString,
			quitDesc
		);

	}


// The State of Maine
	public static void main (String[] args) {


		File head = new File("..");
		File[] hlist = head.listFiles();
		
		FileTree etzChaim = new FileTree(head);
		Folder currentDir = etzChaim.getHead();


		// If args.length is 0, enter user-interface
		if(args.length == 0){

			Boolean quitBool = false;


			Scanner menuScan = new Scanner (System.in);

			while (quitBool == false) {

				System.out.println(currentDir.path());

				// UI print
				printUI (currentDir);

				System.out.println(
						"\n------------------------------------------------------------------------------------------------\n"
				);
				System.out.println("Enter a command");
				System.out.print(">>> ");

				String[] input= menuScan.nextLine().split(" ");

				if (input[0].equals ("q")) {
					quitBool = true;
				}

				else if(input[0].equals("cd")){

					// Maintaining 80-char limit
					// Do not change my syntax
					Folder r = etzChaim.cdForward(
						currentDir, input[1]
					);

					if(r!= null) currentDir = r;

				}

				else if(input[0].equals("print")){

					currentDir.printFolders();
					currentDir.printFiles();

				}

				else {
					quitBool = false;
				}

				System.out.print("\n");
			}

			menuScan.close();
			System.exit(0);

		}

		// If args.length is 1, check which argument it is.
		else if(args.length == 1){
	
			// If argument is "help", enter help.
			if (args [0].equals ("help")) {
				System.out.println ("This will enter help.");
			}

			// If argument is "search", enter search.
			else if (args [0].equals ("search")) {
				System.out.println ("This will enter search.");
			}
	
			// If argument is "print", enter print.
			else if (args [0].equals ("print")) {
				etzChaim.print();
			
				// For debugging
				//etzChaim.printLeaves();
			}

			else {
				System.out.format (
				"Argument %s not found", args[1]);

				System.exit(0);
			}

		}

	}// end main
}
