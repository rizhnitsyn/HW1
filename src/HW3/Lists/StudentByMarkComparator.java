package HW3.Lists;

import java.util.Comparator;

public class StudentByMarkComparator implements Comparator<Student> {
    @Override
    public int compare(Student first, Student second) {
        return new Double(first.getAvgMark()).compareTo(second.getAvgMark());
    }
}
