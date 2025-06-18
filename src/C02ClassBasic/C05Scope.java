package C02ClassBasic;

import java.util.ArrayList;
import java.util.List;

//변수의 유효범위
public class C05Scope {
//    ⭐중괄호영역볌위 : 클래스 변수는 최상위 / 객체의 전달방식 : 힙메모리 주소 전달
    public static int v2 = 10;  //클래스 변수
    public static void main(String[] args) {
////       지역변수의 유효범위
//        int v1 = 10;
//        scope(v1);
//        System.out.println(v1); //10
//       ⭐객체의 유효범위
        C04Person p1 = new C04Person();
        p1.setName("kim");
        p1.setEmail("kim@naver.com");
        p1.setAge(20);
        System.out.println(p1.printPerson());   //20
        scope2(p1);                             //⭐힙메모리주소를 넘김
        System.out.println(p1.printPerson());   //⭐30

        List<C04Person> myList = new ArrayList<>();
        myList.add(p1);                         //⭐힙메모리주소를 add
        myList.get(0).setAge(40);
        System.out.println(p1.printPerson());   //⭐40

////       클래스변수의 유효범위
//        System.out.println(v2);
//
    }

    //메서드에 static없으면 메서드쓸때마다 객체 생성 해야해서 실습시 귀찮음 이슈ㅋ
    public static void scope(int v1) {          //call by value
        v1=20;
        v2=30;
        System.out.println(v1);     //20
    }
    public static void scope2(C04Person p1) {   //⭐힙메모리 주소, call by reference
        p1.setAge(30);
        p1.printPerson();
    }
}
