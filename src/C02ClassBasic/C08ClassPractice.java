package C02ClassBasic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C08ClassPractice {
    public static void main(String[] args) {
//        객체 선언 및 List에 2개 정도 add
        List<Account> myList = new ArrayList<>();
//        계좌개설이 이미 된 상황
        Account a1 = new Account("hong1", "01234", 100_000);
        Account a2 = new Account("hong2", "54321", 200_000);
        myList.add(a1);
        myList.add(a2);

//        계좌번호 목록조회
        for(Account a : myList) {
            System.out.println(a.getAccountNumber());
        }

//        사용자1이 사용자2에게 송금(50,000)
//        1)list방법 -> 비효율적
        for(Account a : myList) {       //a에는 Account객체의 주소값이 담겨있다.
            if (a.getAccountNumber().equals("01234")) {
                a.setBalance(a.getBalance()-50_000);//⭐setter 추가
            }
            if (a.getAccountNumber().equals("54321")) {
               a.setBalance(a.getBalance()+50_000);
            }
        }

//        계좌상세조회 : 계좌번호와 잔고조회
        for(Account a : myList) {
            System.out.println("계좌번호 : " + a.getAccountNumber() + " 잔고 : " + a.getBalance());
        }


//        2)map방법 -> 효율적
//        Map을 자료구조로 사용
        Map<String, Account> accountMap = new HashMap<>();

//        계좌개설
        accountMap.put("12345", new Account("hong1","12345", 100_000));
        accountMap.put("54321", new Account("hong1","54321", 100_000));

//        송금
        Account a = accountMap.get("12345");
        Account b = accountMap.get("54321");
        a.setBalance((a.getBalance()-50_000));
        b.setBalance((b.getBalance()+50_000));

//        ⭐계좌조회
        for(String ac : accountMap.keySet()) {
            System.out.println("냐" +  accountMap.get(ac).getAccountNumber());  //get(ac)로 account객체를 가져와서 .getAccountNumber()
        }

        System.out.println(myList.get(0));
        System.out.println(myList.get(1));
    }
}
//Account 클래스 생성. 계좌주명(String name), 계좌번호(String accountNumber), 잔고(long balance)
class Account {
    private String name;
    private String accountNumber;
    private long balance;

    public Account(String name, String accountNumber, long balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name  +
                ", accountNumber='" + accountNumber +
                ", balance=" + balance +
                '}';
    }

}
