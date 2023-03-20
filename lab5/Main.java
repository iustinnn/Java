package org.example;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.*;
public class Main {
    public static void main(String args[]) throws InvalidCatalogException,IOException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("MyDocuments");
        var book = new Document("article1", "rezolvari","C:\\Users\\pc\\Documents\\script.docx");
        catalog.add(book);
            CatalogUtil.save(catalog, "D:\\EIGAn2Sem2\\aaa.json");

    }

    private void testLoadView() throws InvalidCatalogException,IOException {
        try {
            Catalog catalog = CatalogUtil.load("d:/research/catalog.json");
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }


    }
}
