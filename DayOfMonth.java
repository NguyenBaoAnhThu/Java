package IntroductionToJava;
import java.util.Scanner;
public class DayOfMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tháng nào muốn đếm ngày ? ");
        int month = scanner.nextInt();
        switch (month){
            case 2:
                System.out.println("Tháng 2 Có 28 hoặc 29 ngày ");
                break;
            case 1,3,5,7,8,10,12 :
                System.out.println("Tháng "+month+" Có 31 ngày ");
                break;
            case 4,6,9,11:
                System.out.println("Tháng "+month+" Có 30 ngày ");
                break;
        }
    }
}
