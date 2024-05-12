package Loop;

import java.util.Scanner;

public class First20PrimeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng số nguyên tố mà bạn muốn in ra : ");
        int number = sc.nextInt();
        int count = 0;
        int N = 2;

        while (count < number) {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(N); i++) {
                if (N % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(N + " ");
                count++;
            }
            N++;
        }
    }
}
