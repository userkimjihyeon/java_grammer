package C07ExceptionFileParsing.MemberException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//저장소역할을 하는 계층
//DB에 CRUD를 수행하는 계층
public class MemberRepository {
    private static List<Member> memberList = new ArrayList<>();      //db역할. static 클래스 변수 -> 프로그램 실행시 초기화

//    회원가입
    public void register(Member member) {
        memberList.add(member);
    }

//    ⭐회원상세조회
    public Optional<Member> findById(Long id) {     //id가 있을수도있고 없을수도있음 -> optional
//        방법1)
        Member member = null;
        for(Member m : memberList) {
            if(m.getId().equals(id)) {
                member=m;
            }
        }
        return Optional.ofNullable(member);
//        방법2) ⭐Stream
//        return memberList.stream().filter(a -> a.getId()==(id)).findFirst();
    }
    public Optional<Member> findByEmail(String email) {     //⭐id가 중복인지 확인하기 위해 email 찾을 메서드
        return memberList.stream().filter(a -> a.getEmail().equals(email)).findFirst();
    }

//    회원목록조회
    public List<Member> findAll() {
        return memberList;
    }
}
