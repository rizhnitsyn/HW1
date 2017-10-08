package HW3.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentList {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Pavel","Petrov", 20, 7.6));
        studentList.add(new Student("Pavel","Gviliya", 22, 5.1));
        studentList.add(new Student("Dmitr","Osipov", 22, 8.5));
        studentList.add(new Student("Sasha","Ivanov", 18, 8.9));

        printBestStudent(studentList);
        Collections.sort(studentList, new StudentByFirstAndLastNameComparator());
        printList(studentList);
        Collections.sort(studentList, new StudentByAgeComparator());
        printList(studentList);
        Collections.sort(studentList, new StudentByMarkComparator());
        printList(studentList);
    }

    public static void printBestStudent(List<Student> studentList) {
        Student bestStudent = studentList.get(0);
        for (Student student: studentList) {
            if (bestStudent.getAvgMark() < student.getAvgMark()) {
                bestStudent = student;
            }
        }
        System.out.println("Best student: " + bestStudent.toString());
        System.out.println();
    }

    private static void printList(List<Student> list) {
        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println();
    }
}
