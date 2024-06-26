import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAOImpl("students.csv");
        StudentManager manager = new StudentManager(studentDAO);
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("/****************************************/");
            System.out.println("1. Add student.");
            System.out.println("2. Edit student by id.");
            System.out.println("3. Delete student by id.");
            System.out.println("4. Sort student by gpa.");
            System.out.println("5. Sort student by name.");
            System.out.println("6. Search student by id");
            System.out.println("7. Search student by name");
            System.out.println("8. Show student.");
            System.out.println("0. Exit.");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter id: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter gpa: ");
                    double gpa = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    manager.addStudent(new Student(id, name, age, address, gpa));
                    break;
                case 2:
                    System.out.print("Enter id: ");
                    id = scanner.nextLine();
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter address: ");
                    address = scanner.nextLine();
                    System.out.print("Enter gpa: ");
                    gpa = scanner.nextDouble();
                    scanner.nextLine();
                    manager.editStudent(new Student(id, name, age, address, gpa));
                    break;
                case 3:
                    System.out.print("Enter id: ");
                    id = scanner.nextLine();
                    manager.deleteStudent(id);
                    break;
                case 4:
                    System.out.println("Students sorted by GPA:");
                    manager.displayStudents(manager.sortStudentsByGpa());
                    break;
                case 5:
                    System.out.println("Students sorted by name:");
                    manager.displayStudents(manager.sortStudentsByName());
                    break;
                case 6:
                    System.out.print("Enter id: ");
                    id = scanner.nextLine();
                    Student student = manager.searchStudentById(id);
                    System.out.println(student != null ? student : "Student not found.");
                    break;
                case 7:
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    manager.displayStudents(manager.searchStudentByName(name));
                    break;
                case 8:
                    System.out.println("All students:");
                    manager.displayStudents(manager.getAllStudents());
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
