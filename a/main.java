///////////////////////////////////////
// Tyler Harwood & Seth Vaughn      //
// COS225 FINAL PROJECT            //
// Professor Schotter             //
// 17 December 2021              //
//////////////////////////////////

// IMPORTS
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class main{





static void traverse(File dir)
{	
	File[] flist = dir.listFiles();

	if(dir.isFile())
	{
		System.out.println(dir.getPath());
		return;
	}

	else if(dir.isDirectory())
	{
		for(int i = 0; i < flist.length; i++)
		{
			traverse(flist[i]);
		}
	}
	
	else{ System.out.println("What the hell am I looking at"); }
}




public static void main(String[] args){

	
	File head = new File("..");
	File[] hlist = head.listFiles();
	

	/*/// Print all files and directories in head 
	for(int i = 0; i < hlist.length; i++) 
	{ System.out.println(hlist[i].getPath()); }
	/*///

	
	traverse(head);

	




}// main end
}
