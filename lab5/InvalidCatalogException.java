package org.example;

public class InvalidCatalogException  extends Exception {
    public InvalidCatalogException(Exception ex) {
        System.out.println("Catalog invalid.");
    }
}
