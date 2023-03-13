package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.IntStream;
import java.util.Set;
import java.util.Comparator;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {
        var students = IntStream.rangeClosed(0, 3).mapToObj(i -> new Student("S" + i)).toArray(Student[]::new);
        var projects = IntStream.rangeClosed(0, 5).mapToObj(i -> new Project("Project" + i)).toArray(Project[]::new);
        List<Student> listOfStudents = new LinkedList<>();
        Set<Project> listOfProjects = new TreeSet<>();
        listOfStudents.add(students[0]);
        listOfStudents.add(students[1]);
        listOfStudents.add(students[2]);
        listOfStudents.add(students[3]);
        List<Student> newSortedList = listOfStudents.stream().sorted(Comparator.comparing(Student::getName)).collect(Collectors.toList());
        listOfProjects.add(projects[0]);
        listOfProjects.add(projects[1]);
        listOfProjects.add(projects[2]);
        listOfProjects.add(projects[3]);
        listOfProjects.add(projects[4]);
        for(Student student:newSortedList){
            System.out.println(student.getName());
        }
        for(Project project:projects){
            System.out.println(project.getName());
        }
    }
}