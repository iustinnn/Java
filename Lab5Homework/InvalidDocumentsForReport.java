package org.example;

public class InvalidDocumentsForReport extends RuntimeException{
   public InvalidDocumentsForReport()
    {
        super("Nu avem destule documente pentru a crea raportul HTML.Adaugati documente si rulati iar.");
    }

        }
