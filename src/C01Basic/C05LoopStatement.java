package C01Basic;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class C05LoopStatement {
    public static void main(String[] args) {

//        int a = 0;
//        while (a < 10) {
//            System.out.println("hello world");
//            a = a+1;
//        }

//        while문을 활용하여 2~10까지 출력
//        int b = 2;
//        while (b<11) {
//            System.out.println(b);
//            b++;
//        }

//        도어락키예제 -> 무한반복 + 맞추면 종료되는 도어락키 예제 -> 5회입력횟수제한있는 도어락키 예제(5회이상초과됐습니다.)
//        while (true) {
//            int answer = 1234;
//            Scanner sc = new Scanner(System.in);
//            int input = sc.nextInt();
//
//            if(answer == input) {
//                System.out.println("문이 열렸습니다.");
////                break키워드를 통해 가장 가까이에 있는 반복문을 즉시종료.
//                break;
//            } else {
//                System.out.println("비밀번호가 틀렸습니다.");
//            }
//        }

//        int a=0;
//        while (true) {
//            int answer = 1234;
//            Scanner sc = new Scanner(System.in);
//            int input = sc.nextInt();
//
//                if (answer == input) {
//                    System.out.println("문이 열렸습니다.");
//                    break;
//                } else {
//                    System.out.println("비밀번호가 틀렸습니다.");
//                }
//                a++;
//                if(a==5) {
//                    System.out.println("비밀번호5회초과");
//                    break;
//                }
//            }

//       입력한 숫자의 구구단 단수 출력
//        while (true) {
//            System.out.println("구구단 단수를 입력해주세요.");
//            Scanner sc = new Scanner(System.in);
//            int input = sc.nextInt();
//
//            int i = 1;
//            while (i < 10) {
//                System.out.println(input + " X " + i + " = " + input*i);
//                i++;
//            }
//        }

//        do while문 : 무조건 1번은 실행되는 while문
//        int a = 100;
//        do {
//            System.out.println(a);
//        }
//        while (a < 10);

//        for문 : 초기식, 조건식, 증감식이 모두 포함돼 있는 반복문
//        for문은 사용했던 변수명을 for문이 끝난이후에 재선언이 가능
//        for (int i=0; i<10; i++) {
//            System.out.println(i);
//        }

//        1~10중에 홀수만 출력하기
//        for (int i=1; i<11; i++) {
//            if (i % 2 != 0) {
//                System.out.println(i);
//            }
//        }

//        1~20까지 짝수의 총합 출력하기
//        int total=0;
//        for(int i=1; i<21; i++) {
//            if(i%2 == 0) {
//                total += i;
//            }
//        }
//        System.out.println(total);

//        두수의 최대공약수 찾기
//        int a = 24;
//        int b = 36;
//
//        int min = a>b?b:a;

//        방법1)
//        int answer = 0;
//        for(int i=1; i<=min; i++) {
//            if (a%i == 0 && b%i == 0) {
//                answer = i;
//            }
//        }
//        System.out.println(answer);

//        방법2)
//        for(int i=min; i>=1; i--) {
//            if (a%i == 0 && b%i == 0) {
//                System.out.println(i);
//                break;
//            }
//        }

//        소수구하기 : 1과 자신을 제외한 숫자로 나누어지지 않는 수
//        사용자가 입력한 값이 소수인지 아닌지 판별해주는 프로그램
//        Scanner sc = new Scanner(System.in);
//        int input = sc.nextInt();
//        boolean check = false;
//
////        for (int i=2; i*i<=input; i++) {     //i*i : input이 900인 경우, 30보다 큰 경우는 연산불필요
//        for (int i=2; i<=Math.sqrt(input); i++) {    //Math.sqrt(input)
//            if (input % i == 0) {
//                check = true;
//                break;
//            }
//        }
//
//        if (!check) {   //check == false
//            System.out.println("소수입니다.");
//        } else {
//            System.out.println("소수가 아닙니다.");
//        }

////        continue : 반복문의 조건식으로 이동하는 명령어.
////        홀수만 출력
//        for(int i=1; i<11; i++) {
//            if(i%2 == 0) {
////                continue는 코드의 직관성과 가독성을 위해 사용
//                continue;               //짝수 넘겨
//            }
//                System.out.println(i);  //홀수 출력
//        }
//
////        향상된(enhanced) for문 - for each문
//        int[] arr = {1, 3, 5, 7};
////        일반for문을 활용한 배열 접근 방식
//        for(int i=0; i<arr.length; i++) {
//            System.out.println(arr[i]);
//        }
////        향상된for문을 활용한 배열 접근 방식
//        for(int a : arr) {
//            System.out.println(a);
//        }
////        일반for문을 통한 arr의 저장된 값 변경
//        for(int i=0; i<arr.length; i++) {
//            arr[i] += 10;
//        }
////        참조형변수(객체타입)는 기본적으로 변수를 통한 출력시에 메모리값이 출력
//        System.out.println(Arrays.toString(arr));
//
////        향상된for문을 통한 arr의 저장된 값 변경 -> 원본의 값 변경 불가
//        for(int a : arr) {
//            a += 10;
//        }
//        System.out.println(Arrays.toString(arr));

////        자바 변수의 유효범위 : {}
//        int num = 10;
//        if(true) {
//            num = 20;
//            int num2 = 20;
//        }
////        num2 = 30; //if문 중괄호 내에서 정의된 변수는 해당 중괄호 밖에서는 사용불가.
//        System.out.println(num);

////        다중 반복문
////        2~9단까지 한꺼번에 출력 + 각 단마다 몇단입니다. 출력
//        for(int i=2; i<10; i++) {
//            System.out.println(i + "단입니다.");
//            for(int j=1; j<10; j++) {
//                System.out.println(i + " * " + j + " = " + i*j);
//            }
//        }

//        100~200까지 수 중에서 가장 작은 소수를 출력
        //방법1
        for(int i=100; i<=200; i++) {
            boolean check = false;
            for(int j=2; j<=Math.sqrt(i); j++) {     //나눌 수는 1와 자기자신을 제외한다. 최대 i의 제곱근까지 확인한다. (왜? 중간값이상은 반복이므로) <=아닌지 확인
                if(i % j == 0) {
                    check = true;
                    break;
                }
            }
            if(!check) {
                System.out.println(i + " : 소수입니다.");
                break;
            }
        }
        //방법2
        loop:
        for (int i = 100; i <= 200; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    continue loop;      //continue도 라벨문 가능
                }
            }
            System.out.println(i);
        }
        //방법3
        loop1:
        for (int i = 100; i <= 200; i++) {
            loop2:
            for (int j = 2; j*j <= i; j++) {
                if (i%j==0){
                    continue loop1; // 소수가 아님. 다음 i로 넘어감.
                }
            }
            // 여기까지 왔다는 건 소수라는 뜻
            System.out.println(i);
            break; // 가장 처음 나온 소수니까 출력하고 종료
        }

////        라벨문 : 반복문에 이름을 붙이는 것
//        loop1:
//        for(int i=0; i<10; i++) {
//            loop2:
//            for(int j=0; j<10; j++) {
//                if(true) {
//                    break loop1; //원하는 for문을 라벨링을 통해 종료시킬 수 있음.
//                }
//            }
//        }

//        int[][] arr = {{1, 2, 3}, {4, 5, 11}, {7, 8, 9}, {10, 11, 12}};
//        System.out.println(arr[1][2]);  //1번째 배열에 2번째 값을 찾는 것
//        숫자 11이 위치한 배열의 index값(1,2 또는 3,1) 출력
//        가장 먼저 찾아지는 11의 위치만 출력
//        loop1:
//        for(int i=0; i<arr.length; i++) {
//            //방법1 - 라벨문방식
//            for(int j=0; j<arr[i].length; j++) {
//                if(arr[i][j] == 11) {
//                    System.out.println("위치는 " + i + ", " + j + "입니다.");
//                    break loop1;
//                }
//            }
//        }
//        //방법2 - boolean방식
//        boolean check = false;
//        for(int i=0; i<arr.length; i++) {
//            for(int j=0; j<arr[i].length; j++) {
//                if(arr[i][j] == 11) {
//                    check = true;
//                    System.out.println("위치는 " + i + ", " + j + "입니다.");
//                    break;
//                }
//            }
//            if(check) {
//                break;
//            }
//        }


    }
}











