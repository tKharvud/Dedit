///////////////////////////////////////
// Tyler Harwood & Seth Vaughn      //
// COS225 FINAL PROJECT            //
// Professor Schotter             //
// 17 December 2021              //
//////////////////////////////////

// Imports
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class deditMain {

	public static void main (String[] args) {

		File head = new File ("..");
		File[] hlist = head.listFiles();
		FileTree etzChaim = new FileTree (head);

		// If args.length is 0, enter user-interface.
		if (args.length == 0) {

			Boolean quitBool = false;

			Scanner menuScan = new Scanner (System.in);

			while (quitBool == false) {

				System.out.println ("Enter a command: ");

				if (menuScan.nextLine().equals ("q")) {
					quitBool = true;
				}

				else {
					quitBool = false;
				}

			}

			menuScan.close();

			// TEST

			

		}

		// If args.length is 1, check which argument it is.
		else if (args.length == 1) {

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
			}

			else {
				System.out.println ("Invlaid argument.");
			}

		}

		else {
			System.out.println ("Invlaid arguments.");
		}

	}

}