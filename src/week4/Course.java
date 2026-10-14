package week4;

import java.util.ArrayList;
import java.util.List;

public class Course {
    String courseName;
    int capacity;
    List<Student> enrolledStudents;

    public Course(String courseName, int capacity) {
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public void registerStudent(Student student) {
        if (enrolledStudents.size() >= capacity) {
            System.out.println("This course is full. Registration failed.");
            return;
        }

        for (Student s : enrolledStudents) {
            if (s.studentID.equals(student.studentID)) {
                System.out.println("This student is already registered for this course.");
                return;
            }
        }

        enrolledStudents.add(student);
        System.out.println("Registration successful.");
    }

    public void displayCourseInfo() {
        System.out.println("Course: " + courseName + ", Capacity: " + capacity
                + ", Enrolled: " + enrolledStudents.size());

        if (enrolledStudents.isEmpty()) {
            System.out.println("No students registered.");
        }

        for (Student student : enrolledStudents) {
            student.studentInfo();
        }
    }
}
