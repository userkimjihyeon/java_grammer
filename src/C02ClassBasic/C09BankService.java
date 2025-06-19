package C02ClassBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class C09BankService {
//        계좌개설 및 입출금 서비스 : id(auto_increment), name(String), accountNumber(String), balance(long).
//        주의사항1 : main메서드에서 입출력 처리를 하고, deposit, withdraw, transfer 메서드는 BankAccount클래스에 생성.
//        주의사항2 : 프로그램은 항상 실행될수 있도록 전체코드를 while(true)처리
//        서비스번호를 입력하세요. 1.개설 2.조회 3.입금 4.출금 5.송금
//        1.계좌개설 : "계좌번호와 현재가지고 계신돈을 입력하세요." -> 자동으로 id값 증가되어 세팅
//        2.계좌조회 : "계좌조회서비스입니다. 계좌번호를 입력해주세요." -> 잔고출력
//        3.입금 : "계좌입금서비스입니다. 계좌번호와 입금금액을 입력해주세요." -> 현재 계좌에 잔액 출력.
//        4.출금 : "계좌출금서비스입니다. 계좌번호와 출금금액을 입력해주세요."(잔액검증) -> "남은 금액은 얼마입니다." 또는 "잔액이 부족합니다." 출력.
//        5.송금 : "송금서비스입니다. 본인의 계좌번호를 입력해주세요." "보내고자 하는 상대방의 계좌번호를 입력해주세요." "송금금액을 입력해주세요."(잔액검증) -> "남은금액은 얼마입니다." 또는 "잔액이 부족합니다."
    public static void main(String[] args) throws IOException {
//           자료구조 : BankAccount객체를 담아둘 자료구조 선언
        Map<String, BankAccount> accountMap = new HashMap<>();

        while(true) {
            //서비스번호 입력받기
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("하시고자 하는 서비스 번호를 입력해주세요");
            int serviceNumber = Integer.parseInt(br.readLine());

            //변수생성
            String accountNumber;
            long money = 0;
            BankAccount result;

            switch (serviceNumber) {
                case 1 :
                    System.out.println("계좌번호와 현재가지고 계신돈을 입력하세요.");
                    String[] str = br.readLine().split(" ");   //ex) 12345 100_000
                    accountNumber = str[0];
                    money = Long.parseLong(str[1]);

                    //입력받은 계좌번호와 현재예금액으로 계좌개설 map<계좌번호, map<계좌번호, 현재예금액>>
                    accountMap.put(accountNumber, new BankAccount(accountNumber, money));

                    result = accountMap.get(accountNumber);
                    System.out.println("현재 생성된 계좌id : " + result.getId());
                    break;
                case 2 :
                    System.out.println("계좌조회서비스입니다. 계좌번호를 입력해주세요.");
                    //⭐존재하지않는 계좌번호처리
                    //이중맵구조 map<계좌번호, map<계좌번호, 현재예금액>> 이므로, 여기서 변수key는 해당 객체임(내부맵X)임.
                    accountNumber = br.readLine();
                    result = accountMap.get(accountNumber);
                    if (result == null) {               //객체key가 존재하지 않으면.
                        System.out.println("존재하지 않는 계좌번호입니다.");
                    } else {
                        System.out.println("잔액 : " + accountMap.get(accountNumber).getBalance());
                    }
                    break;
                case 3 :
                    System.out.println("계좌입금서비스입니다. 계좌번호와 입금금액을 입력해주세요.");
                    str = br.readLine().split(" ");
                    accountNumber = str[0];
                    long depositMoney = Long.parseLong(str[1]);
                    //객체명.객체메서드.....근데 객체를 맵으로 생성했으면....????
                    //계좌번호로 찾아서 잔고+money하기
                    result = accountMap.get(accountNumber);
                    result.deposit(depositMoney);

                    System.out.println("입금후 잔액 : " + accountMap.get(accountNumber).getBalance());
                    break;
                case 4 :
                    System.out.println("계좌출금서비스입니다. 계좌번호와 출금금액을 입력해주세요.");
                    str = br.readLine().split(" ");
                    accountNumber = str[0];
                    long withdrawMoney = Long.parseLong(str[1]);
                    result = accountMap.get(accountNumber);
                    if(result.withdraw(withdrawMoney)) {
                        System.out.println("출금후 잔액 : " + accountMap.get(accountNumber).getBalance());
                    } else {
                        System.out.println("잔액이 부족합니다.");
                    }
                    break;
                case 5 :
                    System.out.println("송금서비스입니다. 본인의 계좌번호를 입력해주세요.");
                    accountNumber = br.readLine();
                    System.out.println("보내고자 하는 상대방의 계좌번호를 입력해주세요.");
                    String inputTarget = br.readLine();

                    //입력받은 inputTarget으로 targetAccount get하기
                    BankAccount targetAccount = accountMap.get(inputTarget);
                    System.out.println("송금금액을 입력해주세요.");
                    money = Long.parseLong(br.readLine());

                    if(accountMap.get(accountNumber).getBalance() > 0) {
                        result = accountMap.get(accountNumber);
                        result.transfer(targetAccount, money);
                        System.out.println("송금후 잔액 : " + accountMap.get(accountNumber).getBalance());
                    } else {
                        System.out.println("잔액이 부족합니다.");
                    }
                    break;
            }
        }
    }
}

class BankAccount {
    //필드
    private int id;
    private String accountNumber;
    private long balance;
    //id_auto
    public static int id_auto = 0;

    //생성자
    public BankAccount(String accountNumber, long balance) {
        //⭐id auto_increment
        id_auto++;
        this.id = id_auto;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

//    getter 생성
    public int getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    //    setter 생성 -> 의도를 명확히 한 메서드를 생성

    public void deposit(long money) {
        this.balance += money;
    }

    public boolean withdraw(long money) {
//            잔고가 있으면 차감 후 true리턴
        if(this.balance >= money) {
            this.balance -= money;
            return true;
        } else {
//            잔고가 없으면 false 리턴
            return false;
        }
    }

//    매개변수로 BankAccount 또는 String의 bankAccountNumber 둘다 가능
    public void transfer(BankAccount targetAccount, long money) {
        this.withdraw(money);

        //this말고 targetAccount의 객체로 deposit()돌리고 싶음.
        targetAccount.deposit(money);
    }

}
