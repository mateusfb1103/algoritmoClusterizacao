package org.example;
import java.util.List;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Student> students = ReadCSV.readCSV("C:/Users/vinic/IdeaProjects/clusterizacao/src/main/java/org/example/fileStudents.csv");

        Cluster cluster = new Cluster(students);
        Student novoStudent = new Student("Haniel", 22, 7.8f, 0);
        Student novoStudent2 = new Student("Carlos", 19, 8.0f, 0.6f);
        cluster.addStudent(novoStudent);
        cluster.addStudent(novoStudent2);
        cluster.printCluster();

    }
}