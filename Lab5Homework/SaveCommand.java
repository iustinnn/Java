package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SaveCommand implements Comanda {
    public SaveCommand() {

    }

    public void run(Catalog catalog, Object... args) { //primul argument este path-ul unde il vom salva
        if (args.length == 1) {
            String path = args[0].toString();
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(new File(path), catalog);
            } catch (FileNotFoundException e) {
                System.err.println("The file is missing!");
            } catch (IOException e) {
                System.out.println("Unexpected error reading the file!");
            }
        }
    }
}
