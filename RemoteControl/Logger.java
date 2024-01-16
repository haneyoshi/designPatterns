
/**
 * Write a description of class Logger here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 
public class Logger
{
    private String nameOfCommand;
    private static Logger uniqueInstance;
    FileWriter fw;
    private Logger(){
        nameOfCommand ="";
        try{
            fw = new FileWriter("log.txt");
        }catch(IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public static Logger getInstance(){
        if (uniqueInstance == null) {
            uniqueInstance = new Logger();
        }
        return uniqueInstance;
    }
    
    public void log(String name){
        try{
            DateTimeFormatter dtf = 
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();
            fw.write(now +" "+ name+"\n");
        }catch(IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void closeLogger(){
        try{
            fw.close();
        }catch(IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
