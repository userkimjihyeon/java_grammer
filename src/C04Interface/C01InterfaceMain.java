package C04Interface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class C01InterfaceMain {
    public static void main(String[] args) {
//        C01Cat c1 = new C01Cat();
//        c1.makeSound();
//        C01Dog d1 = new C01Dog();
//        d1.makeSound();

////       ⭐다형성 : 하나의 부모타입으로 여러 자식객체를 다룰 수 있음.
////                부모                 자식         -> ⭐자식클래스의 구현체임. -> ⭐부모타입의 변수, 메서드만 사용가능!
//        C01AnimalInterface1 c2 = new C01Cat();
//        c2.makeSound();
//        C01AnimalInterface1 d2 = new C01Dog();
//        d2.makeSound();
//
////        예시
////        인터페이스의 장점 : 개발의 표준을 지정 (ex. 매개변수, 리턴타입...)
////      ⭐다형성의 장점 : 기존의 구현체를 다른 구현체로 변경시 이점.
////        인터페이스                   구현체
//        List<Integer> myList1 = new ArrayList<>();
//        myList1.add(10);
//        List<Integer> myList2 = new LinkedList<>();
//        myList2.add(10);
//
////        다중구현의 예시 -> 인터페이스에 따라 사용가능 메서드가 제한. -> LinkedList 자체는 List + Queue 의 모든 메서드 호출 가능(4개)
//        List<Integer> list = new LinkedList<>();           //-> list 는 List 인터페이스에 정의된 메서드만 호출 가능(2개)
//        Queue<Integer> que = new LinkedList<>();           //-> que 는 Queue 인터페이스에 정의된 메서드만 호출 가능(2개)

//        다중구현(상속)
        C01AnimalInterface1 c3 = new C01Cat();               //C01AnimalInterface1에는 makeSound() 메서드만 있음 -> makeSound()만 사용가능
        c3.makeSound();
        C01AnimalInterface2 d3 = new C01Dog();
        System.out.println((d3.play("말티푸", "시바"))); //C01AnimalInterface2에는 play(String a, String b) 메서드만 있음 -> play(String a, String b)만 사용가능
    }
}
