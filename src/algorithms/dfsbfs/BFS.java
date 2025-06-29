package algorithms.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

//최단경로
public class BFS {
    Node root;

    public static void main(String[] args) {
        //DFS클래스타입의 객체 tree 생성
        BFS tree = new BFS();
        tree.root = new Node(0);   //tree의 필드인 Node클래스 타입의 객체root에 새로운 Node객체생성 - 생성자인수 0
        tree.root.lt = new Node(1); //tree의 필드인 Node클래스 타입의 root의 필드인 lt에 새로운 Node객체생성 - 생성자인수 1
        tree.root.rt = new Node(2);
        tree.root.lt.lt = new Node(3);  //tree의 필드인 root의 필드인 Node클래스타입 lt에 새로운 Node객체생성 - 생성자인수 3
        tree.root.lt.rt = new Node(4);
        tree.root.rt.lt = new Node(5);
        tree.root.rt.rt = new Node(6);
        tree.BFS(tree.root);    //DFS메서드 실행
    }

    public void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>(); //Q 생성
        Q.offer(root);                      //Q에 BFS함수의 인자로 넘어온 root의 주소값 넣기
        int L = 0;                          //레벨 계산

        while(!Q.isEmpty()) {               //Q가 빌때까지 반복
            int len = Q.size();             //len은 Q의 크기 => 반복문 횟수
            System.out.print(L + " : ");    //레벨 출력

            for(int i=0; i<len; ++i) {      //Q의 크기(len)만큼 반복
                Node current = Q.poll();    //Node클래스 타입의 객체 current생성 및 Q를 꺼내 current에 저장.
                System.out.print(current.data + " ");   //현재노드 출력

                if(current.lt != null) {    //현재노드의 왼쪽노드에 값이 있으면
                    Q.offer(current.lt);    //Q에 왼쪽노드 추가
                }
                if(current.rt != null) {    //현재노드의 오른쪽노드에 값이 있으면
                    Q.offer(current.rt);    //Q에 오른쪽노드 추가
                }
            }

            L++;
            System.out.println();
        }

    }
}
