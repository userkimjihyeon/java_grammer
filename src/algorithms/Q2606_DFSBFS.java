package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q2606_DFSBFS {
    //클래스 변수
    static List<List<Integer>> graph = new LinkedList<>();
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine()); //7
        int start = Integer.parseInt(br.readLine()); //6

        //정방향
        //1: 2,5
        //2: 1,3,5
        //3: 2
        //5: 1,2,6
        //6: 5
        //4: 7 -> X
        //7: 4 -> X

        //graph 초기화
        for(int i=0; i<=total; i++) {
            graph.add(new ArrayList<>());
        }

        //그래프에 값넣기
        for(int i=0; i<total; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }


        //dfs메서드 호출
        visited = new boolean[total+1];
        dfs(start);
        System.out.println(count);
    }

    static void dfs(int node) {
        visited[node] = true;
        count++;
        for(int next : )
        if(!visited[node]) {
            dfs(node);
        }
    }
}
