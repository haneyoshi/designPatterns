/*******************************************************
 * Name:        YUSHAN HUNG
 * Course:       ACS-3913
 * Student ID:  3133878
 * Assignment:  Assigment3
 ********************************************************/
public class LightOnCommand extends Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }
    
    public void undo() {
        light.off();
    }
    
    //test
    public String toString(){
    return "a light-on command";
    }
}
