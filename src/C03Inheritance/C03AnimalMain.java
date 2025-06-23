package C03Inheritance;

public class C03AnimalMain {
    public static void main(String[] args) {
        Dog d1 = new Dog();
        d1.sound();
        Cat c1 = new Cat();
        c1.sound();

//        ⭐⭐⭐⭐⭐상속관계일때는 부모클래스의 타입을 자식클래스의 객체의 타입으로 지정하는 것이 가능.
//        ⭐⭐⭐⭐⭐부모클래스의 타입을 지정시, 부모클래스에서 정의된 메서드만 객체에서 사용 가능. -> 자식클래스에서 오버라이딩하면? 자식메서드 사용
        // 부모            자식
        Animal d2 = new Dog();
        d2.sound();
//        d2.sound2();  //사용불가
    }
}

class Animal {
    void sound() {
        System.out.println("동물이 소리를 냅니다.");
    }
}
class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("멍멍");
    }
    void sound2() {
        System.out.println("멍멍멍멍");
    }
}
class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("야옹");
    }
}