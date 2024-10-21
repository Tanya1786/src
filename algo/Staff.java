
public class Staff implements Comparable<Staff> {
    String name;
    int age;

    public Staff(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ", Age: " + age;
    }

    @Override
    public int compareTo(Staff other) {
        return this.age - other.age;
    }
}
