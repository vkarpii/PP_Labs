package lab.second;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TrainCollection {
    private Train[] trainsArray;

    private int inputNumOfTrains(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input numbers of trains:");
        return scanner.nextInt();
    }

    public ArrayList<String> openFile(){
        ArrayList<String> destination = new ArrayList<>();
        String temp;
        try{
            BufferedReader buf = new BufferedReader(new FileReader(new File("data.txt")));
            while((temp = buf.readLine())!= null){
                destination.add(temp);
            }
            buf.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return destination;
    }
    private Train createTrain(ArrayList<String> destination){
        Random rand = new Random();
        int trainNum = Math.abs(rand.nextInt());
        String randDestination = destination.get(rand.nextInt(destination.size()));
        int shipTime = rand.nextInt(24);
        int common = rand.nextInt(120);
        int comp = rand.nextInt(100);
        int plats = rand.nextInt(80);
        int lux = rand.nextInt(50);
        return new Train(trainNum,randDestination,shipTime,common,comp,plats,lux);
    }

    public void createArray(){
        int numOfTrain  = inputNumOfTrains();
        ArrayList<String> destination = openFile();
        trainsArray = new Train[numOfTrain];
        for(int i = 0;i < numOfTrain; i++){
            trainsArray[i] = createTrain(destination);
        }
    }

    public void printListOfTrain(){
        System.out.println("Train List:");
        for(Train obj: trainsArray){
            System.out.println(obj);
        }
    }

    public ArrayList<Train> listCurrentDestination(String destination) {
        ArrayList<Train> trains = new ArrayList<>();
        for (Train obj : trainsArray) {
            if (obj.getDestination().equals(destination)) {
                trains.add(obj);
            }
        }
        return trains;
    }
    public ArrayList<Train> listCurrentDestinationAndTime(String destination, int time){
        ArrayList<Train> trains = new ArrayList<>();
        for(Train obj: trainsArray){
            if((obj.getDestination().equals(destination)) && (obj.getShipTime())>time){
                trains.add(obj);
            }
        }
        return trains;
    }

    public ArrayList<Train> listCurrentDestinationAndComon(String destination){
        ArrayList<Train> trains = new ArrayList<>();
        for (Train obj: trainsArray){
            if ((obj.getDestination().equals(destination)) && (obj.getCommon())>0 ){
                trains.add(obj);
            }
        }
        return trains;
    }
}
