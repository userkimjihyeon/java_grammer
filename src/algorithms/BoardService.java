package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardService {
    public static void main(String[] args) {
//        1.회원가입 : 이름, 이메일, 비밀번호, id값(auto_increment)
//        2.회원 전체 목록 조회 : id, email
//        3.회원 상세 조회(id로 조회) : id, email, name, password, 작성글수(List<Author>)
//        4.게시글 작성(회원-email입력) : id, title, contents, 작성자Email(Author객체가능)
//        5.게시물 목록 조회 : id(post), title
//        6.게시물 상세 조회(id로 조회) : id, title, contents, 작성자email(작성자이름)
//        7.서비스 종료
        Scanner sc = new Scanner(System.in);

        //⭐List<class객체> 생성
        List<Author> authorList = new ArrayList<>();
        List<Post> postList = new ArrayList<>();

        while(true) {
            System.out.println("서비스번호를 입력하세요.");
            int serviceNumber = Integer.parseInt(sc.nextLine());

            if(serviceNumber == 1) {
                System.out.println("회원가입서비스입니다.");
                System.out.println("이름을 입력하세요.");
                String name = sc.nextLine();
                System.out.println("이메일을 입력하세요.");
                String email = sc.nextLine();
                System.out.println("비밀번호를 입력하세요.");
                String password = sc.nextLine();

                Author author = new Author(name, email, password);  //⭐Author클래스 객체 생성
                authorList.add(author);
            } else if (serviceNumber == 2) {
                System.out.println("전체회원 목록조회 서비스입니다.");
                for(Author a : authorList) {
                    System.out.println(a);
                }
            } else if (serviceNumber == 3) {
                System.out.println("회원 상세조회 서비스입니다.");
                System.out.println("조회할 회원id를 입력하세요.");
                Long authorId = Long.parseLong(sc.nextLine());
                Author author = null;   //⭐author를 null로 초기화
                boolean found = false;
                for(Author a : authorList) {
                    if(authorId.equals(a.getId())) {
                        author = a;     //⭐author에 a넣기
                        found = true;
                        break;
                    }
                }
                if(!found) {
                    System.out.println("존재하지않는 회원입니다.");
                    continue;
                }
                System.out.println(author.getName() + author.getEmail() + author.getPostList().size());    //⭐회원별 작성글개수 조회 : author.getPostList().size()
            } else if (serviceNumber == 4) {    //4.게시글 작성(회원-email입력) : id, title, contents, 작성자Email(Author객체가능)
                System.out.println("게시글작성 서비스입니다.");
                System.out.println("글제목 입력하세요.");
                String title = sc.nextLine();
                System.out.println("글내용 입력하세요.");
                String contents = sc.nextLine();
                System.out.println("작성자 email 입력하세요.");
                String authorEmail = sc.nextLine();

                boolean found = false;
                for(Author a : authorList) {
                    if(authorEmail.equals(a.getEmail())) {
                        Post post = new Post(title, contents, a);
                        postList.add(post);
                        found = true;
                        System.out.println("작성 되었습니다.");
                        break;
                    }
                }
                if(!found) {
                    System.out.println("존재하지않는 회원입니다.");
                }
            } else if (serviceNumber == 5) {
                System.out.println("게시물 목록조회 서비스입니다.");
                for(Post p : postList) {
                    System.out.println(p);
                }
            } else if (serviceNumber == 6) {
                System.out.println("게시물 상세조회 서비스입니다.");
                System.out.println("조회하실 게시물 id를 입력하세요.");
                Long postId = Long.parseLong(sc.nextLine());
                Post post = null;
                boolean found = false;
                for(Post p : postList) {
                    if(postId.equals(p.getId())) {
                        post = p;
                        found = true;
                        break;
                    }
                }
                if(!found) {
                    System.out.println("해당 게시물 id가 존재하지 않습니다.");
                    continue;
                }
                System.out.println(post.getTitle() + post.getContents() + post.getAuthor().getEmail());     //⭐Post -> Author 참조하므로, post.getAuthor().getEmail() 사용가능
            } else if (serviceNumber == 7) {
                System.out.println("서비스를 종료합니다.");
                return;
            } else {
                System.out.println("잘못된 서비스번호를 입력하셨습니다.");
            }
        }
    }
}
class Author {
    //필드
    private static Long static_id=0L;
    private Long id;
    private String name;
    private String email;
    private String password;
    private List<Post> postList;    //⭐⭐⭐Author -> List<Post3>를 통한 다수 참조. Author클래스 객체에 List<Post>객체를 생성해서, 회원별 작성글개수 조회

    //생성자
    public Author(String name, String email, String password) {
        this.id = static_id++;
        this.name = name;
        this.email = email;
        this.password = password;
        this.postList = new ArrayList<>();  //⭐Author클래스 객체 생성시, 새로운 List<Post> 객체생성 -> 회원별 작성글 조회 가능.
    }

    //메서드
    public Long getStatic_id() {
        return static_id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Post> getPostList() {
        return postList;
    }

    @Override
    public String toString() {
        return "Author3{" +
                "static_id=" + static_id +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", postCount=" + postList.size() +      //⭐회원별 작성글 개수 조회
                '}';
    }
}
class Post {
    //필드
    private static Long staticId = 0L;
    private Long id;
    private String title;
    private String contents;
    private Author author;      //⭐⭐⭐Post -> Author는 단일 참조

    //생성자
    public Post(String title, String contents, Author author) {
        this.id = staticId++;
        this.title = title;
        this.contents = contents;
        this.author = author;       //⭐가져온 author객체를 Post클래스 객체 내부의 Author클래스 변수 author에 저장
        this.author.getPostList().add(this);    //⭐Author -> Post 참조 -> 글작성시마다 Author클래스의 객체에 Post클래스의 객체를 저장
    }

    //메서드
    public Long getStaticId() {
        return staticId;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Post3{" +
                "staticId=" + staticId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", authorEmail=" + author.getEmail() +
                '}';
    }
}