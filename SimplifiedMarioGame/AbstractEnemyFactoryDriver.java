
public class AbstractEnemyFactoryDriver{
    public static void main(String[] args){
        EnemyFactory def = new DuckworthCentreEnemyFactory();
        System.out.println("Duckworth Centre Enemies");
        System.out.println(def.createPiranhaPlant());
        System.out.println(def.createGoomba());
        System.out.println(def.createKoopaTroopa());       
        
        EnemyFactory mef = new CentennialHallEnemyFactory();
        System.out.println("\nManitoba Hall Enemies");
        System.out.println(mef.createPiranhaPlant());
        System.out.println(mef.createGoomba());
        System.out.println(mef.createKoopaTroopa());  
        
        EnemyFactory lef = new LockhartHallEnemyFactory();
        System.out.println("\nLockhart Hall Enemies");
        System.out.println(lef.createPiranhaPlant());
        System.out.println(lef.createGoomba());
        System.out.println(lef.createKoopaTroopa());  
    }
}
