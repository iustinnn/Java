package org.example;

import java.util.ArrayList; // import the ArrayList class
import java.util.ListIterator;
/**
 * Clasa Problem
 *
 * @author Enea Iustin
 */
public class Problem {
    //vom avea doi vectori pentru locatiile si drumurile adaugate
    ArrayList<Location> locations = new ArrayList<Location>();
    ArrayList<Road> roads = new ArrayList<Road>();
    /**
     * metoda este folosita pt a adauga drumuri in instanta Problem
     * @param actualRoad drumul care trebuie adaugat
     */
    public void addRoads(Road actualRoad) {
        if (roads.size() == 0)
            roads.add(actualRoad);
        else {
            ListIterator<Road> iter = roads.listIterator();
            while (iter.hasNext()) {
                Road iterationRoad = iter.next();
                if (iterationRoad.getName().equals(actualRoad.getName())) {
                    System.out.println("Road already exists.");
                    return;
                } else iter.add(actualRoad);
            }

        }
    }
    /**
     * metoda este folosita pt a adauga locatii in instanta Problem
     * @param actualLocation locatia care trebuie adaugata
     */
    public void addLocations(Location actualLocation) {
        if (locations.size() == 0)
            locations.add(actualLocation);
        else {
            ListIterator<Location> iter = locations.listIterator();
            while (iter.hasNext()) {
                Location iterationLocation = iter.next();
                if (iterationLocation.getName().equals(actualLocation.getName())) {
                    System.out.println("Location already exists.");
                    return;
                } else iter.add(actualLocation);
            }

        }
    }
    /**
     * metoda este folosita pt a verifica daca instanta este valid, adica daca avem macar 2 locatii, iar numele si drumurile prezente in problema au denumirea corecta
     */
    public boolean isValid() {
        for (Location location : locations) {
            if (location.getName() == null)
                return false;
        }
        for (Road road : roads) {
            if (road.getName() == null)
                return false;
        }
        if (locations.size() != 2)
            return false;
        return true;
    }
    /**
     * metoda este folosita pt a verifica daca exista un drum valid pentru cele problema data(cele doua locatii)
     */
    public boolean existsRoute() {
        double x1 = locations.get(0).getX();
        double y1 = locations.get(0).getY();
        double x2 = locations.get(1).getX();
        double y2 = locations.get(1).getY();
        //verificam distanta euclidiana dintre cele 2 locatii
        double euclDistance = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        //iteram toate drumurile si verificam daca avem o distanta mai mica a unui drum decat distanta euclidiana
        for (Road road : roads) {

            if (euclDistance < road.length) {
                System.out.println("Drumul " + road.getName() + " poate fi folosit.");
                return true;
            }

        }
        System.out.println("Nu am gasit un drum disponibil.");
        return false;
    }
}
