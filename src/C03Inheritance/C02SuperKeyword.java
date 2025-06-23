package C03Inheritance;

//부모클래스를 상속받을때, 부모클래스에 기본생성자가 없으면 자식클래스에서 상속시 기본적으로 에러발생.(원인 : 부모클래스의 변수를 초기화하지 않아서)
//해결방법 : 1.자식클래스에서 생성자를 호출 2.부모클래스에서 기본생성자를 생성
public class C02SuperKeyword extends SuperParents {
    int a = 10;

//    1. 자식클래스에서 생성자를 호출 -> 부모클래스의 변수 초기화
    C02SuperKeyword() {
//        super() : 부모클래스의 생성자를 호출하는 메서드
        super(20);
        this.a = 10;
    }

    public static void main(String[] args) {
        C02SuperKeyword c2 = new C02SuperKeyword();
        System.out.println(c2.a);
        c2.display();
    }

    public void display() {
        System.out.println("자식의 변수 : " + a);
        System.out.println("부모의 변수 : " + super.a);
    }
}

class SuperParents {
    int a = 20;
    public SuperParents(int a) {
        this.a = a;
    }
////    2. 부모클래스에서 기본생성자를 생성
//    public SuperParents() {
//
//    }
}