package C02ClassBasic;

import java.util.Scanner;

public class C02MethodPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = Integer.parseInt(sc.nextLine());
        if(isPrime(input)) {
            System.out.println("입력하신 숫자는 소수입니다.");
        } else {
            System.out.println("입력하신 숫자는 소수가 아닙니다.");
        }
    }
//    소수판별기 메서드(isPrime) 생성
    public static boolean isPrime(int num) {
        for(int i=2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
//                메서드에서 return을 만나면 메서드가 강제 종료
                return false;
            }
        }
        return true;
    }
}
