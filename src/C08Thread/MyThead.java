package C08Thread;

public class MyThead extends Thread {   //Thread클래스 상속(: 멀티스레드만들기위한 클래스)
//    thread클래스에 내장된 run메서드는 비어있는 메서드.
//    run메서드는 스레드가 시작될때 자동으로 호출되는 메서드.
//    스레드 실행시 특정 작업을 수행하고 싶다면, run메서드를 overriding해서 코드 작성.
    @Override
    public void run() {
        System.out.println("스레드 실행시작(myThread)");
    }

}
