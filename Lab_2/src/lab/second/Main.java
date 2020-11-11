package lab.second;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static Train[] train;
    private static int kst_t;

    public static void main(String[] args) {
        train = new Train[6];
        inputData();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть пункт призначення: ");
        String napr = scanner.next();
        seachAppoint(napr);
        System.out.println("Введіть пункт призначення: ");
        napr = scanner.next();
        System.out.println("Введіть годину: ");
        int hour = scanner.nextInt();
        seachHoApp(napr,hour);
        System.out.println("Введіть пункт призначення: ");
        napr = scanner.next();
        seachWPl(napr);
    }
    private static void inputData(){
        try {
            File file = new File("data.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            int i = 0;
            while (line != null) {
                String[] data = line.split(" ");
                train[i] = new Train();
                train[i].setAppoint(data[0]);
                train[i].setHour(Integer.parseInt(data[1]));
                train[i].setMin(Integer.parseInt(data[2]));
                train[i].setNum(Integer.parseInt(data[3]));
                train[i].setComm(Integer.parseInt(data[4]));
                train[i].setComp(Integer.parseInt(data[5]));
                train[i].setPlat(Integer.parseInt(data[6]));
                train[i].setLux(Integer.parseInt(data[7]));
                line = reader.readLine();
                kst_t++;
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void seachAppoint(String napr){
        System.out.format("Місто %8s %8s %10s\n","Номер","Час","Місця");
        for(int i=0;i!=kst_t;i++){
            if (napr.equals(train[i].getAppoint()))
                train[i].printTrain();
        }
    }
    private static void seachHoApp(String napr, int hour){
        System.out.format("Місто %8s %8s %10s\n","Номер","Час","Місця");
        for (int i=0;i!=kst_t;i++){
            if (napr.equals(train[i].getAppoint()) )
                if (hour <= train[i].getHour())
                    train[i].printTrain();
        }
    }
    private static void seachWPl(String napr){
        System.out.format("Місто %8s %8s %10s\n","Номер","Час","Місця");
        for (int i=0;i!=kst_t;i++){
            if (napr.equals(train[i].getAppoint()) )
                if(train[i].getComm()>0)
                    train[i].printTrain();
        }
    }
}
