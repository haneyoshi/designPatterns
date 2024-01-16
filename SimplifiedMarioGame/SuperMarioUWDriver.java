
public class SuperMarioUWDriver{
    public static void main(String[] args){
        GameWorld duckworth = new DuckworthCentre();
        GameWorld centennial = new CentennialHall();
        GameWorld lockhart = new LockhartHall();
        GameLevel level = duckworth.playLevel(1);
        System.out.println(level + "\n");
        level = centennial.playLevel(2);
        System.out.println(level + "\n");
        level = lockhart.playLevel(3);
        System.out.println(level + "\n");
    }
}
