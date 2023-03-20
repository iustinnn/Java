package org.example;

import java.util.List;

public class Student implements Comparable<Student> {
    private String name;
    private List<Project> proiecteAdmisibile;

    public List<Project> getProiecteAdmisibile() {
        return proiecteAdmisibile;
    }
    public Student(String name) {
        this.name = name;
    }
    public Student(String name,List<Project> proiecteAdmisibile ) {
        this.name = name;
        this.proiecteAdmisibile=proiecteAdmisibile;
    }

public void addProjects(List<Project> proiecteAdmisibile ){
    this.proiecteAdmisibile=proiecteAdmisibile;
}
    public String getName() {
        return name;
    }

    public void setProiecteAdmisibile(List<Project> proiecteAdmisibile) {
        this.proiecteAdmisibile = proiecteAdmisibile;
    }
    public int numarProiecteAdmisibile(){
        return this.proiecteAdmisibile.size();
    }

    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.getName());
    }
}
