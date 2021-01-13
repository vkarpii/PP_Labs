package lab4;

import lab4.Bank.Bank;
import lab4.Bank.BankService;
import lab4.Command.*;
import lab4.IPException.IParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private  static Switch developer;
    private static BankService bankService;
    private static int select;
    private static int selectB;

    public static void main(String[] args) throws IParseException, IOException {
        bankService = new BankService();
        bankService.initBanks();
        bankService.createBanks();

        Menu menu = new Menu();

        developer = new Switch(
                new choiceMenuCommand(menu),
                new accountMenuCommand(menu),
                new createMenuCommand(menu)
        );
        developer.choiceMenuCommand();
        choiceMenuSet();

    }

    private static void choiceMenuSet() throws IParseException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("=>");
        int choice = inputData();
        switch (choice) {
            case 1:
                //---------------------------------------------------------------------
                System.out.println("Виберіть свій банк:");
                bankService.printBanks();
                selectB = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Введіть номер телефону:");
                String num = scanner.nextLine();
                System.out.print("PIN:\n=>");
                String PIN = scanner.nextLine();
                select = bankService.Login(selectB-1,num,PIN);

                developer.accountMenuCommand();
                //вибір введених даних
                choiceAccount();
                //---------------------------------------------------------------------
                break;
            case 2:
                //Виклик функції
                bankService.printBanks();
                developer.createMenuCommand();
                createAccount();
                break;
            case 3:
                System.out.println("Завершення програми!");
                break;
            default:
                System.err.println("Ви вибрали неправильне значення!");
                choiceMenuSet();

        }
    }
    private static void createAccount() throws IParseException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("=>");
        int choice = inputData();
        switch (choice){
            case 1:
                System.out.println("Введіть назву банку:");
                String text = scanner.nextLine();
                bankService.seachByBankName(text);
                //bankService.printBanks();
//vubir nanky
                break;
            case 2:
                System.out.println("Сортування за алфавітом!");
                bankService.sortByABC();
                bankService.printBanks();
                developer.createMenuCommand();
                createAccount();
                break;
            case 3:
                System.out.println("Сортування за відсотками!");
                bankService.sortByInterest();
                bankService.printBanks();
                developer.createMenuCommand();
                createAccount();
                break;
            case 4:
                selectBank();
                break;
            default:
                System.err.println("Ви вибрали неправильне значення!");
                choiceMenuSet();

        }

    }
    private static void selectBank() throws IParseException, IOException {
        System.out.println("Виберіть серед даного списку банк:");
        bankService.printBanks();
        System.out.print("=>");
        int choice = inputData();
        bankService.createAccount(choice-1);
        developer.choiceMenuCommand();
        choiceMenuSet();
    }

    private static void choiceAccount() throws IParseException, IOException {
        int choice = inputData();
        switch (choice){
            case 1:
                if(bankService.check(select,selectB-1)<10){
                    bankService.getAttemps(select,selectB-1);
                        if(bankService.check(select,selectB-1)==0){
                            bankService.deleteAcc(select,selectB-1);
                            System.out.println("Ваш акаунт видалений!\nКонтракт розірваний!");
                        }
                }
                bankService.sendMoney(select,selectB-1);
                //developer.choiceMenuCommand();
                bankService.printAccount(select,selectB-1);
                developer.accountMenuCommand();
                choiceAccount();
                //choiceMenuSet();
                break;
            case 2:
                if(bankService.check(select,selectB-1)<10){
                    bankService.getAttemps(select,selectB-1);
                    if(bankService.check(select,selectB-1)==0){
                        bankService.deleteAcc(select,selectB-1);
                        System.out.println("Ваш акаунт видалений!\nКонтракт розірваний!");
                    }
                }
                bankService.topUpAccount(select,selectB-1);
                //developer.choiceMenuCommand();
                bankService.printAccount(select,selectB-1);
                developer.accountMenuCommand();
                choiceAccount();
                //choiceMenuSet();
                break;
            case 3:
                if(bankService.check(select,selectB-1)<10){
                    System.out.println("Поверніть минулий кредит!");
                    developer.accountMenuCommand();
                    choiceAccount();

                }
                bankService.getCredit(select,selectB-1);
                //developer.choiceMenuCommand();
                bankService.printAccount(select,selectB-1);
                developer.accountMenuCommand();
                choiceAccount();
                //choiceMenuSet();
                break;
            case 4:
                //--------------------
                bankService.returnMoney(select,selectB-1);
                bankService.printAccount(select,selectB-1);
                developer.accountMenuCommand();
                choiceAccount();
                break;
            case 5:
                bankService.deleteAcc(select,selectB-1);
                System.out.println("Ваш акаунт видалений!\nКонтракт розірваний!");
                //System.out.println("Тут - Розірвати договір");
                developer.choiceMenuCommand();
                choiceMenuSet();
                break;
            case 6:
                developer.choiceMenuCommand();
                choiceMenuSet();
                break;
            default:
                System.err.println("Ви вибрали неправильне значення!");
                choiceAccount();
        }
    }

    private static int inputData ()throws IParseException{
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int choice = 0;
        try{
            choice = Integer.parseInt(input);
        }   catch (NumberFormatException e){
            throw new IParseException("String is incorrect");
        }
        return choice;
    }
}
