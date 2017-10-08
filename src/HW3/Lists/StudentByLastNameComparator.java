package HW3.Lists;

import java.util.Comparator;

public class StudentByLastNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student firstActor, Student secondActor) {
        return firstActor.getLastName().compareTo(secondActor.getLastName());
    }
}
