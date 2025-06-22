package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q6603_combi {
    public static void main(String[] args) throws IOException {
        //조합(combination)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //1. 원본 및 결과 객체 생성

        //2. k 및 집합s 구하기
        while(true) {
            List<Integer> sList = new ArrayList<>();
            List<List<Integer>> resultList = new ArrayList<>();
            
            String[] input = br.readLine().split(" ");
            int k = Integer.parseInt(input[0]);
            if(k == 0) {
                break;
            }
            for(int i=0; i<k; i++) {
                sList.add(Integer.parseInt(input[i + 1]));
            }
            //3. 조합메서드 호출
            combi(sList, new ArrayList<>(), resultList, 6, 0);

            for(int i=0; i<resultList.size(); i++) {     //행
                for(int j=0; j<6; j++) {                 //열
                    sb.append(resultList.get(i).get(j)).append(" ");
                }
                sb.append("\n");
            }
            sb.append("\n");
        }

        //4. 출력
        System.out.println(sb);
    }

    //조합 메서드
    static void combi(List<Integer> sList, List<Integer> temp, List<List<Integer>> resultList, int target, int start) {
        //종료조건
        if(temp.size() == target) {
            resultList.add(new ArrayList<>(temp));
            return;
        }
        //재귀
        for(int i=start; i<sList.size(); i++) {
            temp.add(sList.get(i));
            combi(sList, temp, resultList, target, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
