package OOP.Rectangle;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Width = ");
        double width = sc.nextDouble();
        System.out.println("Height = ");
        double height = sc.nextDouble();
        Rectangle rectangle = new Rectangle(width, height);
        System.out.println("Your Rectangle \n " + rectangle.Display());
        System.out.println("Perimeter of the Rectangle" + rectangle.getPermeter());
        System.out.println("Area of the Rectangle" + rectangle.getArea());
    }
}
