package lab.first;

import java.util.Scanner;

public class Main {
    /**
     * Глобальні змінні
     * collection - парні/непарні
     * fibonacci - ряд Фібоначі
     */
    private static Collection collection;
    private static Scanner scanner = new Scanner(System.in);
    private static Fibonacci fibonacci;

    public static void main(String[] args) {
        collection = new Collection();
        int KST = collection.inputData();
        collection.CreateArr(KST);
        System.out.print("Непарні числа з введеного вами масиву:");
        System.out.println(collection.getNepar());
        System.out.print("\nПарні числа з введеного вами масиву:");
        System.out.println(collection.getPar());
        System.out.print("\nСума непарних => " + collection.suma(collection.getNepar())+".");
        System.out.print("\nСума парних => " + collection.suma(collection.getPar())+".");
        System.out.print("\nНайбільше непарне число - " + collection.MaxNepar());
        System.out.print("\nНайбільше парне число - " + collection.MaxPar());
        fibonacci = new Fibonacci();
        fibonacci.inputKstFib();
        double per = fibonacci.createFibonacci(collection.getNepar(),collection.getPar());
        System.out.print("Ряд Фібоначі: ");
        System.out.println(fibonacci.GetFobonacci());
        System.out.print("\nВ цьому ряді "+per+"% парних і "+(100-per)+"% непарних.");
    }
}
