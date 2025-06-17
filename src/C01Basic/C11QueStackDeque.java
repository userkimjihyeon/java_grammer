package C01Basic;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class C11QueStackDeque {
    public static void main(String[] args) {
////        Queue인터페이스를 LinkedList가 구현한 아래와 같은 방식을 가장 많이 사용
//        Queue<Integer> myQue = new LinkedList<>();
//        myQue.add(10);
//        myQue.add(20);
//        myQue.add(30);
//
////        poll : queue에서 데이터를 삭제하면서, 동시에 return하는 메서드
//        int temp = myQue.poll();    //10
//        System.out.println(temp);
//        System.out.println(myQue);  //[20, 30]
////        peek : queue에서 데이터를 삭제하지 않고, 가장 앞의 데이터를 반환
//        int temp2 = myQue.peek();   //20
//        System.out.println(temp2);
//        System.out.println(myQue);  //[20, 30]
//
////        LinkedList와 ArrayList의 성능차이 비교 -> LinkedList 승!
////        LinkedList                         LinkedList
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        for(int i=0; i<100_000; i++) {
//            linkedList.add(0, i);
//        }
//
//        List<Integer> arrayList = new ArrayList<>();
//        for(int i=0; i<100_000; i++) {
//            arrayList.add(0, i);
//        }

//        Queue<String> myQue = new LinkedList<>();
//        myQue.add("문서1");
//        myQue.add("문서2");
//        myQue.add("문서3");
//        myQue.add("문서4");
//        int size = myQue.size();            //poll은 값을 삭제하므로 size()가 반복마다 줄어듬 -> 제대로 출력불가 -> size따로 둬도 queue는 사이즈 변환이 빈번하므로 부적합
//        for(int i=0; i<size; i++) {
//            System.out.println(myQue.poll());
//        }
//
////        ⭐Queue는 일반적으로 while문을 통해 요소 소모
//        while(!myQue.isEmpty()) {
//            System.out.println(myQue.poll());
////            2개씩 poll을 할 경우에는 queue가 empty가 되지 않도록 유의. -> ex. queue.size()가 홀수일때 에러
//        }

////        백준 : 카드2 2164
////        ⭐백준 : 요세푸스 문제 1158 -> 혼자다시풀고/블로그에정리

////        길이제한큐(ArrayBlockingQueue)
//        Queue<String> blockingQueue = new ArrayBlockingQueue<>(3);
//        blockingQueue.add("문서1");
//        blockingQueue.add("문서2");
//        blockingQueue.add("문서3");
////        blockingQueue.add("문서4"); //길이초과시, Queue full 에러
////        offer : 길이제한될 경우 제한된 길이까지만 insert
//        blockingQueue.offer("문서1");
//        blockingQueue.offer("문서2");
//        blockingQueue.offer("문서3");
//        blockingQueue.offer("문서4");
//        System.out.println(blockingQueue);

////        ⭐10:30분쯤 수업을 다시들어볼까~?
////        ⭐⭐우선순위큐 : 데이터를 poll할때 정렬된 데이터결과값 보장
////        전체 데이터가 계속해서 변경되면서 지속적으로 최소값을 추출해야 하는 경우.
////        정렬 시간복잡도 : n log n	"n번 반복하면서, 그 안에서 log n 정도의 연산이 추가로 들어가는 경우" ->  log n??????
//        Queue<Integer> pq = new PriorityQueue<>();
//        pq.add(30);
//        pq.add(20);
//        pq.add(10);
//        pq.add(40);
//        pq.add(50);
//        System.out.println(pq); //add할때까지는 전체정렬이 되어있지 않음.
//        while(!pq.isEmpty()) {
//            System.out.println(pq.poll());  //1개씩 poll할때마다 최소값을 뽑아낸다. log(n)의 복잡도
//        }

////        백준 : 최소 힙 1927

////        최대힙 -> Comparator.reverseOrder()
//        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
//        pq.add(30);
//        pq.add(20);
//        pq.add(10);
//        pq.add(40);
//        pq.add(50);
//        System.out.println(pq); //add할때까지는 전체정렬이 되어있지 않음.
//        while(!pq.isEmpty()) {
//            System.out.println(pq.poll());  //1개씩 poll할때마다 최대값을 뽑아낸다. log(n)의 복잡도
//        }

////        ⭐프로그래머스 - 더 맵게
//        // 🔹 여기에 입력을 바꿔가며 직접 테스트해보세요
//        int[] scoville = {1, 2, 3, 9, 10, 12};
//        int K = 7;
//        // 🔹 문제 풀이 함수 호출
//        int result = solution(scoville, K);
//        System.out.println(result); // ← 정답 출력은 임시로 넣어둔 거예요
//    }
//    // 🟡 이 아래만 건드리면서 문제를 푸세요!
//    public static int solution(int[] scoville, int K) {
//        //큐에 값넣기
//        Queue<Integer> pq = new PriorityQueue<>();
//        for(int a : scoville) {
//            pq.add(a);
//        }
//
//        //모든음식의 스코빌 지수가 K이상이 될때까지 반복 / K이상으로 만들 수 없는 경우 -1 return
//        //반복(size가 2이상 && pq가 K보다 작을때)
//        int cnt = 0;  //반복횟수 카운팅
//        while(pq.size >= 2 && pq.peek() < K) {
//                int fir = pq.poll();
//                int sec = pq.poll();
//
//                int mix = fir + (sec * 2);
//                pq.add(mix);
//                cnt++;
//        }
//        //마지막 pq가 K보다 작으면 -> 모든 음식의 스코빌지수를 K이상으로 만들 수 없음
//        if (pq.peek() < K) {
//          return -1;
//        }
//
//        return cnt;
//    }

////      stack : 후입선출
//        Stack<Integer> stack = new Stack<>();
//        stack.push(10);
//        stack.push(20);
//        stack.push(30);
//        System.out.println(stack.pop());         //30 : 제거되면서 값 return
//        System.out.println(stack.peek());        //20 : 값만 return
//        System.out.println(stack.size());        //2
//        System.out.println(stack.isEmpty());     //false

////        ⭐프로그래머스 : 같은 숫자는 싫어 12906
//        // 🔹 테스트 입력값 설정
//        int[] arr = {1, 1, 3, 3, 0, 1, 1};  // 원하는 입력값으로 변경 가능
//
//        // 🔹 문제 풀이 함수 호출
//        int[] result = solution(arr);
//
//        // 🔹 결과 출력
//        System.out.println(Arrays.toString(result));  // [1, 3, 0, 1]
//    }
//
//    // 🟡 직접 문제 풀 함수 (여기에 구현)
//    public static int[] solution(int[] arr) {
//        // TODO: 여기에 로직 구현
//        //스택(후입선출)에 실시간으로 넣으면서 끝자리와 비교
//        Stack<Integer> stack = new Stack<>();
//        for (int a : arr) {
//            if(stack.size() < 1) {
//                stack.push(a);
//            } else {
//                if(stack.peek() != a) {
//                    stack.push(a);
//                }
//            }
//        }
//
//        //리턴용 : stack -> int[]
//        //스택은 후입선출이므로 역순출력 반복문 -> ⭐pop()하지말고 get(i)하셈!!!!!
//        int[] answer = new int[stack.size()];
//        for(int i=0; i < answer.length; i++) {
//            answer[i] = stack.get(i);
//        }
//        return answer;

//        ⭐프로그래머스 : 올바른 괄호 12909 -> stack써서 다시 풀기.
//        -> split말고 toCharArray 쓰면 시간초과 없음 -> 시간부족.
//        백준에서 큐,스택 풀때 데큐가 더 빠른지 확인해보기

////        deque : addFirst, addLast, pollLast(addLast조합 : 후입선출), pollFirst(addLast 조합 : 선입선출), peekFirst, peekLast
//        Deque<Integer> d1 = new ArrayDeque<>();
//        d1.addLast(10);
//        d1.addLast(20);
//        d1.addFirst(30);
//        System.out.println(d1);    // 30 20 10
//        System.out.println(d1.pollLast());     // 20
//        System.out.println(d1.pollFirst());    // 30
//        System.out.println(d1.peekLast());     // 10

//        주요 자료구조 : 배열, 리스트, map, set, 큐, 스택, deque
//        문자열문제,,,,,, 주요자료구조문제,,,,,1문제씩,,,,,,,,,,,
//        아직 안배운 개념 -> 못 푸는게 맞다 -> 예습 미리 해보셈
//        복잡한 정렬 : Comparable, Comparator
//        재귀함수 : 재귀, dfs, 백트래킹
//        주요알고리즘 : dfs/bfs/DP/이분탐색/투포인터


    }
}