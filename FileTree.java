///////////////////////////////////////
// Tyler Harwood & Seth Vaughn      //
// COS225 FINAL PROJECT            //
// Professor Schotter             //
// 17 December 2021              //
//////////////////////////////////

// Imports
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileTree {
    
    // Head
    private Folder head = null;
	
	// Array list containing all leaf nodes.
	private ArrayList <File> leaves;

	// Array list of user-saved shortcuts.
	private ArrayList <Folder> shortcuts;

	// Other Attributes

    // Constructor
    public FileTree (File f) {

        System.out.println ("FileTree created.");

        head = new Folder (f);
        head.parent = null;

        File[] headChildren = f.listFiles();
        for (int i = 0; i < headChildren.length; i++) {
            build (head, headChildren [i]);
        }
    
    }

    // Internal function that recursively builds the FileTree.
    private void build (Folder currentFolder, File directory) {

        File[] children = directory.listFiles();

        if (directory.isFile() && (directory.getParentFile() != null)) {
            currentFolder.files.add (directory);
            return;
        }

        else if (directory.isDirectory()) {
            
            Folder childFolder = new Folder (directory);
            childFolder.parent = currentFolder;
            childFolder.parent.folders.add (childFolder);
	        childFolder.set_depth (currentFolder.depth() + 1);

            for (int i = 0; i < children.length; i++) {
                build (childFolder, children [i]);
            }

        }
        
        else {
            System.out.println ("What the hell am I looking at?");
        }

    }

    // METHODS BY SETH VAUGHN

    // Adds a file to a specified folder relative to the folder being viewed.
    void addFile (Folder parent, File f) {
        parent.files.add (f);
    }

    // Adds a Folder to a specified folder relative to the folder being viewed.
    void addFolder (Folder parent, Folder child) {
        parent.folders.add (child);
    }

    public Folder cdForward (Folder currentFolder, String name) {
        return currentFolder.searchForFolder(currentFolder.folders, name);
    }

    // METHODS BY TYLER HARWOOD

	// Prints the File tree recursively.
	public void print() {
        print_p (head);
    }

	private void print_p (Folder p) {

		if (p.folders.toArray().length == 0) {
			p.printFiles();
			return;
		}

		else if (p.folders.toArray().length > 0) {

			p.printFiles();

			// Recursive print and traversal into folders
			for (int i = 0; i < p.folders.toArray().length; i++) {

				for (int j = 0; j < p.depth(); j++) {
					System.out.print("\t");
                }
				System.out.format ("%s\n", p.folders.get (i).path());

				//Recursive call
				print_p (p.folders.get (i));

			}

		}
		
		else {
            System.out.println ("What the hell am I looking at?");
        }

	}

	// Adds a given File to the leaf node array list. 
	void addLeaf (File f) {
        leaves.add(f);
    }

}