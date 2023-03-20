package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Problem {
    //lista de studenti
    public List<Student> studs;
    //lista generala a proiectelor
    public Set<Project> projs;

    //constructorul principal, in care ne este data lista de studenti si set-ul de proiecte
    public Problem(List<Student> studs, Set<Project> projs) {
        this.studs = studs;
        this.projs = projs;
        //sortam studentii in functie de numarul de proiecte admisibile
        List<Student> newSortedList = studs.stream().sorted(Comparator.comparing(Student::numarProiecteAdmisibile)).collect(Collectors.toList());
        this.studs = newSortedList;

    }
    /*rezolvarea greedy a problemei - avem studentii sortati in functie de numarul de proiecte admisibile,
    si pentru fiecare student sortat crescator, cautam primul proiect care nu e luat si-l marcam.
    */
    public void solveProblem() {
        //un map ce va contine numele fiecarui student, si proiectul asociat acestuia
        Map<String, String> studentProiecteAsignate = new TreeMap<>();
        for (Student student : studs) {
            //lista de proiecte admisibile pentru fiecare student
            List<Project> proiecteStudent = student.getProiecteAdmisibile();
            for (Project project : proiecteStudent) {
                //daca proiectul nu este luat, il marcam si il punem in map
                if (project.getStatusProject() == 0) {
                    project.setStatusProjectTaken();
                    studentProiecteAsignate.put(student.getName(), project.getName());
                    break;
                }
            }
        }
        System.out.println(studentProiecteAsignate);
    }

}
