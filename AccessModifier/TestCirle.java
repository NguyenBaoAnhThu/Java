package AccessModifier;

import org.w3c.dom.ls.LSOutput;

public class TestCirle {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println(circle.getArea());
        System.out.println(circle.getRadius());
    }
}
