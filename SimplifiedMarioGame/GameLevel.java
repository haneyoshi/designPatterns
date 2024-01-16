
public abstract class GameLevel
{
    protected String name;
    protected String environment;
    protected Enemy[] enemies;
    public String renderEnemies(){
        return "Rendering enemies...\n";
        }
    public String spawnEnemies(){
        StringBuilder str = new StringBuilder();
        str.append("Spawning enemies:\n");
        str.append(enemies[0].toString());
        for(int i = 1; i< enemies.length; i++){
            str.append(", "+enemies[i].toString());
        }
        return str.toString()+"\n";
    }
    public String renderEnvironment(){
        return "Rendering environment: "+ environment+"\n";
    }
    public String getName(){
        return name;
    }
    public void setName(String n){
        this.name = n;
    }
    public String getEnvironment(){
        return environment;
    }
    public void setEnvironment(String e){
        this.environment = e;
    }
    protected abstract void createEnemies();
    
    public String toString(){
        String st = "***Setting up "+getName()+ "***\n";
        st += renderEnvironment() + renderEnemies()
            +spawnEnemies();
        st += "***Completed playing "+getName()+ "***\n";
        return st;
    }
}
