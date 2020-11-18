package lab.first;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Парні/непарні значення
 */
public class Collection {
    /**
     * num - масив зі всіма значеннями з діапазону
     * par - масив парних значень
     * nepar - масив непарних значень
     * k_l,k_p - ліва і права границя діапазону відповідно
     * kst_p,kst_n - кількість значень в парному і непарному масиві
     */
    private static ArrayList<Integer> num;
    private static ArrayList<Integer> par,nepar;
    private static int kst_p,kst_n;
    private static int k_l,k_p;

    /**
     * Утворення масиву значень
     * @param KST кількість значень в масиві
     */
    public void CreateArr(int KST){
        par = new ArrayList<>();
        nepar = new ArrayList<>();
        for(int i=0;i!=KST;i++) {
            num.add(k_l+i);
        }
        for(int i=0;i!=KST;i++){
            if(num.get(i) % 2 == 0) kst_p++;
            else
                kst_n++;
        }
        parity();
    }

    /**
     * @return найбільше непарне число з масиву
     */
    public int MaxNepar(){
        return nepar.get(nepar.size()-1);
    }

    /**
     * @return найбільше парне число
     */
    public int MaxPar(){
        return par.get(par.size()-1);
    }

    /**
     * Введення значень
     * @return кількість значень в масиві який буде утворений
     */
    public int inputData(){
        num = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть діапазон чисел(н-д 1 - 12):\n=>");
        k_l = scanner.nextInt();
        k_p = scanner.nextInt();
        while(k_l>k_p){
            System.out.println("EROR!");
            System.out.print("Введіть діапазон чисел(н-д 1 - 12):\n=>");
            k_l = scanner.nextInt();
            k_p = scanner.nextInt();
        }
        int KST =k_p - k_l+1;
        return KST;
    }

    /**
     * @return непарний масив
     */
    public ArrayList<Integer> getNepar(){
        return nepar;
    }

    /**
     * @return парний масив
     */
    public ArrayList<Integer> getPar(){
        return par;
    }

    /**
     * Перевірка на парність
     */
    public void parity(){
        kst_n=0;kst_p=0;
        for(int i=0;i!=num.size();i++){
            if(num.get(i) % 2 == 0) {
                par.add(num.get(i));
                kst_p++;
            }
            else{
                nepar.add(num.get(i));
                kst_n++;
            }
        }
    }

    /**
     * Пшук суми в масиві
     * @param array масив в якому будуть додаватись всі значення
     * @return суму значень
     */
    public int suma(ArrayList<Integer> array){
        int sum=0;
        for(int i=0;i<array.size();i++)
            sum+=array.get(i);
        return sum;
    }
}
