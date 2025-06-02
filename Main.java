import model.Student;
import service.StudentService;

import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService studentservice = new StudentService();
        int choice;
        do{
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Students");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by id");
            System.out.println("4. Delete Student by id");
            System.out.println("5. Exit");
            System.out.print("Enter your Choice:");
            choice=scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String Name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int Age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Course: ");
                    String Course = scanner.nextLine();

                    Student student = new Student(id, Name, Age, Course);
                    studentservice.addStudent(student);
                    System.out.println("Student added successfully!");
                    break;
                
                case 2:
                    List<Student> students = studentservice.getAllStudents();
                    if(students.isEmpty()){
                        System.out.println("No students found.");
                    }else{
                        System.out.println("\n----- Student List -----");
                        for(Student s : students){
                            System.out.println(s);
                        }
                    }
                    break;
                
                case 3:
                    System.out.print("Enter Id to Search: ");
                    String searchId = scanner.nextLine();
                    Student found = studentservice.searchStudentById(searchId);
                    if(found != null){
                        System.out.println("Student Found: " + found);
                    }else{
                        System.out.println("Student Not Found!");
                    }
                    break;

                case 4:
                System.out.print("Enter ID to delete: ");
                    String deleteId = scanner.nextLine();
                    boolean deleted = studentservice.deleteStudentById(deleteId);
                    if (deleted) {
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);
        scanner.close();
    }
}
