package pl.kurs.task4;

public class Person implements Comparable<Person>{
    private String firstName;
    private String lastName;
    private int id;

    public Person(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    @Override
    public int compareTo(Person o) {
        int result = firstName.compareTo(o.firstName);
        if (result == 0)
            result = lastName.compareTo(o.lastName);
        if (result == 0)
            result = Integer.compare(id, o.id);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }
}

