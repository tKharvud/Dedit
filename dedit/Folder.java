
// Imports
import java.util.ArrayList;
import java.io.File;

public class Folder{

// attributes
public Folder self, parent;
public ArrayList<Folder> folders, files;



// Constructor
public Folder(File f){

	self = f;
	parentFolder = f.getParent();
	
	files = new ArrayList<File>();
	folders = new ArrayList<Folder>();


}


	// SETTERS
	void addFolder(Folder o) { folders.add(o); }
	void addFile(File o) { files.add(o); }

}
