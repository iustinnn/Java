package org.example;

public class ListCommand implements Comanda {
    public ListCommand() {

    }

    public ListCommand(Catalog catalog) {
        for (Document doc : catalog.docs) {
            System.out.println(doc.getId() + " " + doc.getTitle());
        }
    }

    public void ListCommand(Catalog catalog) {
        for (Document doc : catalog.docs) {
            System.out.println(doc.getId() + " " + doc.getTitle());
        }
    }
}

