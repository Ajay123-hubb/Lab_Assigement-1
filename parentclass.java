import java.util.*;

class Person {
    String name;
}

class Student extends Person {
    int rollNo;
    String course;
    double marks;
    char grade;

    Student() {}

    Student(int rollNo, String name, String course, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
        this.marks = marks;
        calculateGrade();
    }

    void calculateGrade() {
        if (marks >= 85) grade = 'A';
        else if (marks >= 70) grade = 'B';
        else if (marks >= 50) grade = 'C';
        else grade = 'D';
    }

    void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println("------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student[] students = new Student[50];
        int count = 0;
        int choice;

        while (true) {
            System.out.println("===== Student Record Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter Roll No: ");
                int r = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Name: ");
                String n = sc.nextLine();
                System.out.print("Enter Course: ");
                String c = sc.nextLine();
                System.out.print("Enter Marks: ");
                double m = sc.nextDouble();

                if (m < 0 || m > 100) {
                    System.out.println("Invalid marks. Must be between 0-100.");
                    continue;
                }

                students[count] = new Student(r, n, c, m);
                count++;
            }
            else if (choice == 2) {
                if (count == 0) {
                    System.out.println("No student records found.");
                } else {
                    System.out.println("===== All Student Records =====");
                    for (int i = 0; i < count; i++) {
                        students[i].display();
                    }
                }
            }
            else if (choice == 3) {
                System.out.println("Exiting the application. Goodbye!");
                break;
            }
            else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        sc.close();
    }
}
