package lab.droid;

import java.util.Random;


public class BattleTeamVsTeam {
    private final Droid[] team1;
    private final Droid[] team2;
    private int firstTeamAmount;
    private int secondTeamAmount;
    private Droid assaulters;
    private Droid targets;
    private int num;

    public BattleTeamVsTeam(Droid[] team1, Droid[] team2) {
        this.team1 = team1;
        this.team2 = team2;
        firstTeamAmount = secondTeamAmount = 2;
    }

    public boolean canContinue() {
        return firstTeamAmount != 0 && secondTeamAmount != 0;
    }


    public int startFight() {
        int round = 1;

        do {
            printRoundInformation(round);
            setOpponents();

            double damage = assaulters.getDamage();
            targets.getHit(damage);
            Regeneration.regen(targets);
            if(num==1) {
                if (!targets.isAlive()) {
                    --firstTeamAmount;
                }
            }
            if(num==2) {
                if (!targets.isAlive()) {
                    --secondTeamAmount;
                }
            }
            System.out.println(assaulters.getName() + " наніс удар " + targets.getName() + " з пошкодженням = " + damage);
            round++;

            System.out.println("ХП цілі-дроїда: "+targets.getHealth());
            System.out.println("Кількість дроїдів:(1 команда):"+firstTeamAmount+"\n(2 команда):"+secondTeamAmount);

        } while (canContinue());

        return firstTeamAmount > secondTeamAmount ? 1:2;

    }

    private void setOpponents() {
        Random rand = new Random();
        int random1;
        int random2;
        do {
            random1 = rand.nextInt(2);
            random2 = rand.nextInt(2);
        }while(team1[random1].getHealth() <=0 || team2[random2].getHealth()<=0);
        for (int i = 0; i < 2; i++) {
            if ((rand.nextInt(2)) == 0) {
                num=1;
                assaulters = team1[random1];
                targets = team2[random2];

            } else {
                num=2;
                assaulters = team2[random2];
                targets = team1[random1];

            }

        }
    }

    private void printRoundInformation(int round) {
        System.out.println("_____________________");
        System.out.println("Раунд " + round);
        System.out.println("_____________________");
        System.out.println();
    }
}

