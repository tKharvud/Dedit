///////////////////////////////////////
// Tyler Harwood & Seth Vaughn      //
// COS225 FINAL PROJECT            //
// Professor Schotter             //
// 15 December 2021              //
//////////////////////////////////

// DECRIPTION:
//	
//	


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
    private int depth;

    // Constructor
    public Folder (File f) {

	self = f;
	name = f.getName();
	path = f.getAbsolutePath();
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
	int depth() { return depth; }


	// Iterative print of folders
	String printFolders()
	{
		String output = "";

		for(int i = 0; i < folders.toArray().length; i++)
		{
			for(int j = 0; j < depth; j++)
			{
				System.out.print("\t");
				output = output.concat("\t");
			}	

			System.out.format("%s\n", folders.get(i).name());
			output = output.concat(
				String.format("%s\n", folders.get(i).name())
			);			
		}	
		
			
	
		return output;
	}

	// Iterative print of files
	String printFiles()
	{
		String output = "";

		for(int i = 0; i < files.toArray().length; i++)
		{
			for(int j = 0; j < depth; j++)
			{
				System.out.print("\t");
				output = output.concat("\t");
			}	


			System.out.format("%s\n", files.get(i).getName());

			output = output.concat(
				String.format("%s\n", files.get(i).getName())
			);
		}
		
		return output;	
	}

	void printID()
	{

		for(int i = 0; i < files.toArray().length; i++)
		{
			for(int j = 0; j < depth; j++)
			{
				System.out.print("\t");
			}	

			System.out.format("%d\n", files.get(i).hashCode());
		}
		
		return;	
	}




	// Generic Iterative Quick Sort
	// WHERE I LEARNED QUICKSORT: 
	// 	https://www.geeksforgeeks.org/iterative-quick-sort/
	public void sort()
	{
		int start = 0;
		int end = files.size() - 1;

		
	}
	


	// Iterative binary search for FILE 
	// NOT MINE: https://www.techiedelight.com/binary-search/
    public File findFile(String target)
    {
        // search space is nums[left…right]
        int left = 0, right = files.size() - 1;
 
        // loop till the search space is exhausted
        while (left <= right)
        {
            // find the mid-value in the search space and
            // compares it with the target
 
            int mid = (left + right) / 2;
 
            // overflow can happen. Use:
            // int mid = left + (right - left) / 2;
            // int mid = right - (right - left) / 2;
 
            // target is found
            if (target.equals( files.get(mid) )) {
                return files.get(mid);
            }
 
            // discard all elements in the right search space,
            // including the middle element
            else if (target.charAt(0) < files.get(mid).getName().charAt(0)) {
                right = mid - 1;
            }
 
            // discard all elements in the left search space,
            // including the middle element
            else {
                left = mid + 1;
            }
        }
 
        // `target` doesn't exist in the array
        return null;
    }


	// Iterative binary search for FOLDER
	// NOT MINE, BASED ON: https://www.techiedelight.com/binary-search/

    public Folder findFolder(String target)
    {
        // search space is nums[left…right]
        int left = 0, right = folders.size() - 1;
 
        // loop till the search space is exhausted
        while (left <= right)
        {
            // find the mid-value in the search space and
            // compares it with the target
 
            int mid = (left + right) / 2;
 
            // overflow can happen. Use:
            // int mid = left + (right - left) / 2;
            // int mid = right - (right - left) / 2;
 
            // target is found
            if (target.equals( folders.get(mid) )) {
                return folders.get(mid);
            }
 
            // discard all elements in the right search space,
            // including the middle element
            else if (target.charAt(0) < folders.get(mid).name().charAt(0)) {
                right = mid - 1;
            }
 
            // discard all elements in the left search space,
            // including the middle element
            else {
                left = mid + 1;
            }
        }
 
        // `target` doesn't exist in the array
        return null;
    }




	// Linear search for FOLDER
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
