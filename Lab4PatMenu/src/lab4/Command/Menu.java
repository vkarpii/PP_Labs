package lab4.Command;

import java.util.Scanner;

public class Menu {
    //private static int choice ;

    public void choiceMenu(){
        System.out.println("Виберіть пункти меню:\n" +
                "1 - Вивести інформацію про особовий рахунок\n2 - Створити рахунок\n3 - Вихід");

    }

    public void accountMenu(){
        System.out.println("Виберіть пункти меню:\n" +
                "1 - Перевести гроші\n2 - Поповнити рахунок\n" +
                "3 - Оформити кредит\n4 - Дострокове зняття кредиту\n5 - Розірвати договір" +
                "\n6 - Повернутись в основне меню");
    }

    public void createMenu(){
        System.out.println("Виберіть пункти меню:\n" +
                "1 - Пошук за назвою\n" +
                "2 - Посортувати за алфавітом\n" +
                "3 - Посортувати за відсотками\n" +
                "4 - Вибір банку");
    }



}
