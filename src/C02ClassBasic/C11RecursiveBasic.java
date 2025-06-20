package C02ClassBasic;

import java.util.ArrayList;
import java.util.List;

public class C11RecursiveBasic {
    public static void main(String[] args) {
//        recur0(0, 3);
//        recur1(0, 3);
        recur2(new ArrayList<>(), 0,3);
    }

    public static void recur0(int count, int target) {
        if(count==target) {
            return;
        }
        System.out.println("재귀 호출 전 count : " + count);     //0(첫번째) -> 1(두번째) -> 2(세번째)
        recur0(count+1, target);
        System.out.println("재귀 호출 후 count : " + count);     //0(여섯번째) -> 1(다섯번째) -> 2(네번째)
    }

//    아래함수 출력순서 전c:0 -> 전c:1 -> 전c:2 -> 후c:3 -> 후c:2 -> 후c:1
    public static void recur1(int count, int target) {
        if(count==target) {
            return;
        }
        System.out.println("재귀 호출 전 count : " + count);
        count = count + 1;
        recur1(count, target);
        System.out.println("재귀 호출 후 count : " + count);
    }

//    객체를 매개변수로 활용한 재귀함수 : 객체는 힙메모리를 통해 원본객체가 변경될 수 있으므로, 재귀함수간에 값이 일치되는 현상.
    public static void recur2(List<Integer> myList, int num, int target) {
        if(myList.size()==target) {
            return;
        }
        myList.add(num);
        recur2(myList, num+1, target);
        System.out.println(myList);    // {0, 1, 2}가 총 3번출력
        //백트래킹 : list는 참조변수이므로 add할때마다 각각의 함수호출시 동시에 값이 add됨.
    }
}
