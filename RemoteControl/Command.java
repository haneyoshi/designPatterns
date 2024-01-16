/*******************************************************
 * Name:        YUSHAN HUNG
 * Course:       ACS-3913
 * Student ID:  3133878
 * Assignment:  Assigment3
 ********************************************************/
public abstract class Command implements Cloneable{
    public abstract void execute();
    public abstract void undo();
    Logger logger = Logger.getInstance();
    /**
    * clone
    * @return Object: this command
    */
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }
    
    public void logCommand(String name){
        logger.log(name);
    }
    public void executeWithLog(){
        logCommand(this.getClass().getName());
        execute();
    }
    public void undoWithLog(){
        logCommand(this.getClass().getName());
        undo();
    }
}

