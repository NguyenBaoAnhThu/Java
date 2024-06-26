public class Student {
    private String id;
    private String name;
    private int age;
    private String address;
    private double gpa;

    public Student(String id, String name, int age, String address, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + address + "," + gpa;
    }

    public static Student fromString(String studentString) {
        String[] values = studentString.split(",");
        return new Student(values[0], values[1], Integer.parseInt(values[2]), values[3], Double.parseDouble(values[4]));
    }
}
