package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q2606_DFSBFS {
    //클래스 변수
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine()); //정점 개수 : 7
        int link = Integer.parseInt(br.readLine());  //간선 개수 : 6

        //graph 초기화
        for(int i=0; i<=total; i++) {
            graph.add(new ArrayList<>());
        }

        //그래프에 값넣기
        for(int i = 0; i<link; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
            //graph : [[], [2, 5], [1, 3, 5], [2], [7], [1, 2, 6], [5], [4]]
        }

        //dfs메서드 호출
        visited = new boolean[total+1];
        dfs(1);

        //방문한 정점개수 출력
        System.out.println(count);
    }

    static void dfs(int node) {
        visited[node] = true;
        if(node != 1) {
            count++;
        }
        for(int next : graph.get(node)) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }
}
