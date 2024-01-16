/*******************************************************
 * Name:        YUSHAN HUNG
 * Course:       ACS-3913
 * Student ID:  3133878
 * Assignment:  Assigment3
 ********************************************************/
public class LightOffCommand extends Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }
    
    public void undo() {
        light.on();
    }
}
