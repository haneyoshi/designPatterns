

public class Level2 extends GameLevel
{
    private final int  piranhaplants = 8;
    private final int  koopatroopas = 15;
    private final int  goombas = 7;
    EnemyFactory enemyFactory;
    public Level2(EnemyFactory enemyFactory){
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
    }
}
