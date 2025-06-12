package C01Basic;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class C06String {
    public static void main(String[] args) {
////        원시자료형은 스택메모에 저장되므로, 비교시 값자체를 비교
//        int a = 10;
//        int b = 10;
//        System.out.println(a==b);

////        참조자료형의 비교는 기본적으로 메모리주소값끼리의 비교
//        String st1 = new String("hello");
//        String st2 = new String("hello");
//        System.out.println(st1==st2);   //false
//        System.out.println(st1.equals(st2));    //true
//
////        ⭐Wrapperclass : 기본형 타입을 Wrapping한 클래스
//        int i1 = 10;
////        Integer ig1 = new Integer(10);
////        오토박싱 : 원시자료형 -> Wrapper클래스 자동 형변환
//        Integer ig1 = 10;
////        오토언박싱 : Wrapper클래스 -> 원시자료형으로 자동 형변환
//        int i2 = ig1;
//
////        Wrapper클래스의 기능
//        int i3 = 10;
//        String st4 = String.valueOf(i3);    //??->String
//        String st3 = Integer.toString(i3);  //int->String
//        int i4 = Integer.parseInt(st3);     //String->int
//
////        배열(참조자료형)에는 원시타입 자료형 세팅 가능
//        int[] arr = {10,20,30};
//
////        그외(리스트, set, map) 등에는 참조자료형을 세팅해야함
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(10);
//        list.add(20);
//        list.add(30);

////        String 선언방법 2가지
////        객체선언방식
//        String st1 = new String("hello world");
//        String st2 = new String("hello world");
////        리터럴방식 : java에서 추천하는 방식(중복값은 동일 메모리주소를 참조하도록하여 메모리최적화)
//        String st3 = "hello world";
//        String st4 = "hello world";
//        System.out.println(st1); //원칙적으로 힙메모리주소값이 출력되야하지만, 빈번해서 그냥 값이 출력됨.
//        System.out.println(st1==st2);   //false 별도의 힙메모리공간
//        System.out.println(st3==st4);   //true  같은 힙메모리공간
//        System.out.println(st1==st3);   //false 별도의 힙메모리공간
//
////        참조자료형의 비교는 ==을 지양
//        System.out.println(st1.equals(st3));    //true 값비교

////        equals : 두 문자열 비교
//        String st1 = "hello1";
//        String st2 = "hello1";
//        String st3 = "HeLLo1";
//        System.out.println(st1.equals(st2));    //true
//        System.out.println(st1.equals(st3));    //false
//        System.out.println(st1.equalsIgnoreCase(st3));  //true 대소문자무시

////        length : 문자열의 길이 출력
//        String st1 = "hello1 World1 Java2";
//        System.out.println(st1.length());
////        charAt(n) : 특정 index의 문자(char)값을 리턴
//        char ch1 = st1.charAt(0);
////        ⭐위 문자열의 소문자알파벳의 개수구하기 : for, length, charAt 활용
//        int total = 0;
//        for(int i=0; i<st1.length(); i++) {
//            if(st1.charAt(i) >= 'a' && st1.charAt(i) <= 'z') {
//                total++;
//            }
//        }
//        System.out.println("소문자 알파벳의 개수 : " + total);

////        a의 개수가 몇개인지 출력
//        String st2 = "abcdefgabaaaa";
//        int count = 0;
//        for(int i=0; i<st2.length(); i++) {
//            if(st2.charAt(i) == 'a') {
//                count++;
//            }
//        }
//        System.out.println("a의 개수 : " + count);
////        ⭐toCharArray : String문자열을 char배열로 리턴
//        char[] chArr = st2.toCharArray();
//        int count2 = 0;
//        //for(char c : chArr) {
//        for(char c : st2.toCharArray()) {
//            if(c=='a') count2++; //실행문이 1줄밖에 없을때는 중괄호 생략가능
//        }

////        indexOf(문자열) : 특정 문자열의 위치(index) 반환. 가장 먼저 나오는 문자열의 위치 반환.
//        String st1 = "hello java java";
//        System.out.println(st1.indexOf("java"));

////        contains : 특정 문자열이 포함되어 있는지 여부(boolean)을 return
//        System.out.println(st1.contains("hello"));//true
//        System.out.println(st1.contains("world"));//false

//        문자열 더하기 : +=
        String st1 = "hello";
        st1 += " world";
        st1 += '1'; //String에 char를 더하면 String으로 더해짐.
        System.out.println(st1);

//        프로그래머스-나머지 구하기(플랫폼 사용방법)

////        StringBuffer : 문자열 조립 객체
//        StringBuffer sb = new StringBuffer();
////        append는 맨뒤에 문자열을 더하는 메서드.
//        sb.append("java");
//        sb.append("\n");
//        sb.append("python");
//        sb.append("\n");
//        sb.append("javascript");
//        String answer = sb.toString();
//        System.out.println(answer);
//
//        String[] arr = {"java", "python", "javascript"};
//        StringBuffer sb2 = new StringBuffer();
//        for(int i=0; i<arr.length; i++) {
//            sb2.append(arr[i]);
//            sb2.append("\n");
//        }
//        sb2.insert(0, "C++\n");               //insert : 중간삽입(지양)
//        sb.deleteCharAt(sb.length()-1);        //마지막 인덱스(-1)를 삭제
//        System.out.println(sb2);

////        StringBuilder : 문자열 조립 객체(가장빠름)
//        String st1 = "hello";
////        StringBuilder는 동시성이슈O == Thread-Safe하지않음, 성능이 뛰어남.    -> 문제풀이용      //Thread:작업주체. Thread-safe:동시작업막음.
//        StringBuilder sb = new StringBuilder();
////        StringBuffer는 동시성이슈X == Thread-Safe함, 성능이 떨어짐.          -> 개발용
//        StringBuffer sb2 = new StringBuffer();

////        문자열 뒤집기
//        String st1 = "hello";
//        StringBuilder sb = new StringBuilder();
//        for(int i=st1.length()-1; i>=0; i--) {      //st1.length()-1(마지막인덱스)부터 ~ 0번째 인덱스까지
//            sb.append(st1.charAt(i));
//        }
//        System.out.println(sb);
//
////        프로그래머스 - 문자열밀기 -> 어려워서 못품

        
        
        

        
        
        
    }
}
