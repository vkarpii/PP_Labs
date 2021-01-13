package lab.droid;
import java.util.Scanner;

import java.util.Scanner;

public class Main {
    private static Droid[] droids ;
    private int kst;
    private final Droid[] firstTeam = new Droid[2];
    private final Droid[] secondTeam = new Droid[2];

    public static void main(String[] args) {
        droids = new Droid[15];
        Main start = new Main();
        System.out.println("\tВітаю в грі!");
        start.Menu();
    }
    private void printDroids(){
        for (int i = 0; i < kst; i++) {
            System.out.println("№ "+(i+1)+" "+droids[i]);
        }
    }
    private void Menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\tМеню:");
        System.out.println("1 - Створити робота");
        System.out.println("2 - Подивитись наявних роботів");
        System.out.println("3 - Битва 1 на 1");
        System.out.println("4 - Битва 2 на 2");
        System.out.println("5 - Вихід");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                newDroid();
                Menu();
                break;
            case 2:
                if(kst == 0){
                    System.out.println("Ви ще не створили роботів!");
                    Menu();
                }
                printDroids();
                Menu();
                break;
            case 3:
                if(kst == 0){
                    System.out.println("Ви ще не створили роботів!");
                    Menu();
                }
                printDroids();
                System.out.println("Виберіть 1-го дроїда: ");
                int id = scanner.nextInt();
                System.out.println("Виберіть 2-го дроїда:: ");
                int id2 = scanner.nextInt();
                double h1 = droids[id-1].getHealth();
                double h2 = droids[id2-1].getHealth();
                Battle1vs1 battle1vs1 = new Battle1vs1(droids[id - 1], droids[id2 - 1]);
                Droid winner = battle1vs1.startFight();
                System.out.println("Переможець " + winner.getName());
                droids[id - 1].setHealth(h1);
                droids[id2 - 1].setHealth(h2);
                Menu();
                break;
            case 4:
                if(kst == 0){
                    System.out.println("Ви ще не створили роботів!");
                    Menu();
                }
                printDroids();
                System.out.println("Виберіть тімейтів: ");

                int firstTeammate = scanner.nextInt();
                int secondTeammate = scanner.nextInt();
                firstTeam[0] = droids[firstTeammate - 1];
                firstTeam[1] = droids[secondTeammate - 1];
                double f1 = droids[firstTeammate - 1].getHealth();
                double f2 = droids[secondTeammate - 1].getHealth();
                System.out.println("Виберіть ворогів: ");

                int enemy1 = scanner.nextInt();
                int enemy2 = scanner.nextInt();
                secondTeam[0] = droids[enemy1 - 1];
                secondTeam[1] = droids[enemy2 - 1];
                System.out.println("\t\t\tКоманди:");
                System.out.println("Перша команда:");
                double hel1 = droids[enemy1-1].getHealth();
                double hel2 = droids[enemy2 - 1].getHealth();
                for (int i = 0; i < 2; i++) {
                    System.out.println(firstTeam[i]);

                }
                System.out.println("\nДруга команда:");
                for (int i = 0; i < 2; i++) {
                    System.out.println(secondTeam[i]);

                }
                BattleTeamVsTeam battleTeamVsTeam = new BattleTeamVsTeam(firstTeam, secondTeam);
                int teamWinner = battleTeamVsTeam.startFight();
                if(teamWinner==1)
                    System.out.println("\n\t\tПереможці:\n\t " + firstTeam[0] + "\n\t і\n\t " + firstTeam[1]);
                if(teamWinner==2)
                    System.out.println("\n\t\tПереможці:\n\t " + firstTeam[0] + "\n\t і\n\t " + firstTeam[1]);
                droids[enemy1 - 1].setHealth(hel1);
                droids[enemy2 - 1].setHealth(hel2);
                droids[secondTeammate - 1].setHealth(f2);
                droids[firstTeammate - 1].setHealth(f1);
                Menu();
                break;
            case 5:
                System.out.println("Завершення програми!");
                break;
            default:
                System.out.println("Ви ввели неправильне значення!");
        }


    }
    private void newDroid(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Виберіть клас робота:\n1 - DAMAGER(+5% damage)\n2 - DEFENDER(+10% defence)");
        int choice = scanner.nextInt();
        if(choice !=1 && choice != 2){
            System.out.println("Створіть робота знову!");
            newDroid();
        }
        scanner.nextLine();
        System.out.print("Ім'я:");
        String name = scanner.nextLine();
        System.out.print("Кількість здоров'я:");
        int health = scanner.nextInt();
        System.out.print("Кількість пошкодження:");
        int damage = scanner.nextInt();

        if (choice == 1){
            droids[kst] = new Damager(name,health,0,0);
        }
        if(choice == 2){
            droids[kst] = new Defender(name,health,0,0);
        }
        System.out.print("Виберіть зброю :\n 1-Пістолет\n 2-Меч\n 3-Гвинтівка\n 4-Регенерація\n");
        int weapon = scanner.nextInt();
        switch (weapon) {
            case 1:
                damage+=15;
                break;
            case 2:
                damage+=10;
                break;
            case 3:
                damage+=20;
                break;
            case 4:
                droids[kst].setRegeneration(1);
                break;
            default:
                System.out.println("Ваш дроїд без зброї!");
        }
        droids[kst].setDamage(damage);
        kst++;
    }
}

