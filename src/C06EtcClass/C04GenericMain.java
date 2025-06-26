package C06EtcClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

//<> : 제네릭
public class C04GenericMain {
    public static void main(String[] args) {
        String[] stArr = {"java", "python", "C"};
        stChange(stArr, 0, 1);
        System.out.println(Arrays.toString(stArr)); //자리가 체인지된 객체 출력

        Integer[] intArr = {10,20,30};  //int[]는 제네릭메서드 사용불가
        intChane(intArr, 0, 1);
        System.out.println(Arrays.toString(intArr)); //자리가 체인지된 객체 출력

//        T[]는 어떤타입이든 올 수 있음.
        allChange(stArr, 0, 1);
        allChange(intArr, 0, 1);



//        일반객체 생성시
        Person p1 = new Person("hongildong");
        GenericPerson<Integer> p2 = new GenericPerson<>(10);

//        제네릭의 사용 예시
        List<String> myList = new ArrayList<>();    //ArrayList,Stream,Optional 클래스등이 제네릭으로 설계되어있다.
        Stream<String> myStream;
        Optional<Student> studentOptional;

        }

//    ⭐제네릭메서드는 반환타입 왼쪽에 <T>라고 선언
//    ⭐이때 T에는 참조형변수인 객체타입만을 허용
    static <T> void allChange(T[] arr, int a , int b) {
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    static void stChange(String[] arr, int a, int b) {
        String temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    };
    static void intChane(Integer[] arr, int a, int b) {
        Integer temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    };
}



class Person {
    private String value;

    public Person(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setName(String value) {
        this.value = value;
    }

}
//⭐제네릭 클래스는 클래스명 옆에 <T>선언
class GenericPerson<T> {
    private T value;

    public GenericPerson(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setName(T value) {
        this.value = value;
    }

}