package lab.droid;

public class Defender extends Droid{

    public Defender(String name, int health, int damage, int regeneration) {
        super(name, health, damage, regeneration);
    }

    @Override
    public double getHealth() {
        return super.getHealth()*1.1;
    }
}
