package algorithms.dfsbfs;

import java.util.Scanner;

public class DFS2 {
    static String result = "NO";
    static int n, total;
    boolean flag;

    public static void main(String[] args) {
        DFS2 T = new DFS2();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[] arr = new int[n]; //n크기의 배열생성
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt(); //입력값을 배열에 저장
            total += arr[i];
        }

        T.DFS(0,0,arr);
        System.out.println(result);
    }

    public void DFS(int L, int sum, int[] arr) {
        if(flag) return;            //flag가 true면 return(=종료);
        if(sum > total/2) return;   //누적합이 총합/2보다 크면 return(=종료);
        if(L==n) {                  //L이 배열의 개수와 같으면,(배열순회가 끝나면)
            if(total/2==sum) {      //누적합이 total/2와 같으면,
                result = "YES";     //결과는 YES
                flag = true;        //flag도 true(=종료);
            }
        } else {                    //아직 배열순회가 끝나지 않았으면,
            DFS(L+1, sum+arr[L], arr);  //다음노드 사용
            DFS(L+1, sum, arr);              //다음노드 미사용
        }
    }
}
