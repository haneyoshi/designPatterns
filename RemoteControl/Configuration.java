/*******************************************************
 * Name:        YUSHAN HUNG
 * Course:       ACS-3913
 * Student ID:  3133878
 * Assignment:  Assigment3
 ********************************************************/
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
 public class Configuration
{
    private int numberOfOptions;
    private int height;
    private static Configuration uniqueInstance;
    private Configuration(){
        try {
            	//read the file RemoteConfig.txt
        	FileInputStream fi = new FileInputStream(new File("RemoteConfig.txt"));
        	ObjectInputStream oi = new ObjectInputStream(fi);
                //set the values to the two fields
        	numberOfOptions = (int) oi.readObject();
        	height = (int) oi.readObject();
        	oi.close();
        	fi.close();
                //end of reading the file
	} catch (FileNotFoundException e) {
		System.out.println("File not found");
	} catch (IOException e) {
		System.out.println("Error initializing stream");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
    }
    
    public static Configuration getInstance(){
        if (uniqueInstance == null) {
            uniqueInstance = new Configuration();
        }
        return uniqueInstance;
    }
    
    public int getNumberOfOptions(){
        return numberOfOptions;
    }
    
    public int getHeight(){
        return height;
    }
}