package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9012_stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {                   //n행 반복
            Stack<Integer> stack = new Stack<>();
            String input = br.readLine();
            boolean isValid = true;

            //input -> c 한글자씩 뽑아서 비교
            for(char c : input.toCharArray()) {
                //c=='(' -> push
                //c!='(' -> pop (추가조건 : stack이 비어있으면 즉, '(' 없으면 false를 기록하고 반복문 종료)

                if(c == '(') {
                    stack.push(1);
                } else {
                    if(stack.isEmpty()) {
                        isValid = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            //한 행이 끝나고, stack이 비어있을때 false면 -> NO출력. true면 -> YES출력.
            //stack이 비어있지 않으면 -> NO출력
            if(isValid && stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
