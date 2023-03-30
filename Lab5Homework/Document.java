package org.example;

import java.util.Scanner;
import java.util.*;
import java.io.Serializable;
import java.io.*;
import java.nio.*;

public class Document implements Serializable {
    public String id;
    public String title;
    public String location; //file name or Web page
    private Map<String, Object> tags = new HashMap<>();

    public Document(String id, String title, String location) {
        this.id = id;
        this.title = title;
        this.location = location;
    }

    public Document() {
    }

    public String getLocation() {
        return location;
    }

    //…
    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", tags=" + tags +
                '}';
    }

    public String getId() {
        return this.id;
    }
//…
}