package OOP.QuadraticEquation;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("a=");
        double a = sc.nextDouble();
        System.out.println("b=");
        double b = sc.nextDouble();
        System.out.println("c=");
        double c = sc.nextDouble();
        QuadraticEquation ham1 = new QuadraticEquation(a,b,c);
        System.out.println("Delta = " + ham1.getDiscriminant());
        if (ham1.getDiscriminant() > 0 ){
            System.out.println("Nghiem 1 = " + ham1.getR1());
            System.out.println("Nghiem 2 = " + ham1.getR2());
        } else if (ham1.getDiscriminant()<0) {
            System.out.println("Khong co nghiem");
        }else {
            System.out.println("Có 1 nghệm"+ ham1.getR1());
        }
    }
}
