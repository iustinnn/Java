package org.example;

public class AddCommand implements Comanda {
    public AddCommand() {

    }


    public void run(Catalog catalog, Object... args) { //daca avem argumente de tip obiect, avem docs pe care le adaugam
        if (args.length >= 1) for (Object argument : args) {
            Document doc = (Document) argument;
            catalog.docs.add(doc);
            System.out.println(doc.getId());

        }
    }

}
