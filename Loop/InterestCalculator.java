package Loop;

import java.util.Scanner;

public class InterestCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Số lượng tiền cho vay : ");
        double money = sc.nextDouble();
        System.out.println("Tỉ lệ lãi suất theo thansg ");
        double rate = sc.nextDouble();
        System.out.println("Số tháng cho vay ");
        int month = sc.nextInt();
        double totalInterest = 0;
        for ( int i = 1 ; i < month ; i++){
            totalInterest += money * (rate/100)/12 * month ;
        }
        System.out.println("Lãi là " + totalInterest);
    }
}
