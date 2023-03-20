package org.example;

import java.util.List;

public class Project implements Comparable<Project> {
    private String name;
    public int taken=0;
    public int getStatusProject(){
        return this.taken;
    }
    public void setStatusProjectTaken(){
        this.taken=1;
    }
    public Project(String name) {
        this.name = name;
        this.taken=0;
    }
    public Project(String name, List<Student> studentiProiect) {
        this.name = name;
        this.studentiProiect = studentiProiect;
        this.taken=0;
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
