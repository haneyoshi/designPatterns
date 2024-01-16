/*******************************************************
 * Name:        YUSHAN HUNG
 * Course:       ACS-3913
 * Student ID:  3133878
 * Assignment:  Assigment3
 ********************************************************/
public class MacroOffCommand extends Command {
    Command[] commands;
    public MacroOffCommand(Command[] commands) {
        this.commands = commands;
    }

    public void execute() {
        for (int i = commands.length -1; i >= 0; i--) {
            commands[i].undo();
        }
    }

    /**
     * NOTE:  these commands have to be done backwards to ensure proper undo functionality
     */
    public void undo() {
        for (int i = 0; i < commands.length; i++) {
            commands[i].execute();
        }
    }
}
