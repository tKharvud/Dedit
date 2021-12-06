// import java.lang.Runtime;
// import java.lang.Math;
import java.io.File;

public class test {



    public static void main (String[] args) {

        // Runtime r = Runtime.getRuntime();
        
        // System.out.println (r.availableProcessors());
        // System.out.println ((r.totalMemory() / Math.pow (1024, 2)));
        // System.out.println ((r.freeMemory() / Math.pow (1024, 2)));
        // System.out.println ((r.totalMemory() - r.freeMemory()) / Math.pow (1024, 2));

        // File file = new File ("../Test");
        // String[] fileList = file.list();

        // for (int x = 0; x < fileList.length; x++) {
        //     System.out.println (fileList [x]);
        // }

        File fileAlias = new File ("testDir");
        File[] aliasFileList = fileAlias.listFiles();

        for (int x = 0; x < aliasFileList.length; x++) {
            System.out.println (aliasFileList [x]);
        }

        File testFile = new File ("..");
        File[] testFileList = testFile.listFiles();

        for (int x = 0; x < testFileList.length; x++) {
            System.out.println (testFileList [x]);
        }

        System.out.println (testFile.length());

        System.out.println (testFile.exists());

    }

}