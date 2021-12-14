///////////////////////////////////////
// Tyler Harwood & Seth Vaughn      //
// COS225 FINAL PROJECT            //
// Professor Schotter             //
// 15 December 2021              //
//////////////////////////////////

// Imports
import java.util.ArrayList;
import java.io.File;

public class Folder {

    // Pointers
    public Folder parent;
    public ArrayList <Folder> folders;
    public ArrayList <File> files;

    // Attributes
    public File self;
    private String name, path;
	private long length;
    private int depth;

    // Constructor
    public Folder (File f) {

	self = f;
	name = f.getName();
	path = f.getAbsolutePath();
	length = f.length();
	depth = 0;

	parent = null;
	
	files = new ArrayList <File>();
	folders = new ArrayList <Folder>();

    }


// Setters
	void addFolder (Folder o) { folders.add(o); }

	void addFile (File o) { files.add(o); }

	void set_depth(int n) { depth = n; }

	
// Getters
	String name() { return name; }
	String path() { return path; }
	long length() { return length; }
	int depth() { return depth; }

	// Non-recursive print of folders
	void printFolders()
	{
		for(int i = 0; i < folders.toArray().length; i++)
		{
			for(int j = 0; j < depth; j++)
				System.out.print("\t");

			System.out.format("%s\n", folders.get(i).name());

			
		}		
	}

	void printFiles()
	{
		for(int i = 0; i < files.toArray().length; i++)
		{
			for(int j = 0; j < depth; j++)
				System.out.print("\t");

			System.out.format("%s\n", files.get(i).getName());

			
		}
	}

	// Generic binary search



	// Generic Linear search
    Folder searchFor (String name) {

        for (int i = 0; i < folders.size(); i++) {
            if (folders.get (i).name().equals (name)) {
                return folders.get(i);
            }
        }

        System.out.println ("No match found.");
        return null;

    }

 




   
	// toString Override
	//@Override

}
