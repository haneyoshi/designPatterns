/*******************************************************
 * Name:        YUSHAN HUNG
 * Course:       ACS-3913
 * Student ID:  3133878
 * Assignment:  Assigment3
 ********************************************************/
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RemoteControlApp {
    private JLabel[] labels;
    RemoteControl remoteControl;

    /** Loads and sets up the remote control */
    public void loadRemote(){
        Light livingRoomLight = new Light("Living Room");
        Stereo stereo = new Stereo("Living Room");
        CeilingFan fan = new CeilingFan("Living Room");

        LightOnCommand livingRoomLightOn =
            new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff =
            new LightOffCommand(livingRoomLight);

        StereoOnWithCDCommand stereoOnWithCD =
            new StereoOnWithCDCommand(stereo);
        StereoOffCommand  stereoOff=
            new StereoOffCommand(stereo);
        SereoOnWithRadioCommand stereRadio = 
            new SereoOnWithRadioCommand(stereo);
        //StereoOnWithCDLoudCommand stereCDLoud = 
        //    new StereoOnWithCDLoudCommand(stereo);
            
        
        CeilingFanHighCommand fanInHi = 
            new CeilingFanHighCommand(fan);
        CeilingFanMediumCommand fanInMe = 
            new CeilingFanMediumCommand(fan);
        //CeilingFanLowCommand fanLow = 
        //    new CeilingFanLowCommand(fan);
        CeilingFanOffCommand fanOff = 
            new CeilingFanOffCommand(fan);
        
        //Hottub hottub = new Hottub();
        //HottubOnCommand hottubOn = 
        //    new HottubOnCommand(hottub);
        //HottubOffCommand hottubOff = 
        //    new HottubOffCommand(hottub);
        Command[] workOutCommands = new Command[3];
        workOutCommands[0] = livingRoomLightOn;
        workOutCommands[1] = stereoOnWithCD;
        workOutCommands[2] = fanInHi;
        MacroCommand workout = 
            new MacroCommand(workOutCommands);
        MacroOffCommand doneWorkOut = 
            new MacroOffCommand(workOutCommands);
        

        setRemoteCommand(0, livingRoomLightOn, livingRoomLightOff, "Living Room");
        setRemoteCommand(1, stereRadio, stereoOff, "Stereo with radio");
        setRemoteCommand(2, stereoOnWithCD, stereoOff, "Stereo with CD");
        setRemoteCommand(3, fanInHi, fanOff, "Ceiling Fan high");
        setRemoteCommand(4, fanInMe, fanOff, "Ceiling Fan medium");
        setRemoteCommand(5, workout, doneWorkOut, "Workout");
        
        

        System.out.println("\n------ Remote Control App Sim -------\n");
    }

    /** Sets the command and label text */
    private void setRemoteCommand(int slot, Command onCommand, Command offCommand,
    String description){
        remoteControl.setCommand(slot, onCommand, offCommand);
        labels[slot].setText(description);
    }

    public static void main(String[] args) throws CloneNotSupportedException{
        RemoteControlApp remoteControlApp = new RemoteControlApp();
        remoteControlApp.createAndShowGUI();
    }

    public void createAndShowGUI(){
        Configuration configuration = Configuration.getInstance();
        Logger logger = Logger.getInstance();
        final int NUM_COMMANDS = configuration.getNumberOfOptions();
        final int REMOTE_HEIGHT = configuration.getHeight();
        final int REMOTE_WIDTH = 400;

        remoteControl = new RemoteControl();

        // Create the buttons and labels
        JLabel onLabel = new JLabel("on");
        JLabel offLabel = new JLabel("off");
        JButton[] onButtons = new JButton[NUM_COMMANDS];
        JButton[] offButtons = new JButton[NUM_COMMANDS];
        labels = new JLabel[NUM_COMMANDS];
        JButton undoButton = new JButton("UNDO");
        JButton redoButton = new JButton("REDO");

        for (int i=0; i<NUM_COMMANDS; i++){
            onButtons[i] = new JButton(" ");
            offButtons[i] = new JButton(" ");
            labels[i] = new JLabel("nocommandno command");
        }

        // Set actions on the buttons using lambda expressions
        for (int i=0; i<NUM_COMMANDS; i++){
            final int I = i;
            onButtons[i].addActionListener(event ->{
                try{
                    remoteControl.onButtonWasPushed(I);
                }catch (CloneNotSupportedException cnse) {
                    cnse.printStackTrace();
            }});
            offButtons[i].addActionListener(event ->{
                try{
                    remoteControl.offButtonWasPushed(I);
                }catch (CloneNotSupportedException cnse) {
                    cnse.printStackTrace();
            }});
        }


        /** Executes when the undoButton is clicked */
        undoButton.addActionListener(event ->{
            // add UNDO code here;
            try{
                remoteControl.undoButtonWasPushed();
            }catch (CloneNotSupportedException cnse) {
                cnse.printStackTrace();
        }});    

        /** Executes when the redoButton is clicked */
        redoButton.addActionListener(event ->{
            // add REDO code here;
            try{
                remoteControl.redoButtonWasPushed();
            }catch (CloneNotSupportedException cnse) {
                cnse.printStackTrace();
        }});


        // Create and set up the window and content pane
        JFrame frame = new JFrame("Remote Control");
        frame.setSize(new Dimension(REMOTE_WIDTH,REMOTE_HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();
        JButton button;
        pane.setLayout(new GridBagLayout());
        pane.setPreferredSize(new Dimension(REMOTE_WIDTH, REMOTE_HEIGHT));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);

        //  Window listener for closing events
        frame.addWindowListener(new WindowAdapter() {
                /** Executes when the GUI is closed */
                public void windowClosing(WindowEvent e) {
                    // add closing code here
                    logger.closeLogger();
                }
            });

        // Add the buttons and labels onto the pane
        c.gridy = 0; c.gridx=1;
        pane.add(onLabel, c);
        c.gridy = 0; c.gridx=2;
        pane.add(offLabel, c);
        for (int i=0; i<NUM_COMMANDS; i++){
            c.gridy = i+1;
            c.gridx = 0;
            pane.add(labels[i], c);
            c.gridx = 1;
            pane.add(onButtons[i], c);
            c.gridx = 2;
            pane.add(offButtons[i], c);
        }
        c.gridy = NUM_COMMANDS + 1;
        c.gridx = 1;
        pane.add(undoButton, c);
        c.gridy = NUM_COMMANDS + 1;
        c.gridx=2;
        pane.add(redoButton, c);

        // Display the window
        frame.pack();
        frame.setVisible(true);

        // Load the remote
        loadRemote();
    }
}
