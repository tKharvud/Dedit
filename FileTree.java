///////////////////////////////////////
// Tyler Harwood & Seth Vaughn      //
// COS225 FINAL PROJECT            //
// Professor Schotter             //
// 17 December 2021              //
//////////////////////////////////

// IMPORTS
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

class FileTree {
    
    private Folder head = null;

    // CONSTRUCTOR
    FileTree (File f) {
        System.out.println ("FileTree Created");
        head = new Folder (f);
        head.parent = null;


        File[] headChildren = f.listFiles();
        for(int i=0; i < headChildren.length; i++)
            build(head, headChildren[i]);
     
    }

    void build (Folder currentFolder, File directory) {

        File[] children = directory.listFiles();

        if (directory.isFile() && directory) {
            currentFolder.files.add();
            return;
        }

        else if (directory.isDirectory()) {
            Folder childFolder = Folder (directory);
            childFolder.parent = currentFolder;
            childFolder.parent.folders.add(childFolder);

            for (int i = 0; i < children.length; i++) {
                build (childFolder, children[i]);
            }
        }
        
        else {
            System.out.println ("What the hell am I looking at");
        }

    }

    void addFile (Folder parent, File child) {


        
    }

    void addFolder (Folder parent, Folder child) {



    }

}