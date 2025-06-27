package C07ExceptionFileParsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.PipedInputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//복습 X
public class C04HttpJasonParsing {
    public static void main(String[] args) throws IOException, InterruptedException {
//        외부데이터(api) 요청 : 서버간의 통신
//        RestTemplate, RestClient : 스프링에서 가장 많이 사용하는 라이브러리
//        ⭐HttpClient는 자바의 내장클래스로서 별도의 역직렬화, 직렬화 작업이 필요
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String postString = response.body();
//        System.out.println(postString);

        //⭐ObejecrMapper가 객체 파싱시 필요한것 : 기본생성자(추가생성자 생성시에만 생성), getter
        ObjectMapper o1 = new ObjectMapper();
        JsonNode jasonNodes2 = o1.readTree(postString);
        List<Post> postList = new ArrayList<>();
        for(JsonNode j : jasonNodes2) {
            Post p1 = o1.readValue(j.toString(), Post.class);
            postList.add(p1);
        }
        System.out.println(postList);



    }
}
//뭘해야하는지.....?
class Post {
    private Long userId;
    private Long id;
    private String title;
    private String body;

//    public Post() {
//
//    }

    public Long getUserId() {
        return userId;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Post{" + "userId=" + userId + ", id=" + id + ", title='" + title + '\'' + ", body='" + body + '\'' + '}';
    }
}
