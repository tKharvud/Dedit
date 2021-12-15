///////////////////////////////////////
// Tyler Harwood & Seth Vaughn      //
// COS225 FINAL PROJECT            //
// Professor Schotter             //
// 15 December 2021              //
//////////////////////////////////

//DESCRIPTION:
//	Main/Driver class. Initializes File Tree and displays User Interface

// Imports
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class dedit {


//// Functions

	// Create branch to write sorted library to
	public void rerip(FileTree etzChaim)
	{
		//FileTree yggdrasil = new FileTree();
		int x;
	}




	// Determines file type based on extension
	public static String getType(File f)
	{

		// File types

		String[] docslist = {".pdf", ".ott", ".rtf", ".doc", ".docm", ".docx", ".abw", ".aww", ".chm", ".cnt", ".dbx", ".djvu", ".dot", ".dotm", ".dotx", ".epub", ".gp4", ".ind", ".indd", ".key", ".keynote", ".mht", ".mpp", ".odf", ".ods", ".odt", ".opx", ".oxps", ".pages", ".pmd", ".pot", ".potx", ".pps", ".ppsx", ".ppt", ".pptm", ".pptx", ".prn", ".prproj", ".ps", ".pub", ".pwi", ".sdd", ".sdw", ".shs", ".snp", ".sxw", ".tpl", ".vsd", ".wpd", ".wps", ".wri", ".xps" };

		String[] imagelist = {".jpg", ".png", ".gif", ".jpeg", ".bmp", ".cpt", ".dds", ".dib", ".dng", ".emf", ".heic", ".ico", ".icon", ".pcx", ".pic", ".psd", ".psdx", ".raw", ".tga", ".thm", ".tif", ".tiff", ".wbmp", ".wdp", ".webp", ".arw", ".cr2", ".crw", ".dcr", ".dng", ".fpx", ".mrw", ".nef", ".orf", ".pcd", ".ptx", ".raf", ".raw", ".rw2" };

		String[] exelist = {".class", ".jar", ".exe", ".air", ".app", ".application", ".appx", ".bat", ".bin", ".com", ".cpl", ".deb", ".dll", ".elf", ".js", ".lnk", ".msi", ".part1.exe", ".prg", ".rpm", ".shs", ".vbs", ".xap" };

		String[] sheetslist= {".xls", ".xlsm", ".xlsx", ".sxc", ".ods", ".sdc", ".numbers" };

		String[] soundlist = {".mp3", ".ogg", ".wav", ".midi", ".m4a", ".m4b", ".m4p", ".wma", ".opus", ".wpl", ".3ga", ".aac", ".aiff", ".amr", ".ape", ".arf", ".asf", ".asx", ".cda", ".dvf", ".flac", ".gp4", ".gp5", ".gpx", ".logic", ".pcm", ".rec", ".snd", ".sng", ".uax", ".zab" };

		String[] srclist = {".java", ".c", ".py", ".asm", ".asp", ".aspx", ".bat", ".htm", ".inc", ".jad", ".js", ".json", ".jsp", ".lib", ".o", ".php", ".rc", ".rss", ".scpt", ".src", ".vbs", ".xcodeproj", ".xml", ".xsd", ".xsl", ".xslt" };


		String[] textlist = {".txt", ".text", ".rtf", ".csv", ".html", ".xml", ".xsd", ".xsl", ".xslt", ".1st", ".alx", ".application", ".asp", ".htm", ".log", ".lrc", ".lst", ".md", ".nfo", ".opml", ".plist", ".reg", ".srt", ".sub", ".tbl", ".xmp" };


		String[] threeDlist = {".3d", ".3ds", ".c4d", ".dgn", ".dwfx", ".dwg", ".dxf", ".ipt", ".lcf", ".max", ".obj", ".pro", ".skp", ".stl", ".u3d", ".x_t" };


		String[] videolist = {	
			".mp4", ".mov", ".webm", ".mkv", ".avi", ".mpeg",
			".m4v", ".wmv", ".264", ".3g2", ".3gp", ".arf", ".asf", 
			".asx", ".bik", ".dash", ".dat", ".dvr", ".flv", 
			".h264", ".m2t", ".m2ts", ".mod", ".mpg", ".mts", 
			".ogv", ".prproj", ".rec", ".rmvb", ".swf", ".tod", 
			".tp", ".ts", ".vob", ".wlmp"
		};

		String[][] typelist = { textlist, imagelist, docslist, exelist, sheetslist, soundlist, srclist, threeDlist, videolist };



		// Extract extension
		String extension = ".";
		String[] parts = f.getName().split("\\.");
		if(parts.length > 0)
		{
			extension = extension.concat( parts[parts.length-1] );

			
			// Linear search to Determine file type
			for(int i = 0; i < typelist.length; i++)
			{
				for(int j = 0; j < typelist[i].length; j++)
				{
					if(extension.equals(typelist[i][j]))
					{

						switch(i)
						{
						case 0:
							return "text";
						case 1:
							return "image";
							
						case 2:
							return "document"; 
							
						case 3:
							return "executable"; 
							
						case 4: 
							return "spreadsheet";
							
						case 5:
							return "sound";
							
						case 6:
							return "sourcecode";
							
						case 7:
							return "3d";
							
						case 8:
							return "video";
							

						}
			
					}
				}
			}
		}		
		// else
		return "File";
	}



	// Prints the UI based on current folder
	public static void printUI(Folder p)
	{

		String directoriesString = "Directories";
		String filesString = "Files";
		String typeString = "Type";
		String sizeString = "Size";

		//Folder Header
		System.out.println(
				"------------------------------------------------------------------------------------------------"
		);
		System.out.format(
			"\n\t%-40s\t%-10s\t%-10s\n\n",
			directoriesString,
			typeString,
			sizeString		
		);

		// Folders
		for(int i = 0; i < p.folders.size(); i++)
		{

			String folderString = "Folder";
			long folderSize = p.folders.get(i).self.length();

			//Prints when size is greater than one GB.
			if(folderSize >= 1073741824){

				folderSize = folderSize / 1073741824;

				System.out.format(
				"\t%-40s\t%-10s\t%-10d GB\n", 
				p.folders.get(i).name(),
				folderString,
				folderSize
				);

			}

			//Prints when size is greater than one MB.
			else if(folderSize >= 1048576){

				folderSize = folderSize / 1048576;

				System.out.format(
				"\t%-40s\t%-10s\t%-10d MB\n", 
				p.folders.get(i).name(),
				folderString,
				folderSize
				);

			}

			//Prints when size is greater than one KB.
			else if(folderSize >= 1024){

				folderSize = folderSize / 1024;

				System.out.format(
				"\t%-40s\t%-10s\t%-10d KB\n", 
				p.folders.get(i).name(),
				folderString,
				folderSize
				);

			}

			//Prints when size is less than one KB.
			else{

				System.out.format(
				"\t%-40s\t%-10s\t%-10d bytes\n", 
				p.folders.get(i).name(),
				folderString,
				folderSize
				);

			}

		}

		//File Header
		System.out.println(
				"\n------------------------------------------------------------------------------------------------"
		);
		System.out.format(
			"\n\t%-40s\t%-10s\t%-10s\n\n",
			filesString,
			typeString,
			sizeString		
		);

		// Files
		for(int j = 0; j < p.files.size(); j++)
		{

			String fileString = getType(p.files.get(j));
			long fileSize = p.files.get(j).length();

			if(fileSize >= 1073741824){

				fileSize = fileSize / 1073741824;

				System.out.format(
				"\t%-40s\t%-10s\t%-10d GB\n", 
				p.files.get(j).getName(),
				fileString,
				fileSize
				);

			}

			else if(fileSize >= 1048576){

				fileSize = fileSize / 1048576;

				System.out.format(
				"\t%-40s\t%-10s\t%-10d MB\n", 
				p.files.get(j).getName(),
				fileString,
				fileSize
				);

			}

			else if(fileSize >= 1024){

				fileSize = fileSize / 1024;

				System.out.format(
				"\t%-40s\t%-10s\t%-10d KB\n", 
				p.files.get(j).getName(),
				fileString,
				fileSize
				);

			}

			else{

				System.out.format(
				"\t%-40s\t%-10s\t%-10d bytes\n", 
				p.files.get(j).getName(),
				fileString,
				fileSize
				);

			}
	
		}

		// Description
		String descHeader = "Commands Description";
		String cdString = "cd";
		String cdDesc = "Navigate into given folder.";
		String exportString = "export";
		String exportDesc = "Prints a map of the FileTree to a .txt file.";
		String quitString = "q";
		String quitDesc = "Quits program.";

		System.out.println(
				"\n------------------------------------------------------------------------------------------------"
		);
		System.out.format(
			"\n\t%-40s\n\n",
			descHeader
		);
		System.out.format(
			"\t%-40s\t%-10s\n",
			cdString,
			cdDesc
		);
		System.out.format(
			"\t%-40s\t%-10s\n",
			exportString,
			exportDesc
		);
		System.out.format(
			"\t%-40s\t%-10s\n",
			quitString,
			quitDesc
		);

	}




// The State of Maine
	public static void main (String[] args)
	throws InterruptedException {


		File head = new File("..");
		
		FileTree etzChaim = new FileTree(head);
		Folder currentDir = etzChaim.getHead();


		// If args.length is 0, enter user-interface
		if(args.length == 0){

			Boolean quitBool = false;


			Scanner menuScan = new Scanner (System.in);

			while (quitBool == false) {

				// Header for UI
				System.out.println(currentDir.path());

				// UI print of files
				printUI (currentDir);
				System.out.println(
					"\n------------------------------------------------------------------------------------------------\n"
				);

				// USER INPUT
				System.out.println("Enter a command");
				System.out.print(">>> ");

				String[] input= menuScan.nextLine().split(" ");

				if (input[0].equals ("q")) {
					quitBool = true;
				}

				else if(input[0].equals("cd")){

					Folder r = etzChaim.cdForward(
						currentDir, input[1]
					);

					if(r!= null) currentDir = r;

				}

				// else if(input[0].equals("print")){

				// 	if(currentDir.folders.size() > 0)
				// 		currentDir.printFolders();

				// 	if(currentDir.files.size() > 0)
				// 		currentDir.printFiles();

				// }
				
				// Exports from current directory
				else if(input[0].equals("export")){

					while(true){
						try{ etzChaim.export(currentDir); break; }
						catch(IOException e){
						System.out.print("Directory \"output_files\" not found, creating...");
						File newDir = new File ("output_files");
						newDir.mkdir();
						}
					}

				}

				// else if(input[0].equals("sort")){

				// 	if(currentDir.folders.size() > 0)
				// 		//currentDir.sortFolders();
				// 		currentDir.printFolders();

				// 	if(currentDir.files.size() > 0)
				// 		//currentDir.sortFiles();
				// 		currentDir.printFiles();

				// }

				else {
					System.out.print ("Invalid command. Restarting...");
					Thread.sleep(2000);
					quitBool = false;
				}

				System.out.print("\n");
			}

			menuScan.close();
			System.exit(0);

		}

		// If args.length is 1, check which argument it is.
		else if(args.length == 1){
	
			// If argument is "help", enter help.
			if (args [0].equals ("help")) {

				try {

					File readme = new File ("readme.txt");
					Scanner helpScan = new Scanner (readme);

					while (helpScan.hasNext()) {

						System.out.println (helpScan.nextLine());

					}

					helpScan.close();

				} catch (FileNotFoundException e) {
					System.out.println("readme.txt not found.");
				}

			}

			// If argument is "search", enter search.
			else if (args [0].equals ("search")) {
				System.out.println ("This will enter search.");
			}
		
			else if (args [0].equals ("rip")) {
				System.out.println ("This will enter rip.");
			}
	
			// If argument is "print", enter print.
			else if (args [0].equals ("print")) {

				etzChaim.print();
				// For debugging
				//etzChaim.printLeaves();
			}

			else if (args [0].equals ("export")) {

				while(true){
					try{ etzChaim.export(etzChaim.getHead()); break; }
					catch(IOException e){
					System.out.print("Directory \"output_files\" not found, creating...");
					File newDir = new File ("output_files");
					newDir.mkdir();
					}
				}
			}

			else {
				System.out.format (
				"Argument %s not found\n%s",
					args[0],
					"Run with: \"java dedit help\"\n"
				);

			}

		}

	// On-exit export?
	//try{ etzChaim.export(); }
	//catch(IOException e){ System.exit(0); }

	}// end main
}
