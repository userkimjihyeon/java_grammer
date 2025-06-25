package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q11286_sort {
    public static void main(String[] args) throws IOException {
        //배열에 정수 x를 넣는다
        //x가 0이 아니라면 -> 배열에 x 추가
        //x가 0이면 -> 배열에서 절댓값이 가장 작은값을 출력 후 배열에서 제거 / 배열이 비어있으면 0을 출력
        //절댓값이 가장 작은값이 여러개면 -> 가장작은수를 출력 후 배열에서 제거

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> pq = new PriorityQueue<>(
                (a, b) -> {
                    if(Math.abs(a) == Math.abs(b)) {    //절대값이 같으면
                        return a-b;                     //가장 작은 수
                    } else {
                        return Math.abs(a)-Math.abs(b); //절대값 작은값
                    }
                }
        );

        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x != 0) {
                pq.add(x);
            } else {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            }
        }

    }
}
