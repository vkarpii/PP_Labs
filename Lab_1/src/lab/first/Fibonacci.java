package lab.first;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Ряд Фібоначі
 */
public class Fibonacci {
    private static int kst_fib;
    private static ArrayList<Integer> fibonacci;

    /**
     * Ввід кількості чисел ряду фібоначі
     */
    public void inputKstFib(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nСкільки чисел ряду фібоначі вивести на екран?");
        kst_fib = scanner.nextInt();
        fibonacci = new ArrayList<>();
    }

    /**
     * Утворення ряду фібоначі
     * @param nepar масив непарних значень
     * @param par масив парних значень
     * @return відсоток парних
     */
    public double createFibonacci(ArrayList<Integer> nepar,ArrayList<Integer> par){
        int pop = nepar.get(nepar.size()-1),mid = par.get(par.size()-1);
        fibonacci.add(pop);
        fibonacci.add(mid);
        for(int i=2;i!=kst_fib;i++){
            fibonacci.add(pop +mid);
            pop=mid;
            mid=fibonacci.get(i);
        }
        double fp_kst=0;
        for(int i=0;i!=kst_fib;i++){
            if(fibonacci.get(i) % 2 == 0) {
                fp_kst++;
            }
        }
        double per = fp_kst/kst_fib*100;
        return per;
    }

    /**
     * @return ряд фібоначі
     */
    public ArrayList<Integer> GetFobonacci(){
        return fibonacci;
    }
}
