///////////////////////////////////////
// Tyler Harwood & Seth Vaughn      //
// COS225 FINAL PROJECT            //
// Professor Schotter             //
// 17 December 2021              //
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
    private String name;
    private int depth;

    // Constructor
    public Folder (File f) {

	self = f;
	name = f.getName();
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
	int depth() { return depth; }

	void printFolders()
	{
		for(int i = 0; i < folders.toArray().length; i++)
		{
			System.out.println(folders.get(i));
		}
	}

	void printFiles()
	{
		for(int i = 0; i < files.toArray().length; i++)
		{
			System.out.println(files.get(i));
		}
	}





}
