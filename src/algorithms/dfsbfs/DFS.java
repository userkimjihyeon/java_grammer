package algorithms.dfsbfs;

//미로
public class DFS {
    //필드
    Node root;
    //메서드: main
    public static void main(String[] args) {
        DFS tree = new DFS();   //DFS클래스타입의 객체tree 생성
        tree.root = new Node(0);   //tree의 필드인 Node클래스 타입의 객체root에 새로운 Node객체생성 - 생성자인수 0
        tree.root.lt = new Node(1); //tree의 필드인 Node클래스 타입의 root의 필드인 lt에 새로운 Node객체생성 - 생성자인수 1
        tree.root.rt = new Node(2);
        tree.root.lt.lt = new Node(3);  //tree의 필드인 root의 필드인 Node클래스타입 lt에 새로운 Node객체생성 - 생성자인수 3
        tree.root.lt.rt = new Node(4);
        tree.root.rt.lt = new Node(5);
        tree.root.rt.rt = new Node(6);
        tree.DFS(tree.root);    //DFS메서드 실행
    }
    //메서드: DFS
    public void DFS(Node root) {        //인자로 Node타입의 변수를 받아오는 DFS 메서드 생성
        if(root == null) return;        //받아온 Node타입의 인자가 null이면, return
        else {                          //값이 있으면,
            System.out.print(root.data + " ");  //인자의 필드인 data를 출력
            DFS(root.lt);                       //DFS메서드 호출 - 인수는 현재 인자값인 root의 Node클래스타입의 필드인 lt.
            DFS(root.rt);                       //스택에 저장 -> 현재 인자값인 root의 DFS(root.lt)메서드가 종료되면, 스택에 쌓인 DFS(root.lt) 실행
        }
    }
}

//전역클래스 Node : DFS,BFS 공유
class Node {
    //필드
    int data;
    Node lt;    //이진트리, 자기자신의 타입의 필드 선언
    Node rt;
    //생성자
    public Node(int val) {
        data = val;
        lt = null;
        rt = null;
    }
}
