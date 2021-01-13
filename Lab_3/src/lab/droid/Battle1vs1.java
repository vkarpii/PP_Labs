package lab.droid;

import java.util.Random;

public class Battle1vs1 {
    private final Droid firstDroid;
    private final Droid secondDroid;
    private Droid assaulter;
    private Droid target;

    public Battle1vs1(Droid firstDroid, Droid secondDroid) {
        this.firstDroid = firstDroid;
        this.secondDroid = secondDroid;
    }

    public Droid startFight() {

        int round = 1;

        do {
            printRoundInformation(round);
            setOpponents();

            double damage = assaulter.getDamage();
            target.getHit(damage);

            System.out.println(assaulter.getName() + " наніс удар " + target.getName() + " з пошкодженням = " + damage);
            round++;
            Regeneration.regen(target);
            secondDroid.regen(secondDroid.getRegeneration());

        } while (target.isAlive());

        return assaulter;
    }

    private void printRoundInformation(int round) {
        System.out.println("_____________________");
        System.out.println("Раунд " + round);
    }

    private void setOpponents() {
        if (new Random().nextBoolean()) {
            assaulter = firstDroid;
            target = secondDroid;
        } else {
            assaulter = secondDroid;
            target = firstDroid;
        }
    }
}

