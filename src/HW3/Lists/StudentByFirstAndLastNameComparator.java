package HW3.Lists;

import java.util.Comparator;

public class StudentByFirstAndLastNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student firstActor, Student secondActor) {
        if (firstActor.getFirstName().compareTo(secondActor.getFirstName()) == 0) {
            return firstActor.getLastName().compareTo(secondActor.getLastName());
        }
        return firstActor.getFirstName().compareTo(secondActor.getFirstName());
    }
}
