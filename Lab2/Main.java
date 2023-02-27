package org.example;

public class Main {
    public static void main(String[] args) {
        Location locatie1 = new Location("New York", LocationType.AIRPORT, 100, 200);
        Location locatie2 = new Location("Atena", LocationType.CITY, 123, 722);
        Road drum1 = new Road(RoadType.HIGHWAY, 100, 60);
        System.out.println(locatie1.x + " " + locatie1.y + " " + locatie1.tip + " " + locatie1.name); //afisam locatie
        System.out.println(locatie1.getName());
        locatie1.setCoord(555, 666);
        locatie1.setName("Texas");
        System.out.println(locatie1.getTip());
        System.out.println(locatie1.getName());
        locatie1.setTip(LocationType.GAS_STATION);
        System.out.println(locatie2.toString());
        System.out.println("Limita drumului de tip " + drum1.getType() + " este " + drum1.getSpeedLimit());
    }
}
