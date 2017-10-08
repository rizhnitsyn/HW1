package HW3.Lists;

import java.util.Comparator;

public class StudentByAgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student first, Student second) {
        return new Integer(first.getAge()).compareTo(second.getAge());
    }
}
