import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class University {
    private String universityName;
    private String location;
    private List<Course> courses;
    private List<Professor> professors;

    public University(String universityName, String location) {
        this.universityName = universityName;
        this.location = location;
        this.courses = new ArrayList<>();
        this.professors = new ArrayList<>();
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void addProfessor(Professor professor) {
        this.professors.add(professor);
    }

    public boolean registerStudentToCourse(Student student, String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                return course.addStudent(student);
            }
        }
        return false;
    }

    public boolean unregisterStudentFromCourse(int studentId, String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                return course.removeStudent(studentId);
            }
        }
        return false;
    }
    public List<Professor> searchProfessorsByDepartment(String department) {
        return professors.stream()
                .filter(professor -> professor.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
    }
    public List<Course> filterCoursesByCredits(int minCredits) {
        return courses.stream()
                .filter(course -> course.getCredits() >= minCredits)
                .collect(Collectors.toList());
    }
    public void sortCoursesByName() {
        courses.sort(Comparator.naturalOrder());
    }
    public List<Student> getStudentsInCourse(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                return course.getStudents();
            }
        }
        return new ArrayList<>();
    }
    public boolean isCourseCodeUnique(String courseCode) {
        return courses.stream().noneMatch(course -> course.getCourseCode().equalsIgnoreCase(courseCode));
    }

    public boolean isProfessorEmailUnique(String email) {
        return professors.stream().noneMatch(professor -> professor.getEmail().equalsIgnoreCase(email));
    }

    public boolean isStudentIdUnique(int studentId) {
        return courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .noneMatch(student -> student.getId() == studentId);
    }

}