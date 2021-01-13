package lab4.Bank;

public class Account extends Bank{
    private String userName;
    private double money;
    private int attemps = 10;

    private String number;
    private String PIN;

    @Override
    public String toString() {
        return "\tДані:\n"+
                "Ім'я,прізвище : " + userName + '\n' +
                "Баланс : "  + money + "\n" +
                "Номер телефону : " + number + '\n';
    }

    public Account() {
    }
    public Account(String userName,String number,String PIN){
        this.userName = userName;
        this.number = number;
        this.PIN = PIN;
    }

    public void setAttemps(int attemps) {
        this.attemps = attemps;
    }

    public int getAttemps() {
        return attemps;
    }

    public void minAttemp(){
        attemps--;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public String getNumber() {
        return number;
    }

    public String getPIN() {
        return PIN;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
