package Loop;

import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for ( int i = 2 ; i < Math.sqrt(num) ; i ++   ){
            if ( num % i == 0 ){
                System.out.println(num + " Không phải số nguyên tố ");
                break;
            }
            System.out.println(num + "Là số nguyên tố ");
        }
    }
}
