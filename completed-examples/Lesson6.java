import java.util.Scanner;
import java.util.ArrayList;

// ===================================================================
// STUDENT CLASS (Clase Estudiante)
// ===================================================================

/**
 * Represents a student in the registration system.
 * This class encapsulates student information including name, age, and grade.
 * It provides validation for all attributes and methods to evaluate performance.
 *
 * @author Your Name
 * @version 1.0
 * @since 2025-11-16
 */
class Student {
    // Private attributes for encapsulation
    private String name;
    private int age;
    private double grade;

    /**
     * Constructs a new Student with the specified name, age, and grade.
     * All parameters are validated before assignment.
     *
     * @param name the full name of the student (cannot be null or empty)
     * @param age the age of the student (must be between 5 and 18)
     * @param grade the student's grade (must be between 0 and 20)
     * @throws IllegalArgumentException if name is null/empty, age is out of range, 
     *         or grade is out of range
     */
    public Student(String name, int age, double grade) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR: Name cannot be empty!");
        }

        if (age < 5 || age > 18) {
            throw new IllegalArgumentException("ERROR: Age must be between 5 and 18!");
        }

        if (grade < 0 || grade > 20) {
            throw new IllegalArgumentException("ERROR: Grade must be between 0 and 20!");
        }

        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    /**
     * Returns the name of the student.
     *
     * @return the student's name as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the age of the student.
     *
     * @return the student's age as an integer
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns the grade of the student.
     *
     * @return the student's grade as a double (0-20 scale)
     */
    public double getGrade() {
        return grade;
    }

    /**
     * Sets a new name for the student.
     *
     * @param name the new name for the student (cannot be null or empty)
     * @throws IllegalArgumentException if name is null or empty
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR: Name cannot be empty!");
        }
        this.name = name;
    }

    /**
     * Sets a new age for the student.
     *
     * @param age the new age for the student (must be between 5 and 18)
     * @throws IllegalArgumentException if age is not in the valid range
     */
    public void setAge(int age) {
        if (age < 5 || age > 18) {
            throw new IllegalArgumentException("ERROR: Age must be between 5 and 18!");
        }
        this.age = age;
    }

    /**
     * Sets a new grade for the student.
     *
     * @param grade the new grade for the student (must be between 0 and 20)
     * @throws IllegalArgumentException if grade is not in the valid range
     */
    public void setGrade(double grade) {
        if (grade < 0 || grade > 20) {
            throw new IllegalArgumentException("ERROR: Grade must be between 0 and 20!");
        }
        this.grade = grade;
    }

    /**
     * Determines if the student has passed.
     * A student passes if their grade is 10.5 or higher.
     *
     * @return true if the student has passed, false otherwise
     */
    public boolean hasPassed() {
        return grade >= 10.5;
    }

    /**
     * Determines if the student has honors status.
     * Honors are awarded to students with a grade of 16 or higher.
     *
     * @return true if the student has honors, false otherwise
     */
    public boolean hasHonors() {
        return grade >= 16;
    }

    /**
     * Calculates and returns the performance level of the student.
     * Performance levels are determined by grade ranges:
     * <ul>
     *   <li>18-20: EXCELLENT</li>
     *   <li>16-18: VERY GOOD</li>
     *   <li>14-16: GOOD</li>
     *   <li>10.5-14: SATISFACTORY</li>
     *   <li>0-10.5: NEEDS IMPROVEMENT</li>
     * </ul>
     *
     * @return a String representing the student's performance level
     */
    public String getPerformanceLevel() {
        if (grade >= 18) {
            return "EXCELLENT";
        } else if (grade >= 16) {
            return "VERY GOOD";
        } else if (grade >= 14) {
            return "GOOD";
        } else if (grade >= 10.5) {
            return "SATISFACTORY";
        } else {
            return "NEEDS IMPROVEMENT";
        }
    }

    /**
     * Displays the complete information of the student.
     * Prints name, age, grade, performance level, pass/fail status, 
     * and honors achievement if applicable.
     */
    public void showInfo() {
        System.out.println("====================================");
        System.out.println("      STUDENT INFORMATION");
        System.out.println("====================================");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age + " years old");
        System.out.println("Grade: " + grade);
        System.out.println("Performance: " + getPerformanceLevel());

        if (hasPassed()) {
            System.out.println("Status: PASSED");
        } else {
            System.out.println("Status: FAILED");
        }

        if (hasHonors()) {
            System.out.println("Achievement: WITH HONORS!");
        }

        System.out.println("====================================");
    }
}



/**
 * Main class that manages the Student Registration System.
 * Provides an interactive menu to add, view, search students and show statistics.
 * Demonstrates Object-Oriented Programming concepts and exception handling.
 *
 * @author Your Name
 * @version 1.0
 * @since 2025-11-16
 */
public class Lesson6 {

    /** ArrayList to store all registered students */
    static ArrayList<Student> students = new ArrayList<>();

    /** Scanner object for reading user input */
    static Scanner input = new Scanner(System.in);

    /**
     * Main method - entry point of the application.
     * Displays welcome message and runs the main menu loop.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

        showWelcome();

        boolean running = true;
        while (running) {
            showMenu();

            try {
                int option = input.nextInt();
                input.nextLine(); // Clear buffer

                switch (option) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        showAllStudents();
                        break;
                    case 3:
                        searchStudent();
                        break;
                    case 4:
                        showStatistics();
                        break;
                    case 5:
                        running = false;
                        System.out.println("\nThanks for using the program! Goodbye!");
                        break;
                    default:
                        System.out.println("\nInvalid option! Please choose 1-5.\n");
                }

            } catch (Exception e) {
                System.out.println("\nERROR: Please enter a valid number!\n");
                input.nextLine(); // Clear invalid input
            }
        }

        input.close();
    }

    /**
     * Displays the welcome message and program title.
     * Called once at the start of the program.
     */
    static void showWelcome() {
        System.out.println("\n====================================");
        System.out.println("  STUDENT REGISTRATION SYSTEM");
        System.out.println("  Learn Java with OOP!");
        System.out.println("====================================");
    }

    /**
     * Displays the main menu with all available options.
     * Shows 5 options: add, show all, search, statistics, and exit.
     */
    static void showMenu() {
        System.out.println("\n===== MAIN MENU =====");
        System.out.println("1. Add new student");
        System.out.println("2. Show all students");
        System.out.println("3. Search student");
        System.out.println("4. Show statistics");
        System.out.println("5. Exit");
        System.out.print("\nChoose an option: ");
    }

    /**
     * Adds a new student to the registration system.
     * Prompts the user for name, age, and grade.
     * Validates input and catches exceptions for invalid data.
     * Displays the newly created student information upon success.
     */
    static void addStudent() {
        System.out.println("\n----- ADD NEW STUDENT -----");

        try {
            System.out.print("Enter name: ");
            String name = input.nextLine();

            System.out.print("Enter age (5-18): ");
            int age = input.nextInt();

            System.out.print("Enter grade (0-20): ");
            double grade = input.nextDouble();
            input.nextLine(); // Clear buffer

            // Create new student (may throw IllegalArgumentException)
            Student newStudent = new Student(name, age, grade);
            students.add(newStudent);

            System.out.println("\nStudent added successfully!");
            newStudent.showInfo();

        } catch (IllegalArgumentException e) {
            // Catch validation errors from Student constructor
            System.out.println("\n" + e.getMessage());
        } catch (Exception e) {
            // Catch input type mismatch errors
            System.out.println("\nERROR: Invalid input. Please try again.");
            input.nextLine(); // Clear buffer
        }
    }

    /**
     * Displays all registered students in the system.
     * Shows a message if no students are registered.
     * Otherwise, prints information for each student with their index number.
     */
    static void showAllStudents() {
        System.out.println("\n----- ALL REGISTERED STUDENTS -----");

        if (students.isEmpty()) {
            System.out.println("No students registered yet.");
        } else {
            for (int i = 0; i < students.size(); i++) {
                System.out.println("\nStudent #" + (i + 1));
                students.get(i).showInfo();
            }
        }
    }

    /**
     * Searches for students by name.
     * Performs a case-insensitive partial match search.
     * Displays all students whose names contain the search term.
     * Shows a message if no matching students are found.
     */
    static void searchStudent() {
        System.out.println("\n----- SEARCH STUDENT -----");
        System.out.print("Enter name to search: ");
        String searchName = input.nextLine();

        boolean found = false;
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(searchName.toLowerCase())) {
                student.showInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    /**
     * Displays statistics about all registered students.
     * Calculates and shows:
     * <ul>
     *   <li>Total number of students</li>
     *   <li>Number of students who passed</li>
     *   <li>Number of students who failed</li>
     *   <li>Number of students with honors</li>
     *   <li>Class average grade</li>
     * </ul>
     * Shows a message if no students are registered.
     */
    static void showStatistics() {
        System.out.println("\n----- STATISTICS -----");

        if (students.isEmpty()) {
            System.out.println("No students to analyze.");
            return;
        }

        int passed = 0;
        int failed = 0;
        int honors = 0;
        double totalGrade = 0;

        // Calculate statistics
        for (Student student : students) {
            if (student.hasPassed()) {
                passed++;
            } else {
                failed++;
            }

            if (student.hasHonors()) {
                honors++;
            }

            totalGrade += student.getGrade();
        }

        double average = totalGrade / students.size();

        // Display statistics
        System.out.println("Total students: " + students.size());
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);
        System.out.println("With honors: " + honors);
        System.out.println("Class average: " + String.format("%.2f", average));
    }
}

