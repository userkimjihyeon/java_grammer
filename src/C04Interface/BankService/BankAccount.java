package C04Interface.BankService;

public class BankAccount {
    //필드
    private String accountNumber;
    private long balance;

    //생성자
    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        //계좌개설시에는 잔고가 필요없으므로 balance는 입력받지 않음.
    }

    //메서드
//    최종금액을 통해 update : 아래 메서드를 입/출금 모두에 활용
    public void updateBalance(long balance) {
        this.balance = balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public long getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
