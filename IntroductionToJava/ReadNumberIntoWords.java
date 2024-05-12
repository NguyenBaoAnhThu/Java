package IntroductionToJava;

import java.util.Scanner;

public class ReadNumberIntoWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số cần đọc:");
        int number = sc.nextInt();

        if (number >= 0 && number < 10) {
            switch (number) {
                case 0:
                    System.out.println("Zero");
                    break;
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nine");
                    break;
                default:
                    System.out.println("Out of ability");
            }
        } else if (number >= 10 && number < 20) {
            int ones = number % 10;
            switch (ones) {
                case 0:
                    System.out.println("Ten");
                    break;
                case 1:
                    System.out.println("Eleven");
                    break;
                case 2:
                    System.out.println("Twelve");
                    break;
                case 3:
                    System.out.println("Thirteen");
                    break;
                case 4:
                    System.out.println("Fourteen");
                    break;
                case 5:
                    System.out.println("Fifteen");
                    break;
                case 6:
                    System.out.println("Sixteen");
                    break;
                case 7:
                    System.out.println("Seventeen");
                    break;
                case 8:
                    System.out.println("Eighteen");
                    break;
                case 9:
                    System.out.println("Nineteen");
                    break;
                default:
                    System.out.println("Out of ability");
            }
        } else if (number >= 20 && number < 100) {
            int tens = number / 10;
            int ones = number % 10;
            String tensString = "";
            String onesString = "";

            switch (tens) {
                case 2:
                    tensString = "Twenty";
                    break;
                case 3:
                    tensString = "Thirty";
                    break;
                case 4:
                    tensString = "Forty";
                    break;
                case 5:
                    tensString = "Fifty";
                    break;
                case 6:
                    tensString = "Sixty";
                    break;
                case 7:
                    tensString = "Seventy";
                    break;
                case 8:
                    tensString = "Eighty";
                    break;
                case 9:
                    tensString = "Ninety";
                    break;
                default:
                    System.out.println("Out of ability");
                    return; // Thêm return để thoát khỏi phương thức nếu không phải là số từ 20 đến 99
            }

            if (ones != 0) { // Kiểm tra xem số đơn vị có khác 0 không
                switch (ones) {
                    case 1:
                        onesString = "One";
                        break;
                    case 2:
                        onesString = "Two";
                        break;
                    case 3:
                        onesString = "Three";
                        break;
                    case 4:
                        onesString = "Four";
                        break;
                    case 5:
                        onesString = "Five";
                        break;
                    case 6:
                        onesString = "Six";
                        break;
                    case 7:
                        onesString = "Seven";
                        break;
                    case 8:
                        onesString = "Eight";
                        break;
                    case 9:
                        onesString = "Nine";
                        break;
                    default:
                        System.out.println("Out of ability");
                        return; // Thêm return để thoát khỏi phương thức nếu không phải là số từ 20 đến 99
                }
                System.out.println(tensString + " " + onesString);
            } else {
                System.out.println(tensString);
            }
        } else if (number >= 100 && number < 1000) {
            int hundreds = number / 100;
            int remaining = number % 100;
            String hundredsString = "";

            switch (hundreds) {
                case 1:
                    hundredsString = "One hundred";
                    break;
                case 2:
                    hundredsString = "Two hundred";
                    break;
                case 3:
                    hundredsString = "Three hundred";
                    break;
                case 4:
                    hundredsString = "Four hundred";
                    break;
                case 5:
                    hundredsString = "Five hundred";
                    break;
                case 6:
                    hundredsString = "Six hundred";
                    break;
                case 7:
                    hundredsString = "Seven hundred";
                    break;
                case 8:
                    hundredsString = "Eight hundred";
                    break;
                case 9:
                    hundredsString = "Nine hundred";
                    break;
                default:
                    System.out.println("Out of ability");
                    return; // Thêm return để thoát khỏi phương thức nếu không phải là số từ 100 đến 999
            }

            if (remaining != 0) { // Kiểm tra xem phần dư có khác 0 không
                if (remaining >= 10 && remaining < 20) { // Kiểm tra số từ 10 đến 19
                    int ones = remaining % 10;
                    switch (ones) {
                        case 0:
                            System.out.println(hundredsString + " and Ten");
                            break;
                        case 1:
                            System.out.println(hundredsString + " and Eleven");
                            break;
                        case 2:
                            System.out.println(hundredsString + " and Twelve");
                            break;
                        case 3:
                            System.out.println(hundredsString + " and Thirteen");
                            break;
                        case 4:
                            System.out.println(hundredsString + " and Fourteen");
                            break;
                        case 5:
                            System.out.println(hundredsString + " and Fifteen");
                            break;
                        case 6:
                            System.out.println(hundredsString + " and Sixteen");
                            break;
                        case 7:
                            System.out.println(hundredsString + " and Seventeen");
                            break;
                        case 8:
                            System.out.println(hundredsString + " and Eighteen");
                            break;
                        case 9:
                            System.out.println(hundredsString + " and Nineteen");
                            break;
                        default:
                            System.out.println("Out of ability");
                    }
                } else { // Trường hợp số hàng đơn vị từ 20 đến 99
                    int tens = remaining / 10;
                    int ones = remaining % 10;
                    String tensString = "";
                    String onesString = "";

                    switch (tens) {
                        case 2:
                            tensString = "Twenty";
                            break;
                        case 3:
                            tensString = "Thirty";
                            break;
                        case 4:
                            tensString = "Forty";
                            break;
                        case 5:
                            tensString = "Fifty";
                            break;
                        case 6:
                            tensString = "Sixty";
                            break;
                        case 7:
                            tensString = "Seventy";
                            break;
                        case 8:
                            tensString = "Eighty";
                            break;
                        case 9:
                            tensString = "Ninety";
                            break;
                        default:
                            System.out.println("Out of ability");
                            return; // Thêm return để thoát khỏi phương thức nếu không phải là số từ 100 đến 999
                    }

                    if (ones != 0) {
                        switch (ones) {
                            case 1:
                                onesString = "One";
                                break;
                            case 2:
                                onesString = "Two";
                                break;
                            case 3:
                                onesString = "Three";
                                break;
                            case 4:
                                onesString = "Four";
                                break;
                            case 5:
                                onesString = "Five";
                                break;
                            case 6:
                                onesString = "Six";
                                break;
                            case 7:
                                onesString = "Seven";
                                break;
                            case 8:
                                onesString = "Eight";
                                break;
                            case 9:
                                onesString = "Nine";
                                break;
                            default:
                                System.out.println("Out of ability");
                                return; // Thêm return để thoát khỏi phương thức nếu không phải là số từ 100 đến 999
                        }
                        System.out.println(hundredsString + " and " + tensString + " " + onesString);
                    } else {
                        System.out.println(hundredsString + " and " + tensString);
                    }
                }
            } else {
                System.out.println(hundredsString);
            }
        } else {
            System.out.println("Out of ability");
        }

        sc.close();
    }
}
