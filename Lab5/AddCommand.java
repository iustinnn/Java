package org.example;

public class AddCommand implements Comanda {
    public AddCommand() {

    }

    public AddCommand(Catalog catalog, Document document) {
        catalog.docs.add(document);
    }

    public void AddCommand(Catalog catalog, Document document) {
        catalog.docs.add(document);
    }
}
