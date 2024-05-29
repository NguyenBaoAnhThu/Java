package AccessModifier2;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();

        student.setName("ALice");
        student.setClasses("C203");

        System.out.println("Name: " + student.getName());
        System.out.println("Class: " + student.getClasses());
    }
}
