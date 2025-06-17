package C01Basic;

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class C10Set {
public static void main(String[] args) throws IOException {
////       ⭐중복X, 순서보장X(index못씀)
//        Set<String> mySet = new HashSet<>();
//        mySet.add("h");
//        mySet.add("e");
//        mySet.add("l");
//        mySet.add("l");
//        mySet.add("o");
//        System.out.println(mySet);

////        ⭐백준 : 숫자카드
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//            br.readLine();
//            String[] arr1 = br.readLine().split(" ");
//            br.readLine();
//            String[] arr2 = br.readLine().split(" ");
//
//            Set<String> set1 = new HashSet<>();   //상근이 숫자카드 set에 담기
//            for(String a : arr1) {
//                set1.add(a);
//            }
//
//            StringBuilder sb = new StringBuilder();
//            for(String a : arr2) {                //비교할 숫자카드로 반복문 -> 상근카드가 contains하는지 확인
//                if(set1.contains(a)) {
//                    sb.append("1 ");
//                } else {
//                    sb.append("0 ");
//                }
//            }
//            sb.deleteCharAt(sb.length()-1);       //맨뒤 공백 삭제
//            System.out.println(sb);

////        ⭐프로그래머스 : 폰켓몬
//        int[] nums = {3, 1, 2, 3};
//
//        class Solution {
//            public int solution(int[] nums) {
//                int answer = 0;
//
//                //set에 중복제거해서 넣기
//                Set<Integer> set = new HashSet<>();
//                for(int a : nums) {
//                    set.add(a);
//                }
//
//                //중복제거한개수가 총개수/2보다 ⭐크거나 같으면⭐ -> 총개수/2 출력
//                if (set.size() >= nums.length / 2) {
//                    answer = nums.length/2;
//                } else {
//                    //작으면 set.size() 출력
//                    answer = set.size();
//                }
//                return answer;
//            }
//        }
//        Solution sol = new Solution();
//        int result = sol.solution(nums);
//        System.out.println(result);

////        ⭐LinkedHashSet : 입력순서 보장
//        Set<Integer> linkedSet = new LinkedHashSet<>();
//        linkedSet.add(1);
//        linkedSet.add(1);
//        linkedSet.add(0);
//        linkedSet.add(3);
//        linkedSet.add(1);
//        System.out.println(linkedSet);   //[1, 0, 3]
//
////        ⭐TreeSet : 데이터를 오름차순 정렬
//        Set<Integer> treeSet = new TreeSet<>();
//        treeSet.add(1);
//        treeSet.add(1);
//        treeSet.add(0);
//        treeSet.add(3);
//        treeSet.add(1);
//        System.out.println(treeSet);    //[0, 1, 3]


////        집합관련함수 : 교집합(retainAll), 합집합(addAll), 차집합(removeAll)
//        Set<String> set1 = new HashSet<>();
//        set1.add("java");
//        set1.add("python");
//        set1.add("C++");
//        Set<String> set2 = new HashSet<>();
//        set2.add("java");
//        set2.add("html");
//        set2.add("css");
//        set1.retainAll(set2);     //set1에는 java만 남음
//        System.out.println(set1);
//        set1.addAll(set2);        //[python, C++, css, java, html]
//        System.out.println(set1);
//        set1.removeAll(set2);
//        System.out.println(set1); //[python, C++]

    }
}
