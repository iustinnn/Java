package org.example;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

import com.github.javafaker.Faker;
import org.w3c.dom.ls.LSOutput;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Random rand = new Random();
        var students = IntStream.rangeClosed(0, 3).mapToObj(i -> new Student(faker.name().fullName())).toArray(Student[]::new);
        var projects = IntStream.rangeClosed(0, 5).mapToObj(i -> new Project(faker.app().name())).toArray(Project[]::new);
        List<Student> listOfStudents = new LinkedList<>();
        Set<Project> listOfProjects = new TreeSet<>();
        List<Project> listOfProjectsStudent0 = new ArrayList<>();
        listOfProjectsStudent0.add(projects[1]);
        listOfProjectsStudent0.add(projects[0]);
        listOfProjectsStudent0.add(projects[3]);
        listOfProjectsStudent0.add(projects[2]);
        listOfProjectsStudent0.add(projects[5]);
        List<Project> listOfProjectsStudent1 = new ArrayList<>();
        listOfProjectsStudent1.add(projects[1]);
        listOfProjectsStudent1.add(projects[2]);
        listOfProjectsStudent1.add(projects[5]);
        listOfProjectsStudent1.add(projects[3]);
        List<Project> listOfProjectsStudent2 = new ArrayList<>();
        listOfProjectsStudent2.add(projects[0]);
        listOfProjectsStudent2.add(projects[1]);
        listOfProjectsStudent2.add(projects[2]);
        listOfProjectsStudent2.add(projects[3]);
        listOfProjectsStudent2.add(projects[4]);
        listOfProjectsStudent2.add(projects[2]);
        List<Project> listOfProjectsStudent3 = new ArrayList<>();
        listOfProjectsStudent3.add(projects[1]);
        listOfProjectsStudent3.add(projects[5]);
        students[0].addProjects(listOfProjectsStudent0);
        students[1].addProjects(listOfProjectsStudent1);
        students[2].addProjects(listOfProjectsStudent2);
        students[3].addProjects(listOfProjectsStudent3);
        for (int i = 0; i < 4; i++) {
            listOfStudents.add(students[i]);
        }
        List<Student> newSortedList = listOfStudents.stream().sorted(Comparator.comparing(Student::getName)).collect(Collectors.toList());
        for (int i = 0; i < 5; i++) {
            listOfProjects.add(projects[i]);
        }
        //Using Java Stream API,
        // write a query that display all the students that have a number
        // of preferences lower than the average number of preferences.
        Arrays.stream(students)
                .filter(s -> (s.numarProiecteAdmisibile()) < listOfStudents.stream()
                        .mapToInt(Student::numarProiecteAdmisibile).average().getAsDouble())
                .forEach(s -> System.out.println(s.getName() + " " + s.numarProiecteAdmisibile()));

        //cream o noua problema ce contine lista de studenti (fiecare cu proiectele admisibile) si proiectele generale
        Problem problema = new Problem(listOfStudents, listOfProjects);
        //metoda solveProblem foloseste un algoritm greedy de asignare a proiectelor pentru studenti
        problema.solveProblem();


    }
}