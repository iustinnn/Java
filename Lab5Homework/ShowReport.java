package org.example;

import freemarker.template.*;

import java.awt.*;
import java.net.URI;
import java.nio.file.*;
import java.io.*;
import java.nio.*;
import java.net.URISyntaxException;

import freemarker.core.*;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;


public class ShowReport implements Comanda {
    public ShowReport() {
    }

    public void run(Catalog catalog,Object ...args) {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
        try {
            cfg.setDirectoryForTemplateLoading(
                    new File(Main.class.getResource("/templates").toURI()));
        } catch (URISyntaxException e) {
            System.out.println("Eroare de sintaxa pentru URI.");
        } catch (IOException e) {
            System.out.println("Eroare de tip IO.");
        }catch (IllegalArgumentException e){
            System.out.println("Argument ilegal.");
        }
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setFallbackOnNullLoopVariable(false);
        try {
            Desktop desk = Desktop.getDesktop();
            String outputFilePath = "index.html";
            FileWriter fileWriter = new FileWriter(outputFilePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            Template template = cfg.getTemplate("mytemplate.ftl");
            Map<String, Object> data = new HashMap<>();
            try {
                if (catalog.docs.size() < 1) throw new InvalidDocumentsForReport();
                data.put("documents", catalog.docs);
                template.process(data, bufferedWriter);
                URI uri = null;
                uri = new URI("index.html");
                desk.browse(uri);
            } catch (URISyntaxException e) {
                System.out.println("Eroare la deschiderea raportului.");
            } catch (InvalidDocumentsForReport e) {
                System.out.println("Nu avem ce afisa.");
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (
                TemplateException e) {
            System.out.println("Probleme la procesarea template-ului.");
        } catch (IOException e) {
            System.out.println("Eroare de tip IO la scrierea in index.html.");
        }

    }

}
