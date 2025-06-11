package C01Basic;

import java.util.Scanner;

public class C04IfStatement {
    public static void main(String[] args) {
//    도어락키 예제
//        int answer = 1234;
//        Scanner sc = new Scanner(System.in);
//        int input = sc.nextInt();
//
//        if(answer == input) {
//            System.out.println("문이 열렸습니다.");
//        } else {
//            System.out.println("비밀번호가 틀렸습니다.");
//        }

//        교통카드 예제
//        현재 가지고 있는 돈은 얼마인지 물어봐서 입력값을 받는다.
//        10000원이상이면 택시를 타시오
//        10000미만~3000원이상이면 버스를 타시오
//        그렇지 않으면 걸어가라고 출력
//        System.out.println("현재 얼마 가지고 있습니까?");
//        Scanner sc = new Scanner(System.in);
//        int myMoney = Integer.parseInt(sc.nextLine());
//        if, else if 구문에서 조건식은 택1로서, 한 조건에 해당하면 실행후 구분밖으로 빠져나감.
//        if (myMoney >= 10000) {
//            System.out.println("택시를 타시오");
//        } else if (myMoney >= 3000) {
//            System.out.println("버스를 타시오");
//        } else {
//            System.out.println("걸어가시오");
//        }
//        if문이 독립적으로 존재할 경우에는 정확한 범위지정을 하지 않으면 모든 if문이 중복되어 실행될 가능성이 존재
//        if (myMoney >= 10000) {
//            System.out.println("택시를 타시오");
//        }
//        if (myMoney >= 3000 && myMoney < 10000) {
//            System.out.println("버스를 타시오");
//        }
//        if (myMoney < 3000) {
//            System.out.println("걸어가시오");
//        }

//        삼항연산자 : 결과값=조건식?반환값1:반환값2
//        조건식이 참인경우 반환값1이 결과값에 담기고, 거짓인경우 반환값2가 결과값에 담김.
//        int answer = 1234;
//        Scanner sc = new Scanner(System.in);
//        int input = sc.nextInt();
//        String result = (answer == input)?"문이 열렸습니다.":"비밀번호가 틀렸습니다.";
//        System.out.println(result);

//        switch문 : if, else if, else 등 여러 조건식이 있을때 조건문을 가독성있게 표현한 구문
//        원하시는 서비스 번호를 입력해주세요.
//        1:대출업무입니다. 2:예금업무입니다. 3:적금업무입니다. 0:상담사연결됩니다. 그외:잘못된입력입니다.

        System.out.println("원하시는 서비스 번호를 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        switch (input) {
            case 1:
                System.out.println("대출업무입니다.");
                break;
            case 2:
                System.out.println("예금업무입니다.");
                break;
            case 3:
                System.out.println("적금업무입니다.");
                break;
            case 0:
                System.out.println("상담사연결됩니다.");
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                break;
        }

    }
}
