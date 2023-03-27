package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class LoadCommand implements Comanda {
    public LoadCommand() {
        System.out.println("Comanda initializata.");
    }

    public static Catalog load(String path)
            throws InvalidCatalogException, IOException {
        Catalog catalog=null;
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
