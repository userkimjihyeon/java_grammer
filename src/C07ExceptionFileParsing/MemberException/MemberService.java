package C07ExceptionFileParsing.MemberException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

//핵심로직을 구현하는 계층
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService() {
        this.memberRepository = new MemberRepository();     //생성자 호출시 repo초기화 -> MemberService가 만들어진 경우에만 repo생성하기 위해
    }

//    회원가입
    public void register(String name, String email, String password) throws IllegalArgumentException{
//        ⭐이메일이 중복일 경우 예외 발생
        if (memberRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 email입니다.");
        }
//        객체를 조립후 repository를 통해 register
//        Member member = new Member(name, email, password);
//        memberRepository.register(member);
        memberRepository.register(new Member(name, email, password));
    }

//    회원상세조회
    public Member findById(Long id) throws NoSuchElementException {
//        ⭐Optional객체에 값이 없을 경우 예외발생. 있으면 Member를 꺼내서 return.
//                              Optional객체/     값이 없으면              예외던지기 (값이 있으면 그 값 리턴)
        return memberRepository.findById(id).orElseThrow(() -> new NoSuchElementException("존재하지 않는 id입니다."));   //Member 리턴
    }

//    회원목록조회
    public List<Member> findAll() {
        //repo조회 -> 리턴??
        return memberRepository.findAll();
    }

//    로그인
    public void login(String email, String password) throws NoSuchElementException, IllegalArgumentException {
        Optional<Member> optionalMember = memberRepository.findByEmail(email);
        if(!optionalMember.isPresent()) {
            throw new NoSuchElementException("존재하지 않는 이메일입니다.");
        }
        if(!optionalMember.get().getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
        }
    }
}
