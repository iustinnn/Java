package org.example;

import java.util.Scanner;
import java.util.*;
import java.io.Serializable;
import java.io.*;
import java.nio.*;

public class Document implements Serializable {
    private String id;
    private String title;
    private String location; //file name or Web page

    public Document(String id, String title, String location) {
        this.id = id;
        this.title = title;
        this.location = location;
    }
public Document(){
}

    private Map<String, Object> tags = new HashMap<>();

    //…
    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

    public String getId() {
        return this.id;
    }
//…
}
