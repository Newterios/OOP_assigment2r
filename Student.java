import java.util.Objects;

public class Student extends Person {
    private int id;

    public Student() {
    }

    public Student(String name, int id, String email) {
        super(name, email);
        this.id = id;
    }
    @Override
    public String describe() {
        return "I am a student. My name is " + getName() + " and my ID is " + id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student: " + super.toString() + ", ID: " + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}