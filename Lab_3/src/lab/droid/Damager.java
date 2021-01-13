package lab.droid;

public class Damager extends  Droid{

    public Damager(String name, int health, int damage, int regeneration) {
        super(name, health, damage, regeneration);
    }

    @Override
    public double getDamage() {
        return super.getDamage()*1.05;
    }
}
