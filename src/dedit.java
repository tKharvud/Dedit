///////////////////////////////////////
// Tyler Harwood & Seth Vaughn      //
// COS225 FINAL PROJECT            //
// Professor Schotter             //
// 17 December 2021              //
//////////////////////////////////

// Imports
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class dedit {

// Global data



// Functions

	public void rerip(FileTree etzChaim)
	{
		FileTree yggdrasil = new FileTree
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
