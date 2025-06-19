package C02ClassBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class C10BoardService {
    public static void main(String[] args) throws IOException {
//        1.회원가입 : 이름, 이메일, 비밀번호, id값(auto_increment)
//        2.회원 전체 목록 조회 : id, email
//        3.회원 상세 조회(id로 조회) : id, email, name, password, ⭐작성글수(가능한사람만-글작성시마다 Author객체에 postlist를 넣어서 Post객체와 함께 둘다 +1)
//        4.게시글 작성 : id, 제목, 내용, ⭐작성자Email(Author객체가능)
//        5.게시물 목록 조회 : id(post), title
//        6.게시물 상세 조회(id로 조회) : id(post), title, contents, ⭐작성자email(작성자이름조회(할수있는사람만) - post객체 안에 author가 들어가야한다.)
//        7.서비스 종료
        //회원가입 -> a1객체생성. 안에 자기가쓴글에 대한 post객체도 가지고 있음.
        //글쓰기 ->  p1객체생성

        //객체 생성
        List<Author> authorList = new ArrayList<>();
        List<Post> postList = new ArrayList<>();

        while(true) {
            //게시판 번호 입력받기
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("원하는 게시판 번호를 입력하세요");
            int input = Integer.parseInt(br.readLine());

            switch (input) {
                case 1 :    //1.회원가입 : 이름, 이메일, 비밀번호, id값(auto_increment)
                    System.out.println("가입하실 회원의 이름을 입력하세요");
                    String name = br.readLine();
                    System.out.println("가입하실 회원의 이메일을 입력하세요");
                    String email = br.readLine();
                    System.out.println("가입하실 회원의 비밀번호를 입력하세요");
                    String password = br.readLine();

                    authorList.add(new Author(name, email, password));

                    System.out.println("가입 되었습니다.");
                    break;
                case 2 :    //2.회원 전체 목록 조회 : id, email
                    System.out.println("전체 회원목록을 조회합니다.");

                    //List<Author>에서 각 Author객체를 반복하면서 조회
                    for(Author a : authorList) {
                        System.out.println("id: " + a.getId() + " name: " + a.getName() + " email: " + a.getEmail() + " password: " + a.getPassword());
                    }
                    break;
                case 3 :    //3.회원 상세 조회(id로 조회) : id, email, name, password, ⭐작성글수(List<Author> / 가능한사람만-글작성시마다 Author객체에 postlist를 넣어서 Post객체와 함께 둘다 +1)
                    System.out.println("조회할 회원id를 입력하세요.");
                    int id = Integer.parseInt(br.readLine());

                    for(Author a : authorList) {
                        if (a == null) {
                            System.out.println("존재하지 않는 id입니다.");
                        } else {
                            System.out.println("id: " + a.getId() + " name: " + a.getName() + " email: " + a.getEmail() + " password: " + a.getPassword());
                            //작성글수조회
                            System.out.println("작성글 수 : " + a.getPostlist());
                        }
                    }
                    break;
                case 4 :    //4.게시글 작성 : id, 제목, 내용, ⭐작성자Email(Author객체가능)
                    System.out.println("작성할 게시글의 제목을 입력하세요.");
                    String title = br.readLine();
                    System.out.println("작성할 게시글의 내용을 입력하세요.");
                    String contents = br.readLine();
                    System.out.println("작성자 이메일을 입력하세요.");
                    String authorEmail = br.readLine();

                    for(Author a : authorList) {
                        if(authorEmail.equals(a.getEmail())) {
                            postList.add(new Post(title, contents, authorEmail));

                            //author객체의 postlist++하기
                            a.increasePostCount();
                        }
                    }

                    System.out.println("등록 되었습니다.");
                    break;
                case 5 :    //5.게시물 목록 조회 : id(post), title
                    System.out.println("전체 게시글을 조회합니다.");

                    //List<Post>에서 각 Post객체를 반복하면서 조회
                    for(Post p : postList) {
                        System.out.println("id: " + p.getId() + " title: " + p.getTitle());
                    }
                    break;
                case 6 :    //6.게시물 상세 조회(id로 조회) : id(post), title, contents, ⭐작성자email(작성자이름조회(할수있는사람만) - post객체 안에 author가 들어가야한다.)
                    System.out.println("게시글을 조회할 id를 입력하세요");
                    int postId = Integer.parseInt(br.readLine());

                    for(Post p : postList) {
                        if(postId == p.getId()) {
                            System.out.println("Id: " + p.getId() + " Title: " + p.getTitle() + " Contents: " + p.getContents() + "작성자 email : " + p.getAuthorEmail());
                        } else {
                            System.out.println("일치하는 게시글이 없습니다.");
                        }
                    }
                    break;
                case 7 :    //7.서비스 종료
                    System.out.println("서비스를 종료합니다.");
                    return;
            }
        }
    }
}


class Author {
    //필드
    public static int auto_authorId;
    private int id;
    private String name;
    private String email;
    private String password;
    private int postList;

    //생성자
    public Author(String name, String email, String password) {
        this.id = auto_authorId++;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
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

    public int getPostlist() {
        return postList;
    }

    public void increasePostCount() {
        this.postList++;
    }

}


class Post {
    //필드
    public static int auto_postId;
    private int id;
    private String title;
    private String contents;
    private String authorEmail;  //⭐

    //생성자
    public Post(String title, String contents, String authorEmail) {
        this.id = auto_postId++;
        this.title = title;
        this.contents = contents;
        this.authorEmail = authorEmail;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }
}