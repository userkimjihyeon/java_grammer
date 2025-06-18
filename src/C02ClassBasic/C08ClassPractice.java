package C02ClassBasic;

import java.util.ArrayList;
import java.util.List;

public class C08ClassPractice {
    public static void main(String[] args) {
//        객체 선언 및 List에 2개 정도 add
        List<Account> myList = new ArrayList<>();
        Account a1 = new Account("hong1", "1234", 100_000);
        Account a2 = new Account("hong2", "4321", 200_000);
        myList.add(a1);
        myList.add(a2);

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

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name  +
                ", accountNumber='" + accountNumber +
                ", balance=" + balance +
                '}';
    }

}
