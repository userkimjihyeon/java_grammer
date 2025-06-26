package C07ExceptionFileParsing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Scanner;

//Controller : 사용자의 입출력 => 예외처리후 사용자에게 적절한 메시지 전달
//Service : 핵심로직처리 => 예외강제발생
public class C01Exception {
    public static void main(String[] args) {
////        일반적인 예외처리 방식 : 예외가 발생시에 프로그램이 중지되지 않도록 하는 프로그래밍.
//        System.out.println("나눗셈 프로그램입니다.");
//        Scanner sc = new Scanner(System.in);
////        예외가 발생할 것으로 예상되는 코드를 try로 감싼다.
//        try {
//            System.out.println("분자를 입력해주세요.");
//            int head = Integer.parseInt(sc.nextLine()); //여기서 NumberFormatException 예외발생시 try내부의 하단의 코드는 실행되지 않음.
//            System.out.println("분모를 입력해주세요.");
//            int tail = Integer.parseInt(sc.nextLine());
//            int result = head/tail;                     //여기서 ArithmeticException 예외발생시 try내부의 하단의 코드는 실행되지 않음.
//            System.out.println("두 수를 나눈 결과 값은 : " + result);
////        catch를 통해 예상되는 예외클래스를 분기처리한다.
//        } catch (ArithmeticException e) {
//            System.out.println("0으로 나누시면 안됩니다.");
////            아래와 같은 방식으로 시스템 로그를 기록.
//            e.printStackTrace();                //일반적인 로그 찍기
//            System.out.println(e.getMessage()); //메시지만 간략히 출력
//        } catch (NumberFormatException e) {
//            System.out.println("문자를 입력하시면 안됩니다.");
//            e.printStackTrace();
//            System.out.println(e.getMessage());
////            Exception은 모든 예외의 조상 클래스
//        } catch (Exception e) {
//            System.out.println("예상치못한 에러가 발생했습니다.");
//            e.printStackTrace();
//            System.out.println(e.getMessage());
//        } finally {
////            예외가 발생하든 하지 않든 무조건 실행되는 구문.
//            System.out.println("무조건 실행되는 문구 입니다.");
//        }

////        의도된 예외 강제 발생 : 특정 시점에 프로그램을 강제 중지.
//        System.out.println("로그인을 위한 비밀번호를 입력해주세요.");
//        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine();
////        login(input);                       //⭐호출한곳 -> 예외가 여기로 전파됨. 아래 코드는 실행되지 않음.
//        System.out.println("환영합니다.");

        String result = null;
//        checked exception의 경우
//        1)호출받는 쪽에서 예외처리 후 unchecked exception 예외발생. 호출하는쪽에서 예외처리하여 사용자에게 적절한 message 전달.
        try {
            result = fileRead("src/C07ExceptionFileParsing/test.txt");      //경로가 잘못될 경우를 trycatch로 잡음.
        } catch (RuntimeException e) {
            System.out.println(e.getMessage()); //사용자 확인용
            e.printStackTrace();                //개발자 확인용
        }
////        2)throws를 통해서 예외처리를 위임받게되면, 호출하는 쪽에서 예외처리
//        try {
//            result = fileRead("src/C07ExceptionFileParsing/test.txt");
//        } catch (IOException e) {
//            throw new RuntimeException("입출력 과정에서 예외가 발생했습니다.");
//        }

        System.out.println(result);

    }

////    throws 키워드를 통해 예외를 위임.
////    다만, Unchecked예외에서는 예외처리가 강제가 아니므로, throws가 큰 의미는 없음. (서버, DB 관련 예외 제외한 모든 예외) -> ⭐롤백처리됨.
////    그러나, Checked예외에서는 예외처리가 강제되므로, throws가 의미가 있음.
////    1. Unchecked 예외
//    static boolean login(String password) throws IllegalArgumentException, NoSuchElementException { //Unchecked에서는 throws키워드는 장식임..
//        if(password.equals("1234")) {
//            return true;
//        } else if(password==null) {
////            ⭐예외를 강제 발생시킴으로써 이 시점에서 해당메서드 강제 종료.
////            예외는 기본적으로 해당 메서드를 호출한 쪽으로 전파된다.
//            throw new IllegalArgumentException("비밀번호를 잘못 입력하였습니다.");
//        } else {
//            throw new NoSuchElementException("존재하지 않는 비밀번호입니다.");
//        }
//    }

    static String fileRead(String path) throws RuntimeException {   //방법1. 이때는 throws가 장식임.
//    static String fileRead(String path) throws IOException {      //방법2.
        Path filePath = Paths.get(path);
        String text = null;
//        ⭐Checked Exception의 경우 예외처리가 강제
//        방법1. checked예외를 try-catch한 이후에 unchecked예외를 다시 throw  ->주로 사용하는 방법
        try {
            text = Files.readString(filePath);
        } catch (IOException e) {
//            1. System.out.println("입출력 과정에서 예외가 발생했습니다.");
//            2. 보통은 코드중지 목적으로 unchecked exception을 다시 throw.
            throw new RuntimeException("입출력 과정에서 예외가 발생했습니다.");
        }
////        방법2. 현재 메서드를 호출하는 쪽으로 예외를 위임(throws).
//        text = Files.readString(filePath);

        return text;
    }

}
