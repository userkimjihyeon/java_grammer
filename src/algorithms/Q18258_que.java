package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q18258_que {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> que = new LinkedList<>();
        int last = -1;

        for(int i=0; i<n; i++) {
            String input = br.readLine();

            if(input.startsWith("push")) {          //⭐마지막 push값 저장용
                String[] arr = input.split(" ");
                int x = Integer.parseInt(arr[1]);
                que.add(x);
                last = x;   //⭐마지막 값 갱신
            } else {
                //⭐if(input.contains("pop")) 대신 switch문 사용
                switch (input) {
                    case "pop":
                        sb.append(que.isEmpty() ? -1 : que.poll());
                        break;
                    case "size":
                        sb.append(que.size());
                        break;
                    case "empty":
                        sb.append(que.isEmpty() ? 1 : 0);
                        break;
                    case "front":
                        sb.append(que.isEmpty() ? -1 : que.peek());
                        break;
                    case "back":
                        sb.append(que.isEmpty() ? -1 : last);   //⭐마지막 값 사용
                        break;
                }
                sb.append("\n");
            }
        }
        sb.deleteCharAt(sb.length()-1); //마지막 개행 제거
        System.out.println(sb);
    }
}
