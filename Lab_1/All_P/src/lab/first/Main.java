package lab.first;

import java.util.Scanner;

/**
 * @author Vitaly Karpii
 */
public class Main {

    /**
     * Глобальні змінні
     */
    private static int num[];
    private static int KST;
    private static int k_l,k_p;
    private static int kst_p,kst_n;
    private static int par[],nepar[];
    private static int fibonachi;
    private static int fibonachi_arr[];

    public static void main(String[] args) {
        /**
         * 1 пункт завдання
         */
        line(1);
        System.out.println("Hello World!");
        System.out.println("First Java Program!");
        /**
         * 2 пункт завдання
         */
        line(2);
        Example ex = new Example();
        System.out.println(ex.getA());
        System.out.println(ex.getB());
        /**
         * 3 пункт завдання
         */
        line(3);
        final int KST_M = 3;
        Scanner scanner = new Scanner(System.in);
        double arr[] = new double[KST_M];
        System.out.println("Enter 3 values:");
        for(int i=0; i!=KST_M ;i++) {
            arr[i] = scanner.nextDouble();
            System.out.println(arr[i]);
        }
        /**
         * 4 пункт завдання
         */
        line(4);
        System.out.print("Введіть діапазон чисел(н-д 1 - 12):\n=>");
        k_l = scanner.nextInt();
        k_p = scanner.nextInt();
        KST = k_p - k_l+1;
        num= new int [KST];
        parity();
        System.out.print("Непарні числа з введеного вами масиву:");
        for(int i=0;i!=kst_n;i++)
            System.out.print(nepar[i]+" ");
        System.out.print("\nПарні числа з введеного вами масиву:");
        for(int i=0;i!=kst_p;i++)
            System.out.print(par[i]+" ");
        System.out.print("\nСума непарних => " + suma(nepar)+".");
        System.out.print("\nСума парних => " + suma(par)+".");
        System.out.print("\nНайбільше непарне число - " + nepar[kst_n-1]);
        System.out.print("\nНайбільше парне число - " + par[kst_p-1]);
        System.out.println("\nСкільки цифр ряду фібоначі вивести на екран?");
        fibonachi = scanner.nextInt();
        fibonachi_arr = new int[fibonachi];
        double per = fibonachi();
        System.out.print("Ряд Фібоначі: ");
        for (int i=0;i<fibonachi;i++){
            System.out.print(fibonachi_arr[i]+" ");
            if(i % 10 == 0) System.out.println("");
        }
        System.out.print("\nВ цьому ряді "+per+"% парних і "+(100-per)+"% непарних.");
    }

    /**
     * Пошук суми всіх значень масиву
     * @param array масив
     * @return суму всіх значень масиву
     */
    private static int suma(int[] array){
        int sum=0;
        for(int i=0;i<array.length;i++)
            sum+=array[i];
        return sum;
    }

    /**
     * Вивід лінії для розділення завдань
     * @param item номер пункту
     */
    private static void line(int item){
        for (int i = 0;i<24;i++){
            if (i==12)
                System.out.print(item+" ITEM");
            System.out.print("-");
        }
        System.out.print("\n");
    }

    /**
     * Парність
     * Утворення 2 масивів, з парними значеннями і не парними
     */
    private static void parity(){
        for(int i=0;i!=KST;i++) {
            num[i] = k_l+i;
        }
        for(int i=0;i!=KST;i++){
            if(num[i] % 2 == 0) kst_p++;
            else
                kst_n++;
        }
        nepar = new int[kst_n];
        par = new int[kst_p];
        kst_n=0;kst_p=0;
        for(int i=0;i!=KST;i++){
            if(num[i] % 2 == 0) {
                par[kst_p] = num[i];
                kst_p++;
            }
            else{
                nepar[kst_n] = num[i];
                kst_n++;
            }
        }
    }

    /**
     * Утворення ряду фібоначі
     * @return відсоток парних чисел у даному ряді
     */
    private static double fibonachi(){
        int pop = nepar[kst_n-1],mid = par[kst_p-1],next;
        fibonachi_arr[0] = pop;
        fibonachi_arr[1] = mid;
        for(int i=2;i!=fibonachi;i++){
            fibonachi_arr[i] = pop +mid;
            pop=mid;
            mid=fibonachi_arr[i];
        }
        double fp_kst=0;
        for(int i=0;i!=fibonachi;i++){
            if(fibonachi_arr[i] % 2 == 0) {
                fp_kst++;
            }
        }
        double per = fp_kst/fibonachi*100;
        return per;
    }
}
