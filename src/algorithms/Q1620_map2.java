package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

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
        String input;

        //1. 포켓몬 도감 생성 1)map<이름, 번호>  2)map<번호, 이름>
        // value로 key를 찾을 수 없음 -> ⭐역참조 맵
        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();

        for(int i=1; i<=n; i++) {
            input = br.readLine();
            map1.put(input, i);
            map2.put(i, input);
        }

        //2. 문제풀기
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++) {
            input = br.readLine();

//            if(Character.isDigit(input.charAt(0))) {                //⭐true/false 반환
            if(input.charAt(0) >= '0' && input.charAt(0) <= '9') {    //⭐아스키코드 방법
                int number = Integer.parseInt(input);
                sb.append(map2.get(number)).append("\n");
                break;
            } else {
                sb.append(map1.get(input)).append("\n");
                break;
            }
        }

        System.out.println(sb);
    }
}
