package C02ClassBasic;

import java.util.*;

public class C03Class {
    public static void main(String[] args) {
//        System.out.println(MyCalculator.sum(10,20));

////        A부서의 매출
////        20원 매출 발생
//        System.out.println(MyCalculator.sumAcc(20));
////        30원 매출 발생
//        System.out.println(MyCalculator.sumAcc(30));
////        40원 매출 발생
//        System.out.println(MyCalculator.sumAcc(40));
////        누적합 : 90원
//
////        B부서의 매출
////        10원 매출
//        System.out.println(MyCalculator.sumAcc(10));    //100원  -> 10원이 되야함
////        20원 매출
//        System.out.println(MyCalculator.sumAcc(20));    //120원  -> 30원이 되야함

//        객체를 활용한 매출 계산
//        A부서 매출 : 10원, 20원
//        ⭐객체 생성시 고유의 힙메모리영역을 가진다
//        ⭐     클래스명     객체명  new          클래스명
        MyCalculatorInstance mi1 = new MyCalculatorInstance();  //객체 mi1 생성 후 메서드 호출
//        MyCalculatorInstance.sumAcc() : statck이 없으므로 sumAcc는 호출이 불가 -> 객체로 만들어서 호출해야함
        mi1.sumAcc(10);
        System.out.println(mi1.total);  //직접 힙모리영역에서 값을 조회
        mi1.sumAcc(20);
        System.out.println(mi1.total);
//        B부서 매출 : 10원, 20원
        MyCalculatorInstance mi2 = new MyCalculatorInstance();  //객체 mi2 생성 후 메서드 호출
        mi2.sumAcc(10);
        System.out.println(mi2.total);  //⭐직접 힙모리영역에서 값을 조회
        mi2.sumAcc(20);
        System.out.println(mi2.total);

        System.out.println(MyCalculatorInstance.total_count);

//        자료구조에서 객체 사용 예시
//        배열
        String[] arr1 = {"hello", "java", "python"};
//        ⭐클래스 메서드(클래스명.메서드명) vs 객체(인스턴스) 메서드(객체명.메서드명)
        Arrays.sort(arr1);                  //클래스 메서드
        System.out.println(arr1.length);    //객체(인스턴스) 메서드

//        리스트
        List<String> myList = new ArrayList<>();
        Collections.sort(myList);                   //클래스 메서드
        myList.sort(Comparator.naturalOrder());     //객체(인스턴스) 매서드
    }
}


class MyCalculator {
//    static이 붙어있으면 클래스변수, static이 붙어있지 않으면 객체변수
    static int total = 0;

    public static int sum(int a, int b) {
        return a+b;
    }
    public static int sumAcc(int a) {
        total += a;
        return total;
    }
}

//    static이 붙으면 공유되어 부서끼리 매출이 중복됨. -> static 제거 -> 이거슨 붕어빵틀이닷~! -> 객체는 붕어빵이닷~!
class MyCalculatorInstance {
    int total = 0;  //객체변수
//    클래스변수는 모든 인스턴스(객체) 간에 상태 공유 목적으로 주로 사용
    static int total_count=0;   //클래스변수

//    클래스를 만들면, 아래와 같은 클래스명의 이름을 가진 메서드(생성자)가 기본으로 만들어짐.
//    생성자의 주된 목적은 객체 생성시 실행되면서 객체변수를 초기화하기 위한 목적으로 주로 사용.
    public MyCalculatorInstance() {
        total_count++;  //3
    }

//   클래스메서드는 객체의 상태와 상관없는 독립적인 로직 수행시에 사용 가능
    public static int sum(int a, int b) {   //객체변수에 값을 지속적으로 변경할 필요가 없는 메서드이므로 static 적용
        return a+b;
    }
    public void sumAcc(int total) {
//        this는 객체 그 자신을 의미한다.
//        일반적으로 매개변수와 객체변수를 구분짓기 위해 사용 (ex.매개변수명도 total, 객체변수명도 total일 경우)
        this.total += total;    //this.total -> 객체변수 // 그냥 total -> 매개변수
    }
}