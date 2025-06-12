package C01Basic;

import java.sql.SQLOutput;

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
////        Wrapperclass : 기본형 타입을 Wrapping한 클래스
//        int i1 = 10;
//        Integer ig1 = 10;

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

//        문자열 뒤집기
        String st1 = "hello";
        StringBuilder sb = new StringBuilder();
        for(int i=st1.length()-1; i>=0; i--) {      //st1.length()-1(마지막인덱스)부터 ~ 0번째 인덱스까지
            sb.append(st1.charAt(i));
        }
        System.out.println(sb);

//        프로그래머스 - 문자열밀기 -> 어려워서 못품

        
        
        

        
        
        
    }
}
