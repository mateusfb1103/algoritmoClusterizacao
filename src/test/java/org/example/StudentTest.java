package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StudentTest {

    @Test
    public void StudentConstructorTest() {
        Student student = new Student(25, 8.5, 1.1);
        assertNotNull(student);
    }

    @Test
    public void getCLusterByNewStudent() {
        Student student1 = new Student(22, 7.0, 1.5);
        Student student2 = new Student(24, 7.5, 2.0);
        Student student3 = new Student(50, 9.0, 3.0);
        Student student4 = new Student(55, 9.5, 3.5);

        List<Student> studentsCluster1 = List.of(student1, student2);
        List<Student> studentsCluster2 = List.of(student3, student4);

        Cluster cluster1 = new Cluster(student1, studentsCluster1);
        Cluster cluster2 = new Cluster(student3, studentsCluster2);

        List<Cluster> clusters = List.of(cluster1, cluster2);

        Student newStudent = new Student(25, 8.0, 2.2);
        final Cluster cluster = newStudent.calculateMinDistanceEuclidienne(clusters);

        assertEquals(cluster, cluster1);
    }

    @Test
    public void accumulateTest() {
        Student student1 = new Student(30, 5.5, 2.1);
        Student student2 = new Student(25, 8.0, 3.4);

        final Student studentTotal = student1.accumule(student2);

        assertEquals(55, studentTotal.getAge());
        assertEquals(13.5, studentTotal.getAverage());
        assertEquals(5.5, studentTotal.getAbscense(), 0.01);
    }

    @Test
    public void throwExceptionWhenDivisorMenor1() {
        Student student1 = new Student(21, 7.5, 1.3);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> student1.divide(0),
                "Divisor deve ser maior que 0");
    }

    @Test
    public void divisor() {
        Student student1 = new Student(40, 10.0, 2.5);

        student1.divide(5);

        assertEquals(8, student1.getAge());
        assertEquals(2.0, student1.getAverage());
        assertEquals(0.5, student1.getAbscense(), 0.01);
    }
}