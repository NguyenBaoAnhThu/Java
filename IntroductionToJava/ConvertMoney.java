package IntroductionToJava;

import java.util.Scanner;

public class ConvertMoney {
    public static void main(String[] args) {
        double usd , vnd ;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số tiền USD ");
        usd = sc.nextDouble();
        vnd = usd * 23000;
        System.out.println("Giá tiền VND là " + vnd );
    }
}
