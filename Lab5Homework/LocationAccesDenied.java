package org.example;

public class LocationAccesDenied extends Exception {
    public LocationAccesDenied(String warning) {
        System.out.println(warning);
    }
}
