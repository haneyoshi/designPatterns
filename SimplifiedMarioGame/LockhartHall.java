
public class LockhartHall extends GameWorld
{
    protected GameLevel createLevel(int l){
        GameLevel level = null;
        String world = "Lockhart Hall";
        EnemyFactory enemyFactory =
            new LockhartHallEnemyFactory();
            if (l == 1) {
            level = new Level1(enemyFactory);
            level.setEnvironment("classrooms, labs, fitness facility, gym");
            level.setName(world+" level 1");
        } else if (l == 2) {
            level = new Level2(enemyFactory);
            level.setEnvironment("classrooms, labs, fitness facility, gym");
            level.setName(world+" level 2");
        } else if (l ==3) {
            level = new Level3(enemyFactory);
            level.setEnvironment("classrooms, labs, fitness facility, gym");
            level.setName(world+" level 3");
        } 
        return level;
    }
}
