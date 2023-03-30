package org.example;

public interface Comanda {
    static void informatii() {
        System.out.println("Comenzile disponibile sunt AddComand,ShowReport,SaveCommand,ViewCommand si LoadCommand." + "Fiecare se creeaza cu cate un constructor, dupa care putem folosi metodele pentru a adauga \nelemente intr-un catalog" + ", pentru a accesa intr-un document html datele dintr-un catalog, pentru a salva un catalog, cat si pentru a incarca unul.");
    }

    void run(Catalog catalog, Object... args);

}
