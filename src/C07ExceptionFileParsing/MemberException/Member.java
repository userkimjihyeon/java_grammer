package C07ExceptionFileParsing.MemberException;

//엔티티 : 핵심 객체 요소
public class Member {
    private static Long staticId=0L;
    private Long id;
    private String name;
    private String email;
    private String password;

    public Member(String name, String email, String password) {
        this.id = staticId++;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Member{" + "id=" + id + ", email='" + email + '\'' + ", password='" + password + '\'' + '}';
    }
}
