package lab4.Bank;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class Bank implements Comparable<Bank>{
    private String bankName;
    private int bankID;
    private double interest;
    private ArrayList<Account> accounts = new ArrayList<>();


    public Bank() {
    }

    public String getNumber(int select){
        return accounts.get(select).getNumber();
    }
    public int getSize(){
        return accounts.size();
    }
    public void giveAttemp(int select){
        accounts.get(select).minAttemp();
    }



    public Bank(String bankName, int bankID, double interest){
        this.bankName = bankName;
        this.bankID = bankID;
        this.interest = interest;
    }

    @Override
    public String toString(){
        return "Bank{"+
                "Назва - "+bankName+
                "\tID:"+bankID+
                "\tВідсоток : "+interest;
    }

    public void printAgree(){
        System.out.println("Банк \""+bankName+"\" Ліцензія Національного банку від 11.01.2021\n" +
                        "ID:"+bankID+
                "\nВідсоток : "+interest+"");
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public  int getBankID() {
        return bankID;
    }

    public void setBankID(int bankID) {
        this.bankID = bankID;
    }

    public double getInterest() {
        return interest;
    }
    public void setAttemps(int select){
        accounts.get(select).setAttemps(10);
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int compareTo(Bank compareBanks){
        int compareBankID = ((Bank) compareBanks).getBankID();

        return this.bankID - compareBankID;

    }
    public static Comparator<Bank> BankNameComparator
            = new Comparator<Bank>() {

    public int compare(Bank bank1, Bank bank2) {

        String bankName1 = bank1.getBankName().toUpperCase();
        String bankName2 = bank2.getBankName().toUpperCase();

        return bankName1.compareTo(bankName2);

    }
};
    public static Comparator<Bank> BankInterestComparator
            = new Comparator<Bank>() {

        public int compare(Bank bank1, Bank bank2) {

            double bankInterest1 = bank1.getInterest();
            double bankInterest2 = bank2.getInterest();

            return Double.compare(bankInterest1,bankInterest2);

        }
    };
    public void giveMoney(int select){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Сума поповнення:");
        double sum1 = scanner.nextDouble();
        sum1+=accounts.get(select).getMoney();
        accounts.get(select).setMoney(sum1);
    }
    public void delete(int select){
        accounts.remove(select);
    }
    public void takeMoney(int select,double money){
        double selectMoney = accounts.get(select).getMoney()-money;
        accounts.get(select).setMoney(selectMoney);
    }
    public void sendMoney(int select,double money){
        double sMoney = accounts.get(select).getMoney()+money;
        accounts.get(select).setMoney(sMoney);
    }
    public int logginer(String number,String PIN){
        int index = -1;
        for (int i = 0;i<accounts.size();i++){
            if(accounts.get(i).getNumber().equals(number) && accounts.get(i).getPIN().equals(PIN)){
                index = i;
            }
        }
        if(index == -1){
            System.out.println("Неправильні дані");
        } else {
            System.out.println(accounts.get(index));
        }
        return index;
    }
    public void printAcc(int select){
        System.out.println(accounts.get(select));
    }
    public int attemps(int select){
        return accounts.get(select).getAttemps();
    }
    public void addAcc(Account newAccount){
        accounts.add(newAccount);
    }
    public void createAcc() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть ваше ім'я і прізвище(через пробіл!):\n=>");
        String name = scanner.nextLine();
        System.out.print("Введіть номер телефону:\n=>");
        String ID = scanner.nextLine();
        System.out.println("Введіть свій пін код(4 цифри):\n=>");
        String pin = scanner.nextLine();
        accounts.add(new Account(name,ID,pin));
        System.out.println("Вітаємо, " + name + ", Ваш акаунт успішно створений!");
        String pack = "D:\\Labs\\ПП\\Lab4PatMenu\\src\\lab4\\Database\\Accounts\\";
        try(FileWriter fw = new FileWriter(pack+bankName+".txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(accounts.get(accounts.size()-1).getUserName());
            out.println(Double.toString(accounts.get(accounts.size()-1).getMoney()));
            out.println(accounts.get(accounts.size()-1).getNumber());
            out.println(accounts.get(accounts.size()-1).getPIN());

        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

}
