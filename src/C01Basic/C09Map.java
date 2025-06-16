package C01Basic;

import javax.imageio.ImageTranscoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C09Map {
    public static void main(String[] args) throws IOException {
////       key, value로 이루어진 자료구조
////       key값은 중복이 있으면 value를 덮어쓰기
//        Map<String, Integer> sports = new HashMap<>();
//        sports.put("농구", 2);
//        sports.put("배구", 1);
////        ⭐map은 key를 통해 value를 get
////        map에서 key값을 통한 검색복잡도는 O(1)
//        System.out.println(sports.get("농구"));
//        System.out.println(sports.get("배구"));
//
////        ⭐⭐map의 전체데이터 출력
////        map의 key값 접근시에 인덱스 사용 불가(순서가 없음)
////        keySet() : map의 key목록을 리턴
////        values() : map의 value목록을 리턴
//        int total = 0;
//        for(int v : sports.values()) {
//            total += v;
//            System.out.println(v);
//        }
//        int total2 = 0;
//        for(String k : sports.keySet()) {
//            total2 += sports.get(k);
//            System.out.println(k);
//        }
//
////        remove : key를 통해 map요소 삭제
//        sports.remove("농구");
//        System.out.println(sports);
//
////        map에서 기존의 key값에 put할 경우 덮어쓰기
//        sports.put("배구", 10);
//        System.out.println(sports);

//        Map<String, String> sports = new HashMap<>();
//        sports.put("soccer", "축구");
//        sports.put("baseball", "야구");
//        sports.put("basketball", "농구");
////        putIfAbsent : key값이 없는 경우에 put
//        sports.putIfAbsent("soccer", "운동");   //key값이 있으므로 실행X
//        sports.putIfAbsent("tennis", "테니스");
//        System.out.println(sports);
//
////        ⭐containsKey : 키가 있으면 true, 없으면 false
//        System.out.println(sports.containsKey("tennis"));
//        System.out.println(sports.containsKey("pingpong"));
//
////        ⭐⭐map출력방법2가지 : 1.foreach문 2.iterator
////        1.foreach문 - key값을 set으로 가져오는 것.
//        for(String a : sports.keySet()) {             //sports.keySet() : key값을 set으로 가져오는 것.
//            System.out.println(a);  //key
//            System.out.println(sports.get(a));  //value
//        }
////        위와같은코드
//        Set<String> mySet = sports.keySet();
//        for(String a : mySet) {
//            System.out.println(a);
//        }
////        2.iterator 활용
//        Map<String, String> sports = new HashMap<>();
//        sports.put("soccer", "축구");
//        sports.put("baseball", "야구");
//        sports.put("basketball", "농구");
//        Iterator<String> iterators = sports.keySet().iterator();
////        next()는 데이터를 하나씩 소모시키면서 값을 반환
//        System.out.println(iterators.next());
//        System.out.println(iterators.next());
//        System.out.println(iterators.next());
////        System.out.println(iterators.next());   //값이 없으므로 에러
////        hasNext()는 iterator안에 그 다음값이 있는지 없는지 boolean 리턴
//        System.out.println(iterators.hasNext());
//        while (iterators.hasNext()) {
//            System.out.println(iterators.next());
//        }

////        ⭐map은 key의 value를 count하는 목적으로 많이 활용
//        String[] arr = {"농구", "축구", "농구", "야구", "축구"};
////       농구:2, 축구:2, 야구:1
//        Map<String, Integer> myMap = new HashMap<>();
//        for(int i=0; i<arr.length; i++) {
////            if(myMap.containsKey(arr[i])) {
////                myMap.put(arr[i], myMap.get(arr[i]) + 1);
////            }  else {
////                myMap.put(arr[i], 1);
////            }
//////            getOrDefault(키값, 초기값) : key값 없을경우 초기값 리턴
//            myMap.put(arr[i], myMap.getOrDefault(arr[i], 0)+1);
//        }
//        System.out.println(myMap);
//
//        String[] removeArr = {"농구", "농구", "농구", "야구", "축구"};
////        농구:2 야구:1 축구:2 -> 축구:1
//        for(String r : removeArr) {
//            if(myMap.containsKey(r)) {
//                if(myMap.get(r) == 1) {
//                    myMap.remove(r);
//                } else {
//                    myMap.put(r, myMap.get(r)-1);
//                }
//            }
//        }
//        System.out.println(myMap);

//        Map<String, Integer> myMap = new HashMap<>();
//        myMap.put("축구", 3);
//        myMap.put("농구", 2);
//        myMap.put("야구", 1);
//
////        가장 value가 큰 key값 찾기
//        int max = Integer.MIN_VALUE;
////        내가푼거 -> 걍 max만 구함.
//        for(int v : myMap.values()) {
//            if(v > max) {
//                max = v;
//            }
//        }
//        System.out.println(max);
////        강사님
//        String maxKey = "";
//        for(String k : myMap.keySet()) {
//            if(myMap.get(k) > max) {
//                max = myMap.get(k);
//                maxKey = k;
//            }
//        }
//        System.out.println(maxKey);

////       ⭐백준 : 베스트셀러
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        //입력값을 map에 저장
//        Map<String, Integer> myMap = new HashMap<>();
//        for(int i=0; i<n; i++) {
//            String str = br.readLine();
//            //getOrDefault : 키값이 존재하면 value+1, 존재하지 않으면 기본값 0
//            myMap.put(str, myMap.getOrDefault(str, 0) + 1);
//        }
//        //가장많이팔린책 출력
//        int max = Integer.MIN_VALUE;    //최대 판매 횟수
//        String maxKey = "";             //최대 판매 책 제목
//        for(String k : myMap.keySet()) {
//            if(myMap.get(k) > max) {
//                max = myMap.get(k);
//                maxKey = k;
//                //여러개면 사전순
//            } else if (myMap.get(k) == max) {
//                if(k.compareTo(maxKey) < 0) {   //음수 : 사전순으로 앞
//                    maxKey = k;
//                }
//            }
//        }
//        System.out.println(maxKey);

////        ⭐프로그래머스 : 완주하지 못한 선수
////        map활용할경우 : 참여자를 모두 map 담기, 완주한사람을 map에서 차감.
//        String[] participant = {"mislav", "stanko", "mislav", "ana"};
//        String[] completion = {"stanko", "ana", "mislav"};
//
//        class Solution {
//            public String solution(String[] participant, String[] completion) {
//                Map<String, Integer> map = new HashMap<>();
//
//                // 1. 참가자 수 세기
//                for (String name : participant) {
//                    map.put(name, map.getOrDefault(name, 0) + 1);
//                }
//
//                // 2. 완주한 사람 수 빼기
//                for (String name : completion) {
//                    map.put(name, map.get(name) - 1);
//                }
//
//                // 3. value가 1인 사람 = 완주 못한 사람
//                for (String name : map.keySet()) {
//                    if (map.get(name) > 0) {
//                        return name;
//                    }
//                }
//
//                return "";  // 아무것도 없을 때 기본값으로 사용
//            }
//        }
//
//        Solution sol = new Solution();
//        String result = sol.solution(participant, completion);
//        System.out.println(result);  // 🔍 정답: mislav

////        ⭐프로그래머스 - 의상
//        String[][] clothes = {
//                {"yellowhat", "headgear"},
//                {"bluesunglasses", "eyewear"},
//                {"green_turban", "headgear"}
//        };
//
//        class Solution {
//            public int solution(String[][] clothes) {
//
//                //1. map에 종류 : 개수 입력
//                Map<String, Integer> map = new HashMap<>();
//                for (int i=0; i<clothes.length; i++) {
//                    map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
//                }
//                for (String[] c : clothes) {    //2차원배열 행하나씩 꺼내기
//                    String type = c[1];     //의상 종류만 뽑기
//                    map.put(type, map.getOrDefault(type, 0) + 1);
//                }
//
//                //2. 키가 중복되지 않으면서 가능한 모든 조합의 수
//                //조합의 범위 : 1 ~ 의상 종류의 수
//                int answer = 1;
//                for(int count : map.values()) {
//                    answer *= (count + 1);    //입지않는경우 포함해서 경우의 수 계산
//                }
//
//                answer -= 1;    //아무것도 안입는 경우는 제외
//
//                return answer; // 정답 계산은 나중에
//            }
//        }
//        Solution sol = new Solution();
//        sol.solution(clothes);  // 출력은 solution() 내부에서 처리

////        LinkecHashMap : 데이터의 삽입순서를 보장(유지)
//        Map<String, Integer> linkedMap = new LinkedHashMap<>();
//        linkedMap.put("hello5", 1);
//        linkedMap.put("hello4", 2);
//        linkedMap.put("hello3", 3);
//        linkedMap.put("hello2", 4);
//        linkedMap.put("hello1", 5);
//        for(String l : linkedMap.keySet()) {
//            System.out.println(l);
//        }

////        TreeMap : key를 정렬(오름차순)하여 map을 저장
//        Map<String, Integer> treeMap = new TreeMap<>();
//        treeMap.put("hello5", 1);
//        treeMap.put("hello4", 2);
//        treeMap.put("hello3", 3);
//        treeMap.put("hello2", 4);
//        treeMap.put("hello1", 5);
//        for(String l : treeMap.keySet()) {
//            System.out.println(l);
//        }

////        백준 : 파일 정리
////        문자열자르기 : .은 특수문자로 취급되어 "." -> "\\."
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//
//        //map에 중복 카운팅해서 넣기
//        Map<String, Integer> map = new TreeMap<>();
//        for(int i=0; i<n; i++) {
//            String[] str = br.readLine().split("\\.");
//            String extension = str[1];
//
//            map.put(extension, map.getOrDefault(extension, 0) + 1);
//        }
//
//        for(String k : map.keySet()) {
//            System.out.println(k + " " + map.get(k));
//        }

    }
}
