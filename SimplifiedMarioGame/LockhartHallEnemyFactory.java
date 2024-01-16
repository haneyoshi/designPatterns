
public class LockhartHallEnemyFactory implements EnemyFactory
{
    
    public PiranhaPlantSpecies createPiranhaPlant() {
        return new GiantPiranhaPlant();
    }

    public GoombaSpecies createGoomba() {
        return new GrandGoomba();
    }

    public KoopaTroopaSpecies createKoopaTroopa() {
        return new SuperKoopa();
    }
}
