package org.example;

import javax.swing.text.View;
import java.io.*;
import java.net.URISyntaxException;
import java.util.*;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;

import freemarker.template.*;
import freemarker.core.*;

public class Main {

    public static void main(String args[]) throws InvalidCatalogException, IOException {
        Comanda.informatii(); //afiseaza comenzile disponibile - ar trebui explicat si ce face fiecare
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        AddCommand add = new AddCommand();
        SaveCommand saveCommand = new SaveCommand();
        ListCommand lista = new ListCommand();
        ViewCommand viewCommand = new ViewCommand();
        ShowReport showReport = new ShowReport();
        Catalog catalog = new Catalog("MyDocuments");
        var book = new Document("article1", "script", "C:\\Users\\pc\\Documents\\script.docx");
        var book7 = new Document("article12", "script2", "D:\\comenzi.sql");
        var book1 = new Document("slides1", "laborator", "https://profs.info.uaic.ro/~acf/java/labs/slides/lab_05.pdf");
        add.run(catalog, book, book1, book7);
        saveCommand.run(catalog, "C:\\Users\\pc\\Desktop\\Materii\\catalogNouu.json");//salveaza la path obiectele din catalog in json
        lista.run(catalog);//afiseaza in console id-urile si titlurile documentelor din catalog.
        viewCommand.run(catalog, book1); //va deschide fereastra web pentru lab5
        viewCommand.run(catalog, book); //va deschide un articol din PC-ul meu
        showReport.run(catalog);

    }

    private void testLoadView() throws InvalidCatalogException, IOException {
        try {
            LoadCommand loadCommand = new LoadCommand();
            Catalog catalogTemporar = new Catalog();
            catalogTemporar = loadCommand.run(catalogTemporar, "C:\\Users\\pc\\Desktop\\Materii\\catalogNouu.json");
            System.out.println("Catalogul loadat tocmai a primit datele" + catalogTemporar.docs);
        } catch (InvalidCatalogException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Eroare la incarcarea catalogului.");
        }

    }


}

