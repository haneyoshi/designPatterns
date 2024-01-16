
/**
 * Write a description of class Level1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Level1 extends GameLevel
{
    private final int  piranhaplants = 7;
    private final int  koopatroopas = 7;
    private final int  goombas = 7;
    EnemyFactory enemyFactory;
    public Level1(EnemyFactory enemyFactory){
        super.enemies = 
            new Enemy[piranhaplants+koopatroopas+goombas];
        this.enemyFactory = enemyFactory;
        createEnemies();
    }
    protected void createEnemies(){
        int t = 0;
        while(t < piranhaplants){
            super.enemies[t]= enemyFactory.createPiranhaPlant();
            t++;
        }
        while(t < piranhaplants + koopatroopas){
            super.enemies[t]= enemyFactory.createKoopaTroopa();
            t++;
        }
        while(t < piranhaplants + koopatroopas + goombas){
            super.enemies[t]= enemyFactory.createGoomba();
            t++;
        }
    }
}
