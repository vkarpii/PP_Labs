package lab.second;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static TrainCollection trainCollection;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        trainCollection = new TrainCollection();
        trainCollection.createArray();
        trainCollection.printListOfTrain();
        System.out.println("--- 1 task ---");
        ArrayList<Train> trains;
        String trainDestination;
        trainDestination = inputTrainDestination();
        trains = trainCollection.listCurrentDestination(trainDestination);
        for(Train train: trains){
            System.out.println(train);
        }
        System.out.println("--- 2 task ---");
        int time;
        String destination;
        destination = inputTrainDestination();
        time = inputTime();
        trains = trainCollection.listCurrentDestinationAndTime(destination,time);
        for(Train train: trains){
            System.out.println(train);
        }
        scanner.nextLine();
        System.out.println("--- 3 task ---");
        destination = inputTrainDestination();
        trains = trainCollection.listCurrentDestinationAndComon(destination);
        for(Train train: trains){
            System.out.println(train);
        }
    }
    private static String inputTrainDestination(){
        System.out.println("Enter seach train destination : ");
        return scanner.nextLine();
    }

    private static int inputTime(){
        System.out.println("Enter time : ");
        return scanner.nextInt();
    }
}
