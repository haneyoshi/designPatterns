
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
 public class Level3 extends GameLevel
{
    private final int  piranhaplants = 10;
    private final int  koopatroopas = 10;
    private final int  goombas = 10;
    EnemyFactory enemyFactory;
    public Level3(EnemyFactory enemyFactory){
        super.enemies = 
            new Enemy[piranhaplants+koopatroopas+goombas];
        this.enemyFactory = enemyFactory;
        createEnemies();
    }
    protected void createEnemies(){
        int t = 0;
        while(t < goombas){
            super.enemies[t]= enemyFactory.createGoomba();
            t++;
        }
        while(t < piranhaplants + goombas){
            super.enemies[t]= enemyFactory.createPiranhaPlant();
            t++;
        }
        while(t < piranhaplants + koopatroopas + goombas){
            super.enemies[t]= enemyFactory.createKoopaTroopa();
            t++;
        }
        List<Enemy> eList = Arrays.asList(enemies);
        Collections.shuffle(eList);
        eList.toArray(enemies);
    }
}
