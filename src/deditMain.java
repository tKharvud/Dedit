///////////////////////////////////////
// Tyler Harwood & Seth Vaughn      //
// COS225 FINAL PROJECT            //
// Professor Schotter             //
// 15 December 2021              //
//////////////////////////////////

// Imports
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class deditMain {




	public static void main (String[] args) {


		File head = new File("..");
		File[] hlist = head.listFiles();
		
		FileTree etzChaim = new FileTree(head);


		// If args.length is 0, enter user-interface
		if(args.length == 0){
			


			System.out.println("UI goes here");
		}
		else if(args.length == 1){
	
			if(args[0].equals("print")){
			
				etzChaim.print();
			}
		}

	}
}
