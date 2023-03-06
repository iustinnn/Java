package org.example;

public class Main {
    public static void main(String[] args) {
        City locatie1 = new City("Atena", 100, 200,10000);
        City locatie2 = new City("Atenda",1030, 200,50000);
        System.out.println("rasp e: "+ locatie1.equals(locatie2));
        Highway drum1 = new Highway("DN3",30, 5,30,12);
        Express drum2 = new Express("DN11",100, 1000,12);
        System.out.println("drumurile: "+ drum1.equals(drum2));
        Problem problem1=new Problem();
        problem1.addRoads(drum1);
        problem1.addRoads(drum1);
        problem1.addRoads(drum2);
        problem1.addLocations(locatie2);
        problem1.addLocations(locatie1);
        System.out.println(problem1.isValid());
        System.out.println(problem1.existsRoute());

    }
}
