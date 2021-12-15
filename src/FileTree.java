///////////////////////////////////////
// Tyler Harwood & Seth Vaughn      //
// COS225 FINAL PROJECT            //
// Professor Schotter             //
// 15 December 2021              //
//////////////////////////////////

//DESCRIPTION:
// An unbalanced linked tree of Folders with an undefined width and depth. 
// Covers Use of Linked nodes, File IO, and overloading.


// Imports
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;

class FileTree {
    
    // head
    private Folder head = null;
	
	// Array list containing all leaf nodes
	private ArrayList<Folder> leaves = new ArrayList<Folder>();

	// Array list of user-saved shortcuts
	private ArrayList<Folder> shortcuts;

	// Other attributes



	

    // Overloaded Constructor
    FileTree (File f) {

        System.out.println ("FileTree Created");

        head = new Folder (f);
        head.parent = null;


        File[] headChildren = f.listFiles();
        for (int i=0; i < headChildren.length; i++)
            build (head, headChildren [i]);
     
    }
	
	/*/// Default constructor
	FileTree(){

		System.out.println("Branch FileTree Created");

		int num = 0;
		if()

		String title = format("rip%d", num);



		File base = new File(title);
		File header = new File(base, "header.txt");

		head = new Folder(base);
		
		File

	}
	/*///


// Internal function that recursively builds the File tree
    private void build (Folder currentFolder, File directory) {

        File[] children = directory.listFiles();

        if (directory.isFile() && (directory.getParentFile() != null))
	{
            	currentFolder.files.add (directory);
            	return;
        }

        else if (directory.isDirectory()) 
	{
            Folder childFolder = new Folder (directory);
            childFolder.parent = currentFolder;
            childFolder.parent.folders.add (childFolder);
	    childFolder.set_depth( currentFolder.depth() + 1 );

            for(int i = 0; i < children.length; i++) 
	    {
                build (childFolder, children [i]);
            }

	//// Adds leaf nodes to leaves arrayList
	    if(childFolder.folders.size() == 0)
	    {
	    	leaves.add(childFolder);
	    }
	////
        }
        
        else { System.out.println ("What the hell am I looking at"); }

    }

// METHODS BY SETH VAUGHN

// Adds a file to a specified folder relative to the folder being viewed
    void addFile (Folder parent, File f) {
	parent.files.add (f);   
    }

// Adds a Folder to a specified folder relative to the folder being viewed
    void addFolder (Folder parent, Folder child) {
	parent.folders.add (child);
    }

// navigates to a folder based on a name or relative path
    public Folder cdForward (Folder currentFolder, String name) {

	String[] path = name.split("/");
	Folder p = currentFolder;
	
	//Loop through path, traversing tree until end. 
	for(int i = 0; i < path.length; i++){

		if(path[i].equals("..") && p != null) { p = p.parent; }
		else if(p != null)
		{ 
			Folder out = p.searchFor (path[i]);
			if(out != null) p = out;
		}
		else { System.out.format("%s does not exist\n", path[i]); }
	}

	return p;

    }


// METHODS BY TYLER HARWOOD





	// Exports file Tree to file according to format defined in print()
	public void export(Folder p)
	throws IOException 
	{
		System.out.format(
			"\nExporting map of Library from %s\n\n",
			p.path()
		);

		String outName = String.format(
				"output_files/%s_%s.txt",
				p.self.getName(),
				LocalDateTime.now()
			      );
		FileWriter w = new FileWriter(outName);
		

		w.write(print_p(p));
		w.close();
	}


	// Prints the File tree recursively
	public void print() { print_p(head); }
	private String print_p(Folder p)
	{
		String output = "";

		if(p.folders.size() == 0)
		{
			output = output.concat(p.printFiles());
			
		}

		else if(p.folders.size() > 0)
		{
			output = output.concat(p.printFiles());

			// Recursive print and traversal into folders
			for(int i = 0; i < p.folders.size(); i++)
			{

				for(int j = 0; j < p.depth(); j++)
				{
					System.out.print("\t");
					output = output.concat("\t");
				}	

				System.out.format(
					"%s\n", p.folders.get(i).path()
				);
				output = output.concat( 
					String.format(
						"%s\n", 
						p.folders.get(i).path()
					)
				);

				//Recursive call
				output = output.concat(
					print_p(p.folders.get(i))
				);
			}

		}
		
		else
		{
			System.out.println("Something bad happened :^/"); 
			return "~~~~~~~OUTPUT ERROR~~~~~~";
		}

		return output;
	}

// Setters

	// Adds a given Folder to the leaf node array list. Not used.
	void addLeaf(Folder f) { leaves.add(f); }


// Getters
	
	Folder getHead() { return head; }
	
	void printLeaves()
	{
		for(int i = 0; i < leaves.size(); i++)
		{
			System.out.format("\t%s\n", leaves.get(i).path());
		}
	}


}
