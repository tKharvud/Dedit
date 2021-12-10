///////////////////////////////////////
// Tyler Harwood & Seth Vaughn      //
// COS225 FINAL PROJECT            //
// Professor Schotter             //
// 15 December 2021              //
//////////////////////////////////

// Imports
import java.io.File;

public class text extends File{

    // Pointers
    public Folder parent;

    // Attributes
    private String type;

    // Constructor
    public text (File f) {

	type = "text";
	parent = null;

    }

	
// Getters
String getType() { return type; }

// Setters

}
