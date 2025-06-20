package C02ClassBasic;

import java.util.ArrayList;
import java.util.List;

//조합(combination)과 순열(permutation) -> 거의 재귀로 품.
//주로 백트래킹 알고리즘 상황에서 사용
public class C13RecursiveCombiPermu {
    public static void main(String[] args) {
////      2중 for문을 활용하여 helloworld1 helloworld2 ... helloworldn 출력
//        int total = 0;
//        for(int i=0; i<3; i++)  {
//            for(int j=0; j<3; j++) {
//                System.out.println("hello world " + total);
//                total++;
//            }
//        }

////      위 for문의 반복횟수는 동적으로 결정되지 않고, 정적으로 코딩할수밖에 없는 한계가 존재.
//        forRecur(0, 2);

//        재귀함수 예제 : 조합
        List<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);

////        숫자 1,2,3,4를 가지고 만들 수 있는 2개짜리 숫자조합을 이중리스트에 담아 출력
////        방법 1. 그냥 for문
////        [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
        List<List<Integer>> doubleList = new ArrayList<>();

//        for (int i=0; i<myList.size(); i++) {
//            for(int j=i+1; j<myList.size(); j++) {
//                List<Integer> temp = new ArrayList<>();
//                temp.add(myList.get(i));
//                temp.add(myList.get(j));
//                doubleList.add(temp);
//            }
//        }
//        System.out.println(doubleList);

////        재귀함수를 만들기 위한 for문 변형
////        방법 2. 재귀만들기 위해 for문을 비슷하게 변형
//        List<Integer> temp = new ArrayList<>();   //temp 매번 새로생성하지 않고, 최초생성하고 add후 마지막 자리만 반복 remove.
//        for (int i=0; i<myList.size(); i++) {
//            temp.add(myList.get(i));
//            for(int j=i+1; j<myList.size(); j++) {
//                temp.add(myList.get(j));
//                doubleList.add(new ArrayList<>(temp));        //⭐doubleList.add(temp) 아님 -> 주소값이 동일하므로 -1하면 전체삭제됨, temp 넣을때마다 새로운 객체 생성 -> 백트래킹
//                temp.remove(temp.size()-1);
//            }
//            temp.remove(temp.size()-1);
//        }
//        System.out.println(doubleList);

////        방법 3. 재귀
        combi(원본, 임시, 결과, target?, 방문여부?);
        System.out.println(doubleList);

//        combi(myList, new ArrayList<>(),doubleList, 2, 0);    //⭐빈 list 던지기
//        System.out.println(doubleList);

////        1,2,3,4를 n개씩 뽑은 순열구하기
////        [[1,2], [1,3], [1,4], [2,1], [2,3] ...[4,3]]
//        permu(myList, new ArrayList<>(), doubleList, 2, new boolean[myList.size()]);
//        System.out.println(doubleList);

    }

//                        원본                 임시리스트                     결과                  목표개수:n       방문여부
    static void permu(List<Integer> myList, List<Integer> temp, List<List<Integer>> doubleList, int target, boolean[] visited) {
        if(temp.size() == target) {
            doubleList.add(new ArrayList<>(temp));  //⭐temp아니고 new ArrayList<>(temp) 주의.
            return;
        }
        for(int i=0; i<myList.size(); i++) {
            if(!visited[i]) {   //⭐temp[a,b]에서 a가 이미 방문했던 숫자인지 확인
                visited[i] = true;  //방문했어용
                temp.add(myList.get(i));    //원본 temp에 add
                permu(myList, temp, doubleList, target, visited);
                temp.remove(temp.size()-1); //temp의 마지막자리 삭제
                visited[i] = false;   //방문리셋
            }
        }
    }

    static void combi()


//    //                       원본                 임시리스트                   결과                  목표개수:n    시작점
//    static void combi(List<Integer> myList, List<Integer> temp, List<List<Integer>> doubleList, int target, int start) {
//        if(temp.size() == target) {
//            doubleList.add(new ArrayList<>(temp));  //⭐new ArrayList<>() 주의
//            return;
//        }
//        for(int i=start; i<myList.size(); i++) {  //⭐start는 중복없이조합 만들기 위함.
//            temp.add(myList.get(i));
//            combi(myList, temp, doubleList, target, i+1);   //start+1 아니고 i+1임 주의! -> start가 0이므로 계속 1만 나옴.
//            temp.remove(temp.size()-1);
//        }
//    }


//    static int staticCount = 0;
////                           0           2
//    static void forRecur(int num, int target) {         // 함수2번
//        if(num==target) {
//            System.out.println("hello world " + staticCount);          // 총 9번
//            staticCount++;
//            return;
//        }
//        for(int i=0; i<3; i++) {                        // for문3번
////            System.out.println("hello world " + staticCount);          // 총 12번
//            forRecur(num+1, target);
//        }
//    }


//    과제 1. 클래스, 객체 2. 재귀 및 백트래킹(코드암기 및 문제풀이)
//    어려우면 선암기 -> 후이해
//    백준 : 15649 - N과 M
//    백준 : 6603 - 로또

}
