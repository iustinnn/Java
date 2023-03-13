package org.example;

import java.util.List;

public class Project implements Comparable<Project> {
    private String name;
    public Project(String name) {
        this.name = name;
    }
    public Project(String name, List<Student> studentiProiect) {
        this.name = name;
        this.studentiProiect = studentiProiect;
    }
    private List<Student> studentiProiect;
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Project o) {
        return this.getName().compareTo(o.getName());
    }
}
