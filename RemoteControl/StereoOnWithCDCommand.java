/*******************************************************
 * Name:        YUSHAN HUNG
 * Course:       ACS-3913
 * Student ID:  3133878
 * Assignment:  Assigment3
 ********************************************************/
public class StereoOnWithCDCommand extends Command {
    private Stereo stereo;
    private Command lastCommand;
    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
        lastCommand = new NoCommand();
    }

    public void execute() {
        lastCommand = stereo.getExecutedComman();
        stereo.on();
        stereo.setCD();
        stereo.setVolume(6);
        stereo.setExecutedComman(this);
    }
    
    public void undo() {
        if(lastCommand instanceof NoCommand){
            stereo.off();
        }
        else{
            lastCommand.execute();
        }
    }
}
