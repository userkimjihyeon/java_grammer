package C08Thread;

import java.util.TreeSet;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
////        단일스레드 실행 -> 나혼자 프로그램 실행한 것
//        for(int i=0; i<101; i++) {
//            Library.borrow();
//        }
//        System.out.println("재고 : " + Library.getBookCount());

////        멀티스레드 생성(생성말고 막는게 중요함)
////        방법1. 스레드 클래스 상속방식
//        Thread t1 = new MyThead();
//        Thread t2 = new MyThead();
//        Thread t3 = new MyThead();
//        Thread t4 = new MyThead();
////        Thread클래스안에 start메서드 내장되어있고, start메서드는 run메서드 호출하면서 스레드 생성.
////        각 스레드의 코드 실행 순서는 보장되지 않음.
////        (스레드 4개+1개 생성된 것임 -> 순서 제각각.)
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        System.out.println("hello world");

////        방법2. Runable(run() 메서드 하나만 있는 인터페이스)을 직접 구현한 객체를 Thread클래스 생성자에 주입하는 방식
////        익명객체 = 클래스를 따로 정의하지 않고, 즉석에서 인터페이스 구현한 객체 -> MyThread 불필요.
////        Thread t1 = new Thread(() -> System.out.println("스레드 실행시작(myThread)"));
////        t1.start();
//        new Thread(() -> System.out.println("스레드 실행시작(myThread)1")).start();
//        new Thread(() -> System.out.println("스레드 실행시작(myThread)2")).start();
//        new Thread(() -> System.out.println("스레드 실행시작(myThread)3")).start();
//        new Thread(() -> System.out.println("스레드 실행시작(myThread)4")).start();
//        System.out.println("hello world");

//        멀티스레드 동시성 이슈 테스트
        for (int i=0; i<1000; i++) {
            Thread t1 = new Thread(()-> Library.borrow());
            t1.start();
            t1.join();  //동시성이슈 해결방법2) 한 스레드의 작업이 모두 완료될때, 다른 스레드 생성하여 작업 수행. -> 사실상 단일스레드처럼 동작, 성능저하 발생.
        }
        Thread.sleep(20000); //delay -> main스레드가 borrow()를 기다리도록...
        System.out.println(Library.getBookCount());  //main스레드가 실행

    }
}

