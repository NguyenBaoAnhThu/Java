import java.util.List;

public interface StudentDAO {
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(String studentId);
    Student getStudentById(String studentId);
    List<Student> getStudentByName(String name);
    List<Student> getAllStudents();
}
