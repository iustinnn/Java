package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class LoadCommand implements Comanda {
    public LoadCommand() {
        System.out.println("Comanda initializata.");
    }
    public void run(Catalog catalog,Object ...args){
        System.out.println("Comanda este gresita.");

    }
    public Catalog run(Catalog catalog,String path)
            throws InvalidCatalogException, IOException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            catalog = objectMapper.readValue(
                    new File(path),
                    Catalog.class);
            if(catalog.docs.size()<1)throw new InvalidCatalogException(); //eroarea catalogului
        } catch (InvalidCatalogException e) {
            System.out.println("Catalogul este gol.");
        }
        finally {
            return catalog;
        }

    }
}
