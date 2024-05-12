package IntroductionToJava;

import java.util.Scanner;

public class LeapYearCalculator {
    public static void main(String[] args) {
        System.out.println("Nhập năm banj muốn tính : ");
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        if ( year %4 == 0 ){
            if (year %100 == 0 ){
                System.out.println("Năm" + year + "Khom phải là năm nhuận");
            }else {
                System.out.println("Năm" + year + "Là năm nhuan");
            }
        } else if (year %100 == 0 ) {
            if(year %400 == 0){
                System.out.println("Năm" + year + "Là năm nhuan");
            }else {
                System.out.println("Năm" + year + "Khom phải là năm nhuận");
            }
        }
    }
}
