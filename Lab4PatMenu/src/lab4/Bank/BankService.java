package lab4.Bank;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class BankService {
    private ArrayList<Bank> banks;
    double credit;

    public void initBanks(){
        banks = new ArrayList<Bank>();
    }
    public void getCredit(int select,int num){
        Scanner scanner = new Scanner(System.in);
        banks.get(num).printAgree();
        System.out.println("Введіть суму на яку ви хочете взяти кредит:");
        credit = scanner.nextDouble();
        Date date = new Date();
        System.out.println("Кредит взято :\n"+date);
        banks.get(num).giveAttemp(select);
        banks.get(num).sendMoney(select,credit);
    }
    public void getAttemps(int select,int num){
        banks.get(num).giveAttemp(select);
    }
    public int check(int select,int num){
        return banks.get(num).attemps(select);
    }
    public int Login(int choice,String number,String PIN){
        return banks.get(choice).logginer(number,PIN);
    }
    public void topUpAccount(int select,int num){
        banks.get(num).giveMoney(select);
    }
    public void deleteAcc(int select,int num){
        banks.get(num).delete(select);
    }
    public void printAccount(int select,int num){
        banks.get(num).printAcc(select);
    }
    public void sendMoney(int select,int num){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть номер рахунку на який потрібно перевести гроші:");
        String send = scanner.nextLine();
        int kst=0;
        for (int i = 0; i != banks.size();i++){
            for (int j=0;j != banks.get(i).getSize();j++)
            if(banks.get(i).getNumber(j).equals(send)){
                System.out.println("Введіть суму:");
                double money = scanner.nextDouble();
                banks.get(num).takeMoney(select,money);
                banks.get(i).sendMoney(j,money);
                kst++;
                break;
            }
        }
        if(kst == 0)
            System.out.println("Не знайдено банку з такою назвою!");

    }
    public void initAccount() throws IOException {
        String pack = "D:\\Labs\\ПП\\Lab4PatMenu\\src\\lab4\\Database\\Accounts\\";
        for(int i = 0;i<banks.size();i++){
            File file = new File(pack+banks.get(i).getBankName()+".txt");
            if (file.exists()){
                try {
                    FileReader fileReader = new FileReader(new File(pack+banks.get(i).getBankName()+".txt"));
                    BufferedReader reader = new BufferedReader(fileReader);
                    String line = reader.readLine();
                    while (line != null){
                        Account newAccount = new Account();
                        newAccount.setUserName(line);
                        newAccount.setMoney(Double.parseDouble(reader.readLine()));
                        newAccount.setNumber(reader.readLine());
                        newAccount.setPIN(reader.readLine());
                        banks.get(i).addAcc(newAccount);
                        line = reader.readLine();
                    }
                } catch (FileNotFoundException e) {
                } catch (IOException e) {
                }
            }
        }

    }
    public void createAccount(int choice) throws IOException {
        System.out.println("Створення РАХУНКУ в Банку "+banks.get(choice).getBankName());
        banks.get(choice).createAcc();
    }

    public void sortByABC(){
        Collections.sort(banks,Bank.BankNameComparator);
    }
    public void sortByInterest(){
        Collections.sort(banks,Bank.BankInterestComparator);
    }
    public void seachByBankName(String bankName){
        int kst=0;
        for (int i = 0; i != banks.size();i++){
            if(banks.get(i).getBankName().equals(bankName)){
                System.out.println(banks.get(i));
                kst++;
            }
        }
        if(kst == 0)
            System.out.println("Не знайдено банку з такою назвою!");

    }

    public void printBanks(){
        System.out.println("Кількість доступних банків : "+banks.size());
        for (int i = 0;i<banks.size();i++){
            System.out.println("№"+(i+1)+" "+banks.get(i));
        }
    }

    public void returnMoney(int select,int num){
        double money = credit + credit*(banks.get(num).getInterest()/100);
        System.out.println("З вашого рахунку знято : " + credit +" + "+banks.get(num).getInterest() + "%" +
                "\n Загальна сума :" + money);
        banks.get(num).takeMoney(select,money);
        banks.get(num).setAttemps(select);
    }

    public void createBanks() throws IOException {
        try {
            FileReader fileReader = new FileReader("D:\\Labs\\ПП\\Lab4PatMenu\\src\\lab4\\Database\\banks.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int ID = 1000001;
            String line = bufferedReader.readLine();
            String line2 = bufferedReader.readLine();
            while (line != null) {
                Bank bank = new Bank(line,ID,Double.parseDouble(line2));
                banks.add(bank);
                ID++;
                line = bufferedReader.readLine();
                line2 = bufferedReader.readLine();
            }

            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        initAccount();
    }
}
