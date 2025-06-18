package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q1302_map {
    public static void main(String[] args) throws IOException {
        //오늘하루동안팔린책의제목출력
        //n 오늘하루팔린책의 개수
        //책의 제목이 여러개일 경우 사전순

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //1. map에 책 : 판매수 넣기 (중복카운팅)
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            String input = br.readLine();
            map.put(input, map.getOrDefault(input, 0)+1);
        }

        //2. value끼리 비교해서 가장 큰 value의 키값을 maxKey에 저장
        String maxKey = "";
        int max = Integer.MIN_VALUE;

        //entrySet : key, value 한번에 가져오기
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String name = entry.getKey();
            int count = entry.getValue();

            if(count > max || (count == max && name.compareTo(maxKey) < 0)) {
                max = count;
                maxKey = name;
            }
        }

//        for(String name : map.keySet()) {
//            if(map.get(name) > max) {
//                max = map.get(name);
//                maxKey = name;
//            //3. ⭐value가 같은 경우 책이름 사전순 정렬 -> compareTo()
//            } else if(map.get(name) == max) {
//                if(name.compareTo(maxKey) < 0) {    //⭐음수면 앞이 우선
//                    maxKey = name;                  //⭐maxKey 교체
//                }
//            }
//        }

        //4. 최종 maxKey 출력
        System.out.println(maxKey);
    }
}
