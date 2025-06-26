package C07ExceptionFileParsing.MemberException;

import java.util.NoSuchElementException;
import java.util.Scanner;

//사용자의 입출력을 받아 처리하는 계층
public class MemberController {
    public static void main(String[] args) {
        MemberService memberService = new MemberService();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("1번: 회원가입, 2번: 회원상세조회, 3번: 회원목록조회, 4번: 로그인");
            String input = sc.nextLine();

            if(input.equals("1")) {
//                이름, 이메일, 패스워드 입력받아서 service에 전달
//                예외발생시 적절한 문구를 사용자에게 출력하세요. -> trycatch
                try {
                System.out.println("회원가입 서비스 입니다.");
                System.out.println("이름을 입력하세요.");
                String name = sc.nextLine();
                System.out.println("이메일을 입력하세요.");
                String email = sc.nextLine();
                System.out.println("패스워드를 입력하세요.");
                String password = sc.nextLine();
                //패스워드 너무 짧으면, 에러 던지기
                if(password.length() < 3) {
//                    방법1) -> 문제: 여기서 throw 던지면 사용자가 무슨 에러인지 출력되지 않음.
//                    throw new IllegalArgumentException("패스워드가 너무 짧습니다.");
//                    방법2)
                    System.out.println("비밀번호가 너무 짧습니다.");
                    continue;
                }
                    memberService.register(name, email, password);
                    System.out.println("현재 데이터: " + memberService.findAll());
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());     //Service에서 입력한 메시지가 출력됨.
                }
            } else if(input.equals("2")) {
//                회원정보 출력
//                적절한 예외처리 필요
                System.out.println("회원상세조회 서비스 입니다.");
                System.out.println("회원 id를 입력하세요.");
                Long id = Long.parseLong(sc.nextLine());

                try {
                    Member member = memberService.findById(id);
                    System.out.println(member);
                } catch (NoSuchElementException e) {
                    System.out.println(e.getMessage());
                }

            } else if(input.equals("3")) {
                System.out.println("회원목록조회 서비스 입니다.");

//                System.out.println(memberService.findAll());  //⭐틀림 :  Member 객체의 toString이 아니라 List의 toString + 객체의 해시코드가 출력
                for(Member m : memberService.findAll()) {
                    System.out.println(m);
                }
            } else if(input.equals("4")) {
                System.out.println("이메일을 입력하세요.");
                String email = sc.nextLine();
                System.out.println("패스워드를 입력하세요.");
                String password = sc.nextLine();
                try {
                    memberService.login(email, password);
                    System.out.println("로그인 성공입니다.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
