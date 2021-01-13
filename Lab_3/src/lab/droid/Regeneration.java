package lab.droid;

public class Regeneration {

    public static void regen(Droid regenerator) {
        if (regenerator.getRegeneration() == 1) {
            regenerator.setHealth(regenerator.getHealth() + 10);

            System.out.println("Дроїд " +regenerator.getName()+" відновив ХП!");
        }
    }
}

