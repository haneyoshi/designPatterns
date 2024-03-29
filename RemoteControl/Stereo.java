/** From Head First Design Patterns, Freeman & Robson et al. */ 

public class Stereo {
    private String location;
    private Command executedComman;

    public Stereo(String location) {
        this.location = location;
        executedComman = new NoCommand();
    }

    public void on() {
        System.out.println(location + " stereo is on");
    }

    public void off() {
        System.out.println(location + " stereo is off");
    }

    public void setCD() {
        System.out.println(location + " stereo is set for CD input");
    }

    public void setDVD() {
        System.out.println(location + " stereo is set for DVD input");
    }

    public void setRadio() {
        System.out.println(location + " stereo is set for Radio");
    }

    public void setVolume(int volume) {
        // code to set the volume
        // valid range: 1-11 (after all 11 is better than 10, right?)
        System.out.println(location + " Stereo volume set to " + volume);
    }
    
    public void setExecutedComman(Command c){
        this.executedComman = c;
    }
    
    public Command getExecutedComman(){
        return this.executedComman;
    }
}
