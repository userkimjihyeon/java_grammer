package C05AnonymousLambda;

//⭐익명 내부클래스
public class C02AnonymousClass {
    public static void main(String[] args) {
////        AbstractAnimal을 상속한 클래스가 별도로 존재하지 않고,
////        익명클래스가 만들어짐과 동시에 익명객체(a1,a2,a3)가 생성되고 있음.
//        AbstractAnimal a1 = new AbstractAnimal() {
//            @Override
//            void makeSounde1() {}
//        };
//        a1.makeSounde1();
//        a1.makeSound2();
//
////        구현체가 없는 추상클래스 또는 인터페이스는 익명객체로 생성가능.
//        Animal1 a2 = new Animal1() {
//            @Override
//            public void makeSound1() {}
//
//            @Override
//            public void makeSound2() {}
//        };
////        인터페이스의 익명객체의 구현메서드가 1개밖에 없을때에는 람다표현식(화살표함수) 사용가능
//        Animal2 a3 = () -> {
//            System.out.println("hello world1");
//            System.out.println("hello world2");
//        };
//        a3.makeSound1();

////        실행문이 1줄일때는 중괄호제거 가능하다.
//        Animal2 a4 = () -> System.out.println("hello world1");
//        a4.makeSound1();

////        매개변수가 있는 익명객체의 람다함수 생성
//        Animal3 a5 = (i1, i2, i3) -> {return i1 + ", " + i2 + ", " + i3;};
//        Animal3 a6 = (i1, i2, i3) -> i1 + ", " + i2 + ", " + i3;                //메서드 1개는 중괄호 제거가능(+return)
//        System.out.println(a6.makeSound1("java", "python", "C++"));

//        실습
//        Animal4인터페이스 정의. makeSound메서드 선언(매개변수는 String, String, int. 리턴타입은 String)
//        익명객체 생성 : 메서드의 기능 - int숫자값이 10이상이면 a+b를 리턴, int숫자값이 10미만이면 a만 리턴.
        Animal4 a7 = (a, b, c) -> {
            if(c >= 10) {
                return a+b;
            } else {
                return a;
            }
        };
        System.out.println(a7.makeSound("hello", "java", 5));


    }
}
////추상클래스 : 추상메서드를 가진 클래스 -> 구현체(자식클래스가 상속해서 구현)가 없으므로 기본적으로 객체 생성 불가
//abstract class AbstractAnimal {
//    abstract void makeSounde1();
//    void makeSound2() {
//    }
//}
//
////인터페이스
//interface Animal1{
//    void makeSound1();
//    void makeSound2();
//}
//interface Animal2{
//    void makeSound1();
//}
//interface Animal3{
//    String makeSound1(String a, String b, String c);
//}
interface Animal4 {
    String makeSound(String a, String b, int c);
}
