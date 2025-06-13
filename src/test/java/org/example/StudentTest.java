package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StudentTest {

    @Test
    public void StudentConstructorTest() {
        Student student = new Student(21, 9.2, 0.5, "Fernanda");
        assertNotNull(student);
    }

    @Test
    public void getCLusterByNewStudent() {
        Student student1 = new Student(25, 7.5, 2.0, "Gabriel");
        Student student2 = new Student(27, 8.0, 1.5, "Helena");
        Student student3 = new Student(60, 9.1, 3.0, "Igor");
        Student student4 = new Student(62, 8.8, 3.5, "Julia");

        List<Student> studentsCluster1 = List.of(student1, student2);
        List<Student> studentsCluster2 = List.of(student3, student4);

        Cluster cluster1 = new Cluster(student1, studentsCluster1);
        Cluster cluster2 = new Cluster(student3, studentsCluster2);

        List<Cluster> clusters = List.of(cluster1, cluster2);

        Student newStudent = new Student(28, 7.8, 1.8, "Novo Aluno");
        final Cluster cluster = newStudent.calculateMinDistanceEuclidienne(clusters);

        assertEquals(cluster, cluster1);
    }

    @Test
    public void accumulateTest() {
        Student student1 = new Student(20, 8.0, 3.5, "Lucas");
        Student student2 = new Student(22, 7.5, 4.0, "Mariana");

        final Student studentTotal = student1.accumule(student2);

        assertEquals(42, studentTotal.getAge());
        assertEquals(15.5, studentTotal.getAverage());
        assertEquals(7.5, studentTotal.getAbscense(), 0.01);
    }

    @Test
    public void throwExceptionWhenDivisorMenor1() {
        Student student1 = new Student(30, 9.0, 1.0, "Nair");

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> student1.divide(0),
                "Divisor deve ser maior que 0");
    }

    @Test
    public void divisor() {
        Student student1 = new Student(50, 18.0, 4.5, "Otavio");

        student1.divide(2);

        assertEquals(25, student1.getAge());
        assertEquals(9.0, student1.getAverage());
        assertEquals(2.25, student1.getAbscense(), 0.01);
    }
}