package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ClusterTest {

    @Test
    public void testCluster() {
        Student student = new Student(22, 7.5, 1.2);
        List<Student> students = new ArrayList<>();
        Cluster cluster = new Cluster(student, students);

        Assertions.assertNotNull(cluster);
    }

    @Test
    public void recalcutecentroidTest() {
        Student newStudent1 = new Student(30, 8.0, 5.0);
        Student newStudent2 = new Student(24, 7.2, 2.5);

        List<Student> students = new ArrayList<>();
        students.add(newStudent1);

        Cluster cluster = new Cluster(newStudent1, students);

        Student inicialCentroid = cluster.recalcutecentroid(cluster.getStudents());

        cluster.addStudent(newStudent2);

        Student finalCentroid = cluster.recalcutecentroid(cluster.getStudents());

        System.out.println("centroid inicial: " + inicialCentroid);
        System.out.println("centroid final: " + finalCentroid);
        Assertions.assertNotEquals(inicialCentroid, finalCentroid);

    }

    @Test
    public void addStudentTest() {
        Student inicialStudent = new Student(18, 8.1, 0.9);
        List<Student> students = new ArrayList<>();
        students.add(inicialStudent);

        Cluster cluster = new Cluster(inicialStudent, students);

        Student student = new Student(20, 6.5, 8.0);
        cluster.addStudent(student);

        Assertions.assertEquals(2, cluster.getStudents().size());
    }

    @Test
    public void calculateDistanceEuclidienneTest() {
        Student centroid = new Student(25, 7.0, 3.0);
        Student newStudent = new Student(30, 9.5, 1.0);

        List<Student> students = new ArrayList<>();
        students.add(centroid);

        Cluster cluster = new Cluster(centroid, students);
        double distance = cluster.calculatedDistance(newStudent, cluster.getCentroid());

        System.out.println("A distância calculada é: " + distance);

        Assertions.assertEquals(35.25, distance, 0.01);
    }
}