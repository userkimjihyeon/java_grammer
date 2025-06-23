package C04Interface.BankService;

import java.util.Scanner;

//Controller : 사용자와 인터페이스
//Service : 핵심로직수행
//엔티티 : 상태관리 ex)Post객체, Author/Member객체
public class BankController {
    public static void main(String[] args) {
        System.out.println("계좌번호를 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        String accountNumber = sc.nextLine();
        BankAccount ba = new BankAccount(accountNumber);
//        BankServiceOriginal bs = new BankServiceOriginal();   -> BankServiceOriginal을 인터페이스(BankService)로 전환하여 1.카카오페이 2.토스페이로 상속받아 사용.
//        인터페이스로 전환
        BankService bs = null; //지역변수는 무조건 초기화해줘야함 (멤버변수는 자동 초기값이 들어갑니다)

        while(true) {
            System.out.println("입금하시려면 1번, 출금하시려면 2번");
            String serviceNumber = sc.nextLine();

            if(serviceNumber.equals("1")) {
                System.out.println("입금하실 금액을 입력하세요.");
                long money = Long.parseLong(sc.nextLine());

                System.out.println("입금방식을 선택해주세요, 1.카카오페이 2.토스페이");
                String number = sc.nextLine();
                if (number.equals("1")) {
//              인터페이스        클래스
                    bs = new BankKakaoService();
                    bs.deposit(money, ba);
                } else if (number.equals("2")) {
                    bs = new BankTossService();
                    bs.deposit(money, ba);
                }

                System.out.println("입금이 완료되었습니다.");
            } else {
                System.out.println("출금하실 금액을 입력하세요.");
                long money = Long.parseLong(sc.nextLine());
                System.out.println("출금방식을 선택해주세요, 1.카카오페이 2.토스페이");
                String number = sc.nextLine();
                if (number.equals("1")) {
                    bs = new BankKakaoService();
                } else if (number.equals("2")) {
                    bs = new BankTossService();
                }

                if(bs.withdraw(money, ba)) {
                    System.out.println("출금이 정상처리되었습니다.");
                } else {
                    System.out.println("잔액부족입니다. 출금불가합니다.");
                }
            }
        }
    }
}
