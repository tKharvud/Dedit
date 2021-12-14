///////////////////////////////////////
// Tyler Harwood & Seth Vaughn      //
// COS225 FINAL PROJECT            //
// Professor Schotter             //
// 15 December 2021              //
//////////////////////////////////

// Imports
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

class FileTree {
    
    // head
    private Folder head = null;
	
	// Array list containing all leaf nodes
	private ArrayList<File> leaves = new ArrayList<File>();

	// Array list of user-saved shortcuts
	private ArrayList<Folder> shortcuts;

	// Other attributes



    // Constructor
    FileTree (File f) {

        System.out.println ("FileTree Created");

        head = new Folder (f);
        head.parent = null;


        File[] headChildren = f.listFiles();
        for (int i=0; i < headChildren.length; i++)
            build (head, headChildren [i]);
     
    }
	
	// Alternate constructor
	FileTree(){

		System.out.println("Branch FileTree Created");

		int num = 0;
		// if()

		// String title;
		// title = title.format("rip%d", num);



		// File base = new File(title);
		// File header = new File(base, "header.txt");

		// head = new Folder(base);

	}

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
	    if(childFolder.folders.toArray().length == 0
		&& childFolder.files.toArray().length != 0)
	    {
	    	for(int i = 0; i < childFolder.files.toArray().length; i++)
	    	{
			// System.out.println(childFolder.files.get(i).getName());
			leaves.add(childFolder.files.get(i));
	    	}
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


	// Prints the File tree recursively
	public void print() { print_p(head); }
	private void print_p(Folder p)
	{

		if(p.folders.toArray().length == 0)
		{
			p.printFiles();
			return;
		}

		else if(p.folders.toArray().length > 0)
		{
			p.printFiles();

			// Recursive print and traversal into folders
			for(int i = 0; i < p.folders.toArray().length; i++)
			{
				for(int j = 0; j < p.depth(); j++)
					System.out.print("\t");

				System.out.format(
					"%s\n", p.folders.get(i).path()
				);

				//Recursive call
				print_p(p.folders.get(i));
			}
		}
		
		else{ System.out.println("Something bad happened :^/"); }
	}

// Setters

	// Adds a given File to the leaf node array list. 
	void addLeaf(File f) { leaves.add(f); }


// Getters
	
	Folder getHead() { return head; }
	
	void printLeaves()
	{
		for(int i = 0; i < leaves.toArray().length; i++)
		{
			System.out.format("\t%s\n", leaves.get(i).getPath());
		}
	}

	// File search()

}
