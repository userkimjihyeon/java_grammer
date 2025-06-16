package C01Basic;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

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

////        ⭐ndexOf(문자열) : 특정 문자열의 위치(index) 반환. 가장 먼저 나오는 문자열의 위치 반환.
//        String st1 = "hello java java";
//        System.out.println(st1.indexOf("java"));

////        contains : 특정 문자열이 포함되어 있는지 여부(boolean)을 return
//        System.out.println(st1.contains("hello"));//true
//        System.out.println(st1.contains("world"));//false

////        문자열 더하기 : +=
//        String st1 = "hello";
//        st1 += " world";
//        st1 += '1'; //String에 char를 더하면 String으로 더해짐.
//        System.out.println(st1);

////        프로그래머스-나머지 구하기(플랫폼 사용방법)
////        ⭐프로그래머스-특정 문자 제거하기
//        String my_string = "abcdef";
//        String letter = "f";
//        String answer = "";
//        for(char c : my_string.toCharArray()) {     //⭐toCharArray()
//            if(c != letter.charAt(0)) {             //⭐letter.charAt(0) : String과 char를 비교하고 싶을때 String.charAt()사용
//                answer += c;
//            }
//        }
//        System.out.println(answer);

////        substring(a,b) : a이상 b미만의 index의 문자를 잘라 문자열 반환
//        String st1 = "hello world";
//        System.out.println(st1.substring(0, 5));    //hello
//        System.out.println(st1.substring(6,st1.length()));  //world

////        ⭐프로그래머스-특정 문자 제거하기
//        String my_string = "abcdef";
//        String letter = "f";
//        String answer = "";
//
//        for (int i=0; i<my_string.length(); i++) {              //총 <5까지 반복이라서 인덱스는 0~4까지 즉 5번, i+1은 최대5
//            if (!my_string.substring(i, i+1).equals(letter)) {  //⭐substring(i, i+1)     ⭐equals로 비교
//                answer += my_string.substring(i, i+1);
//            }
//        }
//        System.out.println(answer);

////        ⭐프로그래머스-가운데 글자 가져오기
//        //s의 총길이 % 2 해서 ==0은 짝수 !=0은 홀수
//        //짝수는 나눈 몫의 +1해서 substring(몫, 2)
//        //홀수는 나눈 몫 하나 가져오기  subsctring(몫, 1)
//        //String s = "qwer";
//        String s = "abcde";
//        String answer = "";
//
//        int a = s.length() % 2; //나머지 1
//        int b = s.length() / 2; //몫 2
//
//        if (a == 0) {    //짝수
//            answer = s.substring(b-1, b+1); //⭐
//        } else {         //홀수
//            answer = s.substring(b, b+1);   //⭐
//        }
//        System.out.println(answer);

////        trim, strip : 문자열 양쪽 끝의 공백 제거
//        String st =  " hello world  ";
//        String trim = st.trim();
//        String strip = st.strip();
//        System.out.println(trim);
//        System.out.println(strip);

////        toUpperCase : 모든 문자열을 대문자로 변환, toLowerCase : 모든 문자열을 소문자로 변환
//        String s1 = "Hello";
//        String s2 = s1.toUpperCase();
//        String s3 = s1.toLowerCase();
//        System.out.println(s2);
//        System.out.println(s3);

////        replace(a,b) : a문자열을 b문자열로 대체
//        String st1 = "hello world";
//        String st2 = st1.replace("world", "java");
//        System.out.println(st2);

////        replaceAll(a,b) : replace와 사용법 동일. 정규표현식을 쓸 수 있는 점이 차이점.
//        String st1 = "01abC123한글123";
////        한글 제거
//        String answer1 = st1.replaceAll("[가-힣]", "");
//        String answer2 = st1.replaceAll("[a-z]", "");
//        String answer3 = st1.replaceAll("[A-Za-z]", "");
//        System.out.println(answer1);
//        System.out.println(answer2);
//        System.out.println(answer3);

////        전화번호 검증
//        String number = "010-1234-1234";
//        boolean check = number.matches("^\\d{3}-\\d{4}-\\d{4}$");
//        if(check==false) {
//            System.out.println("다시 입력하세요.");
//        }

////        이메일 검증
//        String email = "abc1234@naver.com";
//        boolean check_email = Pattern.matches("^[a-z0-9]+@[a-z]+.com$", email);
//        System.out.println(check_email);

////        split : 특정문자를 기준으로 잘라서 문자배열로 만드는 것.
//        String a = "a:b:c:d";
//        String[] arr = a.split(":");
//        System.out.println(Arrays.toString(arr));

//        String b = "a b c  d";
//        String[] arr = b.split(" ");
//        String[] arr2 = b.split("\\s+");    //\s : 공백
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(arr2));

////        ⭐null과 공백의 차이
//        String st1 = null;   //null은 String이 아님.
//        String st2 = "";     //빈문자열은 문자열임.
//        String st3 = " ";    //스페이스.
//        System.out.println(st1==st2);   //false
////        System.out.println(st1.isEmpty());  //nullpointer exception 발생
//        System.out.println(st2.isEmpty());  //true
//        System.out.println(st3.isBlank());  //true
//        String abc = "hello    world   java";
//        for(int i=0; i<abc.length(); i++) {
//            if(abc.substring(i, i+1).isBlank()) {
//                System.out.println(i + "번째는 blank");
//            }
//        }

////        문자열합치기 -> 참고만
//        String[] arr = {"java", "python", "javascript"};
//        String answer = "";
//        for(String a : arr) {
//            answer += a;
//            answer += "\n";
//        }
//        System.out.println(answer);
//        String answer2 = String.join(" ", arr);
//        System.out.println(answer2);


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

////        ⭐문자열 뒤집기
//        String st1 = "hello";
//        StringBuilder sb = new StringBuilder();
//        for(int i=st1.length()-1; i>=0; i--) {      //st1.length()-1(마지막인덱스)부터 ~ 0번째 인덱스까지
//            sb.append(st1.charAt(i));
//        }
//        System.out.println(sb);

////        ⭐문자열비교
//        String s1 = "hello";
//        String s2 = "dello";
//        String s3 = "hello";
//        System.out.println(s1.compareTo(s2));   //양수 h-d(아스키코드비교)
//        System.out.println(s2.compareTo(s1));   //음수 d-h(아스키코드비교)
//        System.out.println(s1.compareTo(s3));   //0 h-h(아스키코드비교)
//
////        ⭐프로그래머스 - 문자열밀기 -> 혼자풀어보기

    }
}
