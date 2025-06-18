package C02ClassBasic;

import java.util.ArrayList;
import java.util.List;

//원시자료형 : 스택, 객체의 경우 힙의 주소 값
//객체 : 힙
//특정 객체의 변수안정성을 위해 setter를 쓰지않음 -> 객체 생성시점에 필요한 값 최초 할당 (생성자 생성)

public class C07Constructor {
    public static void main(String[] args) {
//        캘린더 객체 생성 : 연도, 월, 일 세팅 (세터써서)
        Calendar c1 = new Calendar("2025", "06", "18");

//        캘린더 객체 출력 : "오늘은 xxx연도 xx월 xx일 입니다."
//        toString()메서드는 특별한 메서드로 객체명을 출력할때 자동으로 실행
//        예를들어)
        List<Integer> myList = new ArrayList<>();
        myList.add(10);
        System.out.println(myList);
        System.out.println(c1);
    }
}

//⭐내부클래스
//Calendar 클래스 생성 : year, month, day 모두 String
class Calendar {
    private String year;
    private String month;
    private String day;

//    생성자를 통해 객체변수값들을 객체가 만들어지는 시점에 초기화(세팅)
    public Calendar(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

//    위의 별도 생성자를 추가할 경우, 초기(기본)생성자는 무시되므로, 필요시 별도로 추가
    public Calendar() {

    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "오늘은 " + this.year + "년도 " + this.month + "월 " + this.day + "일 입니다.";
    }
}