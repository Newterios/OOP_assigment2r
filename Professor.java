import java.util.Objects;

public class Professor extends Person {
    private String department;

    public Professor(String name, String department, String email) {
        super(name, email);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Professor: " + super.toString() + ", Department: " + department;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Professor that = (Professor) o;
        return Objects.equals(department, that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), department);
    }
}