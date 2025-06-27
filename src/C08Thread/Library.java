package C08Thread;

public class Library {
    private static int bookCount = 100;
    //borrow()에 여러 사용자가 접근 -> bookCount 개수 혼재
    public static void borrow() {
//    동시성이슈 해결방법1) synchronized : 메서드 내에서 한개의 스레드만 실행되도록 강제. -> 동시성 이슈 해결! -> rdb커밋시점차로 인해 아래주석과 같은 이슈발생
//    rdb에 재고관리를 할경우에는 synchronized를 통한다 하더라도, 쿼리와 commmit실행시점에 차이로 인해 동시성 이슈 발생.
//    public synchronized static void borrow() {
        if(bookCount > 0) {
            try {
                Thread.sleep(100);  //delay -> 다른 스레드가
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            bookCount-=1;
            System.out.println("대출완료");
        } else {
            System.out.println("대출불가");
        }
    }
    public static int getBookCount() {
        return bookCount;
    }
}
