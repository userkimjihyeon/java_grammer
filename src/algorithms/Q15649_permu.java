package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q15649_permu {
    public static void main(String[] args) throws IOException {
        //순열(permutation)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);     //1~n까지 자연수
        int m = Integer.parseInt(input[1]);     //수열의 길이

        //원본 및 결과 객체 생성
        List<Integer> numList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            numList.add(i+1);
        }
        List<List<Integer>> resultList = new ArrayList<>();

        //순열 메서드 호출
        permu(numList, new ArrayList<>(), resultList, m, new boolean[numList.size()]);

        //출력
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<resultList.size(); i++) {    //행
            for(int j=0; j<m; j++) {                //열
                sb.append(resultList.get(i).get(j)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    //순열 메서드
    public static void permu(List<Integer> numList, List<Integer> temp, List<List<Integer>> resultList, int target, boolean[] visited) {
        if(temp.size() == target) {
            resultList.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0; i<numList.size(); i++) {
            if(!visited[i]) {
                visited[i]=true;
                temp.add(numList.get(i));
                permu(numList, temp, resultList, target, visited);
                temp.remove(temp.size()-1);
                visited[i]=false;
            }
        }
    }
}
