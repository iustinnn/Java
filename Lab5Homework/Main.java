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
        ShowReport showReport=new ShowReport();
        Catalog catalog = new Catalog("MyDocuments");
        var book = new Document("article1", "script", "C:\\Users\\pc\\Documents\\script.docx");
        add.AddCommand(catalog, book);
        var book1 = new Document("slides1", "laborator", "https://profs.info.uaic.ro/~acf/java/labs/slides/lab_05.pdf");
       add.AddCommand(catalog, book1);
        saveCommand.save(catalog, "C:\\Users\\pc\\Desktop\\Materii\\catalogNou.json");//salveaza la path obiectele din catalog in json
        lista.ListCommand(catalog);//afiseaza in console id-urile si titlurile documentelor din catalog.
        viewCommand.view(catalog,book1); //va deschide fereastra web pentru lab5
        viewCommand.view(catalog,book); //va deschide un articol din PC-ul meu
showReport.show(catalog);

    }

    private void testLoadView() throws InvalidCatalogException, IOException {
        try {
            LoadCommand loadCommand = new LoadCommand();
            Catalog catalog = loadCommand.load("C:\\Users\\pc\\Documents\\fisierOutput.json");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }



}

