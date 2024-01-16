/*******************************************************
 * Name:        YUSHAN HUNG
 * Course:       ACS-3913
 * Student ID:  3133878
 * Assignment:  Assigment3
 ********************************************************/
import java.util.Stack;
 public class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;
    public RemoteControl() {
        Configuration configuration = Configuration.getInstance();
        final int NUM_COMMANDS = configuration.getNumberOfOptions();
        onCommands = new Command[NUM_COMMANDS];
        offCommands = new Command[NUM_COMMANDS];
        undoStack = new Stack<Command>();
        redoStack = new Stack<Command>();

        Command noCommand = new NoCommand();
        for (int i = 0; i < NUM_COMMANDS; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) throws CloneNotSupportedException{
        Command c = onCommands[slot];
        c.executeWithLog();
        Command clone = (Command)c.clone();
        undoStack.push(clone);
    }

    public void offButtonWasPushed(int slot) throws CloneNotSupportedException{
        Command c = offCommands[slot];
        c.executeWithLog();
        undoStack.push((Command)c.clone());
    }
    
    public void undoButtonWasPushed()throws CloneNotSupportedException{
        Command c = undoStack.pop();
        c.undoWithLog();
        redoStack.push((Command)c.clone());
    }
    
    public void redoButtonWasPushed()throws CloneNotSupportedException{
        Command c = redoStack.pop();
        c.executeWithLog();
        undoStack.push((Command)c.clone());
    }

    /* for debugging / testing */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n------ Remote Control -------\n");
        for (int i = 0; i < onCommands.length; i++) {
            sb.append("[slot " + i + "] " + onCommands[i].getClass().getName()
                + "    " + offCommands[i].getClass().getName() + "\n");
        }
        return sb.toString();
    }
} 