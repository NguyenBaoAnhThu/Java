package StaticMethod;

public class Student {
    // Xây dựng phương thức tĩnh Change()
    private String name;
    private int rollno;
    private static String college = "BBDIT";

    Student(int r , String n){
        rollno = r ;
        name = n ;
    }
    static void change(){
        college = "CODEGYM";
    }
    void display(){
        System.out.println(rollno + "" + name + " " + college);
    }
}
