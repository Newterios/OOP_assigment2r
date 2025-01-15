import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter university name: ");
        String universityName = scanner.nextLine();
        System.out.print("Enter location: ");
        String location = scanner.nextLine();
        University university = new University(universityName, location);

        System.out.print("How many courses do you want to add? ");
        int courseCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < courseCount; i++) {
            System.out.print("Enter course name: ");
            String courseName = scanner.nextLine();
            System.out.print("Enter course code: ");
            String courseCode = scanner.nextLine();
            System.out.print("Enter credits: ");
            int credits = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter maximum number of students for this course: ");
            int maxStudents = scanner.nextInt();
            scanner.nextLine();

            if (university.isCourseCodeUnique(courseCode)) {
                university.addCourse(new Course(courseName, courseCode, credits, maxStudents));
            } else {
                System.out.println("Error: Course code already exists. Skipping this course.");
            }
        }

        System.out.print("How many professors do you want to add? ");
        int professorCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < professorCount; i++) {
            System.out.print("Enter professor name: ");
            String professorName = scanner.nextLine();
            System.out.print("Enter department: ");
            String department = scanner.nextLine();
            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            if (university.isProfessorEmailUnique(email)) {
                university.addProfessor(new Professor(professorName, department, email));
            } else {
                System.out.println("Error: Professor email already exists. Skipping this professor.");
            }
        }


        while (true) {
            System.out.println("\n=== University Management System ===");
            System.out.println("1. View all courses");
            System.out.println("2. View all professors");
            System.out.println("3. Filter courses by minimum credits");
            System.out.println("4. Search professors by department");
            System.out.println("5. Sort courses by name");
            System.out.println("6. Register a student to a course");
            System.out.println("7. Unregister a student from a course");
            System.out.println("8. View students in a course");
            System.out.println("9. Add a new course");
            System.out.println("10. Add a new professor");
            System.out.println("11. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nAll courses:");
                    for (Course course : university.getCourses()) {
                        System.out.println(course);
                    }
                    break;

                case 2:
                    System.out.println("\nAll professors:");
                    for (Professor professor : university.getProfessors()) {
                        System.out.println(professor);
                    }
                    break;

                case 3:
                    System.out.print("\nEnter minimum credits to filter courses: ");
                    int minCredits = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("\nCourses with at least " + minCredits + " credits:");
                    for (Course course : university.filterCoursesByCredits(minCredits)) {
                        System.out.println(course);
                    }
                    break;

                case 4:
                    System.out.print("\nEnter department to search professors: ");
                    String department = scanner.nextLine();
                    System.out.println("\nProfessors in department " + department + ":");
                    for (Professor professor : university.searchProfessorsByDepartment(department)) {
                        System.out.println(professor);
                    }
                    break;

                case 5:
                    System.out.println("\nCourses sorted by name:");
                    university.sortCoursesByName();
                    for (Course course : university.getCourses()) {
                        System.out.println(course);
                    }
                    break;

                case 6:
                    System.out.print("\nEnter student name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter student email: ");
                    String studentEmail = scanner.nextLine();
                    System.out.print("Enter course code to register: ");
                    String courseCode = scanner.nextLine();

                    if (university.isStudentIdUnique(studentId)) {
                        if (university.registerStudentToCourse(new Student(studentName, studentId, studentEmail), courseCode)) {
                            System.out.println("Student registered successfully.");
                        } else {
                            System.out.println("Error: Course not found, student already registered, or course is full.");
                        }
                    } else {
                        System.out.println("Error: Student ID already exists.");
                    }
                    break;

                case 7:
                    System.out.print("\nEnter student ID to unregister: ");
                    int unregisterId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter course code: ");
                    String unregisterCourseCode = scanner.nextLine();
                    if (university.unregisterStudentFromCourse(unregisterId, unregisterCourseCode)) {
                        System.out.println("Student unregistered successfully.");
                    } else {
                        System.out.println("Error: Course not found or student not registered.");
                    }
                    break;

                case 8:
                    System.out.print("\nEnter course code to view students: ");
                    String manageCourseCode = scanner.nextLine();
                    Course selectedCourse = null;

                    for (Course course : university.getCourses()) {
                        if (course.getCourseCode().equalsIgnoreCase(manageCourseCode)) {
                            selectedCourse = course;
                            break;
                        }
                    }

                    if (selectedCourse == null) {
                        System.out.println("Error: Course not found.");
                    } else {
                        System.out.println("\nStudents in course " + manageCourseCode + ":");
                        for (Student student : selectedCourse.getStudents()) {
                            System.out.println(student);
                        }
                    }
                    break;

                case 9:
                    System.out.print("Enter course name: ");
                    String newCourseName = scanner.nextLine();
                    System.out.print("Enter course code: ");
                    String newCourseCode = scanner.nextLine();
                    System.out.print("Enter credits: ");
                    int newCredits = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter maximum number of students for this course: ");
                    int newMaxStudents = scanner.nextInt();
                    scanner.nextLine();

                    if (university.isCourseCodeUnique(newCourseCode)) {
                        university.addCourse(new Course(newCourseName, newCourseCode, newCredits, newMaxStudents));
                        System.out.println("Course added successfully.");
                    } else {
                        System.out.println("Error: Course code already exists.");
                    }
                    break;

                case 10:
                    System.out.print("Enter professor name: ");
                    String newProfessorName = scanner.nextLine();
                    System.out.print("Enter department: ");
                    String newProfessorDepartment = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String newProfessorEmail = scanner.nextLine();

                    if (university.isProfessorEmailUnique(newProfessorEmail)) {
                        university.addProfessor(new Professor(newProfessorName, newProfessorDepartment, newProfessorEmail));
                        System.out.println("Professor added successfully.");
                    } else {
                        System.out.println("Error: Professor email already exists.");
                    }
                    break;

                case 11:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}