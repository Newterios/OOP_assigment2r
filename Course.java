import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course implements Comparable<Course> {
    private String courseName;
    private String courseCode;
    private int credits;
    private int maxStudents;
    private List<Student> students;

    public Course(String courseName, String courseCode, int credits, int maxStudents) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credits = credits;
        this.maxStudents = maxStudents;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getCredits() {
        return credits;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public List<Student> getStudents() {
        return students;
    }

    public boolean addStudent(Student student) {
        if (students.size() < maxStudents && !students.contains(student)) {
            students.add(student);
            return true;
        }
        return false;
    }

    public boolean removeStudent(int studentId) {
        return students.removeIf(student -> student.getId() == studentId);
    }

    @Override
    public String toString() {
        return "Course: " + courseName + " (" + courseCode + "), Credits: " + credits +
                ", Max Students: " + maxStudents + ", Registered Students: " + students.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return credits == course.credits &&
                maxStudents == course.maxStudents &&
                Objects.equals(courseName, course.courseName) &&
                Objects.equals(courseCode, course.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, courseCode, credits, maxStudents);
    }

    @Override
    public int compareTo(Course other) {
        return this.courseName.compareTo(other.courseName);
    }
}