package lab.droid;

public class Droid {
    private final String name;
    private double health;
    private double damage;
    private int regeneration;


    public int getRegeneration() {
        return regeneration;
    }

    public void regen(int regeneration) {
        this.regeneration = regeneration;
    }

    public void setRegeneration(int regeneration) {
        this.regeneration = regeneration;
    }

    public Droid(String name, double health, double damage, int regeneration) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.regeneration = regeneration;
    }


    public void setHealth(double health) {
        this.health = health;
    }


    @Override
    public String toString() {
        return "Дроїд:" +
                "Ім'я = '" + name + '\'' +
                ", ХП = " + health +
                ", Пошкодження = " + damage +
                ", Регенерація 1/0=" + regeneration;
    }

    public String getName() {
        return name;
    }


    public double getHealth() {
        return health;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void getHit(double damage) {
        health -= damage;
    }
}
