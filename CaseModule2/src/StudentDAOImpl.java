import java.util.*;
import java.io.*;

public class StudentDAOImpl implements StudentDAO {
    private List<Student> students;
    private String fileName;

    public StudentDAOImpl(String fileName) {
        this.fileName = fileName;
        this.students = readStudentsFromFile();
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
        writeStudentsToFile();
    }

    @Override
    public void updateStudent(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(student.getId())) {
                students.set(i, student);
                break;
            }
        }
        writeStudentsToFile();
    }

    @Override
    public void deleteStudent(String studentId) {
        students.removeIf(student -> student.getId().equals(studentId));
        writeStudentsToFile();
    }

    @Override
    public Student getStudentById(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> getStudentByName(String name) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                result.add(student);
            }
        }
        return result;
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    private List<Student> readStudentsFromFile() {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                students.add(Student.fromString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    private void writeStudentsToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Student student : students) {
                bw.write(student.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
