package C03Inheritance;

import java.util.List;

//final키워드가 붙은 class는 상속불가. final키워드가 붙은 메서드는 overriding불가.
//public class C06AbstractMain extends FinalParents {
public class C06AbstractMain {
    public static void main(String[] args) {
////            자식                 자식
//        AbstractDog d1 = new AbstractDog();
//        d1.makeSound1();    //동물을 소리를 냅니다.
//        d1.makeSound2();    //멍멍

//        ⭐추상클래스는 구현체없는 메서드가 있으므로, 기본적으로 객체 생성 불가능.
//        AbstractAnimal a1 = new AbstractAnimal();

//        ⭐객체의 실체가 Dog클래스를 통해 만들어지므로, 여기서는 d2의 makeSound2를 사용가능
//           부모                    자식
        AbstractAnimal d2 = new AbstractDog();
        d2.makeSound1();    //동물을 소리를 냅니다.
        d2.makeSound2();    //멍멍    //⭐추상메서드 -> 부모가 규칙만 정하고, 자식이 반드시 구현 //부모에서 선언만 되어있고 자식에서 오버라이딩해서 구현함.

//        ⭐모든 메서드가 abstract인 클래스를 인터페이스라 한다.
//        ⭐인터페이스는 구현체가 없으므로, 기본적으로 별도의 객체 생성 불가
//        List<Integer> myList = new List<>();
    }
}
//⭐추상메서드가 하나라도 있으면 반드시 클래스에도 abstract키워드를 붙이고, 추상클래스가 됨.
abstract class AbstractAnimal {
    void makeSound1() {
        System.out.println("동물을 소리를 냅니다.");
    }
//  ⭐메서드를 선언만하고 구현이 없는 메서드선언시 abstract키워드 사용.   추상메서드는 -> 자식클래스가 구현하도록 함.
    abstract void makeSound2();
}

class AbstractDog extends AbstractAnimal {
    @Override
    void makeSound2() {
        System.out.println("멍멍");
    }
}

final class FinalParents {

}