import java.util.*;

public class StudentManager {
    private StudentDAO studentDAO;

    public StudentManager(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }

    public void editStudent(Student student) {
        studentDAO.updateStudent(student);
    }

    public void deleteStudent(String studentId) {
        studentDAO.deleteStudent(studentId);
    }

    public Student searchStudentById(String studentId) {
        return studentDAO.getStudentById(studentId);
    }

    public List<Student> searchStudentByName(String name) {
        return studentDAO.getStudentByName(name);
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    public List<Student> sortStudentsByGpa() {
        List<Student> students = studentDAO.getAllStudents();
        students.sort(Comparator.comparingDouble(Student::getGpa));
        return students;
    }

    public List<Student> sortStudentsByName() {
        List<Student> students = studentDAO.getAllStudents();
        students.sort(Comparator.comparing(Student::getName));
        return students;
    }

    public void displayStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
