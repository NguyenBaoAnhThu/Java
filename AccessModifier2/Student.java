package AccessModifier2;

public class Student {
    private String name;
    private String className;

    public Student(){
        this.name = "John";
        this.className = "C02";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String className) {
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public String getClasses() {
        return className;
    }
}
