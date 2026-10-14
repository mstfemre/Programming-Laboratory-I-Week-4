package week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Week4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();

        int courseNum;
        do {
            System.out.println("How many courses? Enter at least 3:");
            courseNum = input.nextInt();
            input.nextLine();
        } while (courseNum < 3);

        for (int i = 0; i < courseNum; i++) {
            System.out.println("Enter course name:");
            String courseName = input.nextLine().trim();

            int capacity;
            do {
                System.out.println("Enter capacity (greater than 0):");
                capacity = input.nextInt();
                input.nextLine();
            } while (capacity <= 0);

            courses.add(new Course(courseName, capacity));
        }

        System.out.println("Available courses:");
        for (Course course : courses) {
            course.displayCourseInfo();
        }

        String answer;
        do {
            System.out.println("Enter the exact course name to register:");
            String wantingCourse = input.nextLine().trim();

            Course selectedCourse = null;
            for (Course course : courses) {
                if (course.courseName.equals(wantingCourse)) {
                    selectedCourse = course;
                    break;
                }
            }

            if (selectedCourse == null) {
                System.out.println("No course found with that name.");
            } else {
                System.out.println("Enter student name:");
                String name = input.nextLine().trim();

                System.out.println("Enter student ID:");
                String studentID = input.nextLine().trim();

                Student student = new Student(studentID, name);
                selectedCourse.registerStudent(student);
            }

            System.out.println("Register another student? (e/h):");
            answer = input.nextLine().trim();
        } while (answer.equalsIgnoreCase("e"));

        System.out.println("All courses and enrolled students:");
        for (Course course : courses) {
            course.displayCourseInfo();
        }

        input.close();
    }
}
