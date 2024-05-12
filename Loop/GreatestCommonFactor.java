package Loop;

import java.util.Scanner;

public class GreatestCommonFactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("A=");
        int A = sc.nextInt();
        System.out.println("B=");
        int B = sc.nextInt();

        // Đảm bảo A và B là số dương
        A = Math.abs(A);
        B = Math.abs(B);

        // Kiểm tra nếu A hoặc B là 0
        if (A == 0 || B == 0) {
            System.out.println("Không có UCLN");
        } else {
            while (A != B) {
                if (A > B) {
                    A = A - B;
                } else {
                    B = B - A;
                }
            }
            System.out.println("UCLN: " + A);
        }
    }
}
