package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Q1620_map2 {
    public static void main(String[] args) throws IOException {
        //포켓몬도감에서 서로 호출. 포켓몬 이름 <-> 포켓몬 번호
        //포켓몬 개수 N
        //문제 개수 M
        //1번~N번의 포켓몬
        //N개의 문제
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);   // 포켓몬도감 개수
        int m = Integer.parseInt(str[1]);   // 문제 개수

        //1. 포켓몬 도감 생성 map<이름, 번호(이중 맵)>
        Map<String, Map<Integer, String>> map = new HashMap<>();
//        for(int i=0; i<n; i++) {
//            String input = br.readLine();
//            map.put()
//        }


//        for(Map.Entry<String, Map<Integer, String>> outerEntry : map.entrySet()) {
//            String name1 = outerEntry.getKey();
//            Map<Integer, String> innerMap = outerEntry.getValue();
//
//            for(Map.Entry<Integer, String> innerEntry : innerMap.entrySet()) {
//                int number = innerEntry.getKey();
//                String name2 = innerEntry.getValue();
//            }
//        }

        //2. 문제풀기
        // 1) input이 아스키코드 대문자 A보다 크면, 해당하는 key -> value.
        // 2) ⭐input이 아스키코드 대문자 A보다 작으면, 해당하는 value -> key???
        // 2-1) value로 key를 찾을 수는 없으니. value에 map을 넣어서 이중key -> 이중value



    }

}
