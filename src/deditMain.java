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

		File head = new File("..");
		File[] hlist = head.listFiles();
		
		FileTree etzChaim = new FileTree(head);

		etzChaim.print();

	}
}
