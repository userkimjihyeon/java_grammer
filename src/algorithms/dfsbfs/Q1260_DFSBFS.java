package algorithms.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q1260_DFSBFS {
    static List<List<Integer>> graph = new ArrayList<>();  //👉 랜덤 접근이 많다 → ArrayList👉 중간 삽입/삭제가 많다 → LinkedList
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); //정점 개수
        int m = Integer.parseInt(input[1]); //간선 개수
        int v = Integer.parseInt(input[2]); //start

        //graph 초기화 -> 빈리스트가 있어야 add가능. ex)graph.get(1) = null -> NPE 터짐!
        for(int i=0; i<=n; i++) {   //0은 빈자리로 두고 1~n번에 실제데이터 저장
            graph.add(new ArrayList<>());
        }

        //정점 입력받아 그래프 연결
        for(int i=0; i<m; i++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);

            //양방향
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        //각 정점의 연결리스트 오름차순 정렬
        for(int i=1; i<=n; i++) {
            graph.get(i).sort(null);    //⭐list.sort(null) : Collections.sort(list, Comparator.naturalOrder());
        }

        //dfs 실행
        visited = new boolean[n+1];
        dfs(v);
        System.out.println();

        //bfs 실행
        visited = new boolean[n+1];
        bfs(v);
        System.out.println();

    }
    static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for(int next : graph.get(node)) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }
    static void bfs(int start) {
        //ArrayList는 Queue 인터페이스를 구현하지 않음 -> poll(), offer() 같은 Queue 전용 메서드 못씀.
        Queue<Integer> queue = new LinkedList<>();  //⭐LinkedList : 맨 앞꺼 줄에서 빠져나가도 나머진 그대로 줄만 연결하면 됨.
        visited[start] = true;
        queue.offer(start);

        while(!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int next : graph.get(node)) {
                if(!visited[next]) {
                    queue.offer(next);
                }
            }
        }

    }
}
