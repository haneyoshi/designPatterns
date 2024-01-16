
public abstract class GameWorld
{
    public GameLevel playLevel(int level){
        return createLevel(level);
    }
    protected abstract GameLevel createLevel(int level);
}
