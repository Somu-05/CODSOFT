package Task5;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    String code;
    String title;
    String description;
    int capacity;
    int schedule;
    int availableSlots;

    public Course(String code, String title, String description, int capacity, int schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.availableSlots = capacity;
    }
}

class Student {
    String id;
    String name;
    List<Course> registeredCourses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }
}

public class CourseRegistrationSystem {
    List<Course> courses;
    List<Student> students;
    Scanner scanner;

    public CourseRegistrationSystem() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addCourse(String code, String title, String description, int capacity, int schedule) {
        Course course = new Course(code, title, description, capacity, schedule);
        courses.add(course);
    }

    public void addStudent(String id, String name) {
        Student student = new Student(id, name);
        students.add(student);
    }

    public void displayCourses() {
        for (Course course : courses) {
            System.out.println("Code: " + course.code + ", Title: " + course.title + ", Description: " + course.description + ", Available Slots: " + course.availableSlots);
        }
    }

    public void registerCourse(String studentId, String courseCode) {
        Student student = getStudent(studentId);
        Course course = getCourse(courseCode);

        if (student != null && course != null && course.availableSlots > 0) {
            student.registeredCourses.add(course);
            course.availableSlots--;
            System.out.println("Course registered successfully.");
        } else {
            System.out.println("Course registration failed.");
        }
    }

    public void removeCourse(String studentId, String courseCode) {
        Student student = getStudent(studentId);
        Course course = getCourse(courseCode);

        if (student != null && course != null) {
            student.registeredCourses.remove(course);
            course.availableSlots++;
            System.out.println("Course removed successfully.");
        } else {
            System.out.println("Course removal failed.");
        }
    }

    private Student getStudent(String id) {
        for (Student student : students) {
            if (student.id.equals(id)) {
                return student;
            }
        }
        return null;
    }

    private Course getCourse(String code) {
        for (Course course : courses) {
            if (course.code.equals(code)) {
                return course;
            }
        }
        return null;
    }

    public void run() {
        while (true) {
            System.out.println("1. Add Course");
            System.out.println("2. Add Student");
            System.out.println("3. Display Courses");
            System.out.println("4. Register Course");
            System.out.println("5. Remove Course");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter course code: ");
                    String courseCode = scanner.next();
                    System.out.print("Enter course title: ");
                    String courseTitle = scanner.next();
                    System.out.print("Enter course description: ");
                    String courseDescription = scanner.next();
                    System.out.print("Enter course capacity: ");
                    int courseCapacity = scanner.nextInt();
                    System.out.print("Enter course schedule: ");
                    int courseSchedule = scanner.nextInt();
                    addCourse(courseCode, courseTitle, courseDescription, courseCapacity, courseSchedule);
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.next();
                    System.out.print("Enter student name: ");
                    String studentName = scanner.next();
                    addStudent(studentId, studentName);
                    break;
                case 3:
                    displayCourses();
                    break;
                case 4:
                    System.out.print("Enter student ID: ");
                    String registerStudentId = scanner.next();
                    System.out.print("Enter course code: ");
                    String registerCourseCode = scanner.next();
                    registerCourse(registerStudentId, registerCourseCode);
                    break;
                case 5:
                    System.out.print("Enter student ID: ");
                    String removeStudentId = scanner.next();
                    System.out.print("Enter course code: ");
                    String removeCourseCode = scanner.next();
                    removeCourse(removeStudentId, removeCourseCode);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        CourseRegistrationSystem system = new CourseRegistrationSystem();
        system.run();
    }
}
