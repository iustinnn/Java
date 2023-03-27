package org.example;

import java.lang.Enum;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ViewCommand implements Comanda {
    public ViewCommand() {

    }

    public void view(Catalog catalog, Document document) {
        Desktop desk = Desktop.getDesktop();
        try {
            if (document.getLocation().substring(0, 4).equals("http")) {
                URI uri = null;
                uri = new URI(document.getLocation());
                desk.browse(uri);
            } else if (document.getLocation().substring(0, 11).equals("C:\\Windows")) {
                throw new LocationAccesDenied("Fisiere din partitia C:\\Windows sunt protejate.");
            } else {
                desk.open(new File(document.getLocation()));
            }
        } catch (URISyntaxException e) {
            System.out.println("Eroare de sintaxa");
        } catch (IllegalArgumentException e) {
            System.out.println("Path-ul nu este corect.");
        } catch (IOException e) {
            System.out.println("Eroare la deschiderea fisierului.");
        }
        catch (LocationAccesDenied e)
        {
            System.out.println("!!!Acces Denied");
        }
    }

}
