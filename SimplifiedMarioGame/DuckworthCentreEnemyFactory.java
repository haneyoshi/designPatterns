
public class DuckworthCentreEnemyFactory implements EnemyFactory
{
    
    public PiranhaPlantSpecies createPiranhaPlant() {
        return new PiranhaPlant();
    }

    public GoombaSpecies createGoomba() {
        return new Goomba();
    }

    public KoopaTroopaSpecies createKoopaTroopa() {
        return new KoopaTroopa();
    }
}
