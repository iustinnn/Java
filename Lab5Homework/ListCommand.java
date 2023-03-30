package org.example;

public class ListCommand implements Comanda {
    public ListCommand() {

    }

    public void run(Catalog catalog, Object... args) {
        for (Document doc : catalog.docs) {
            System.out.println(doc.getId() + " " + doc.getTitle());
        }
    }
}

