package HW3.Lists;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private double avgMark;

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getAvgMark() {
        return avgMark;
    }

    public Student(String firstName, String lastName, int age, double avgMark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.avgMark = avgMark;

    }
}
