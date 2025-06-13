package C01Basic;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLOutput;
import java.util.*;

public class C07Array {
    public static void main(String[] args) {
////        배열표현식1. 배열 선언 후 할당 방식
////        배열을 반드시 사전에 길이가 결정되어야 함.
//        int[] arr1 = new int[5];    //선언과 동시에 길이 및 값이 0으로 초기화됨
//        arr1[0] = 10;
//        arr1[1] = 20;
//        //arr1[2] = 30;
//        arr1[3] = 40;
//        arr1[4] = 50;
//        arr1[5] = 10;   //index out of bounds 예외 발생. 배열길이가 동적으로 늘어날수 없음.
//        System.out.println(arr1[2]);    //int배열의 경우 0으로 초기화. String배열은 null로 초기화.

////        배열표현식2. 리터럴방식
//        int[] arr2 = {10,20,30,40,50};
//
////        ⭐배열표현식3. ->오른쪽내용만봐도 타입을확인하기 용이함.
//        int[] arr3 = new int[]{10,20,30,40,50};
//
////        ⭐배열표현식3.예시
//        ArrayList<int[]> list = new ArrayList<>();
//        list.add(new int[5]);
//        list.add(new int[]{1,3,5,7});
//
//        System.out.println(list.get(1)[0]);     //1 출력
//
////        배열표현식4 : 불가 -> 배열의길이를 반드시 확정시켜야함.
//        int[] arr4 = new int[];

////        Arrays.fill : 배열에 모든값을 변경
//        String[] arr = new String[5];
////        방법1)
//        for(int i=0; i<arr.length; i++) {
//            arr[i] = "";
//        }
////        방법2)
//        Arrays.fill(arr, "");   //Arrays에 메서드가 내장되어있음.

////        ⭐오늘배운이론관련문제많이풀기

////        85, 65, 90으로 구성된 int배열을 선언하고, 총합과 평균을 구해보시오.
//        int[] arr = new int[]{85, 65, 90};
//        int sum = 0;
//
//        for (int i=0; i<arr.length; i++) {
//            sum += arr[i];
//        }
//
//        System.out.println("총합 : " + sum);
//        System.out.println("평균 : " + (double)sum/arr.length);   //(double) : 소수점절삭

////        ⭐배열의 최대값, 최소값 (어려운점 : indexoutofbounds -> 그냥 arr[0]값을 max,min에 넣으면됨.)
//        int[] arr = new int[]{10,20,30,12,8,17};
//        //int max = arr[0];
//        //int min = arr[0];
//        //0번째가 없을때
//        int max = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
//
//        for(int i=0; i<arr.length; i++) {
//            if(arr[i] > max) {
//                max = arr[i];
//            }
//            if(arr[i] < min) {
//                min = arr[i];
//            }
//        }
//        //System.out.println("최대값 : " + max);
//        //System.out.println("최소값 : " + min);
//        //그냥 .max .min 하면 됨
//        System.out.println(Arrays.stream(arr).max());
//        System.out.println(Arrays.stream(arr).min());

////        배열의 자리 바꾸기
//        int[] arr = {20,10,30};
//        int temp = arr[0];  //keep
//        arr[0] = arr[1];
//        arr[1] = temp;
//        System.out.println(Arrays.toString(arr));

////        ⭐배열 뒤집기 -> index=0을 +1하면서, 배열맨뒤를 -1하면서 서로 값을 바꿈
//        int[] arr = {10,20,30,40,50};
//        int[] newArr = new int[arr.length];
//        int index = 0;  // = arr.length-1
//
//        for(int i=arr.length-1; i>=0; i--) {    //int i=0; i<arr.length; i++
//            newArr[index] = arr[i];             //newArr[i] = arr[index] //arr[⭐] arr[arr.length-i] 왜 안돼
//            index++;                            //index--;
//        }
//        System.out.println(Arrays.toString(newArr));

////        ⭐배열의 정렬
//        int[] arr = {17,12,20,10,15};
//        Arrays.sort(arr);       //오름차순 정렬
////        Arrays.sort(arr, Comparator.reverseOrder()); 원시자료형은 Comparator 사용불가능 (내림차순하는방법 : 오름차순하고 뒤집기)
//        System.out.println(Arrays.toString(arr));
//
//        String[] stArr = {"abc", "aaa", "acb", "abb"};
//        Arrays.sort(stArr, Comparator.reverseOrder());  //내림차순 정렬
//        System.out.println(Arrays.toString(stArr));

////        ⭐선택정렬 알고리즘 직접구현 : 1)min값찾기 2)자리바꾸기 3)이중for문(index주의)
////        ⭐예습하기. 정렬알고리즘: dfs,bfs,그리디…
//        int[] arr = {17,12,20,10,15};
////        자리(i)를 결정
//        for(int i=0; i<arr.length-1; i++){      //⭐-1안하면, j=i+1에서 에러
//            int min = arr[i];
//            int minIndex = i;
////            min값을 찾기위한 for문
//            for(int j=i+1; j<arr.length; j++){    //⭐그냥 j=1하면 안됨? -> i가 다음으로 넘어갈때 j는 또 1로 가니까 안됨!!
//                if(arr[j] < min) {
//                    min = arr[j];
//                    minIndex = j;
//                }
//            }
////            자리바꾸기 로직
//            int temp = arr[i];
//            arr[i] = arr[minIndex];
//            arr[minIndex] = temp;
//        }
//        System.out.println(Arrays.toString(arr));

////        방법2) - 버블정렬에 가까움
//        int[] arr = {17,12,20,10,15};
////        자리(i)를 결정
//        for(int i=0; i<arr.length-1; i++){
//            //            min값을 찾기위한 for문
//            for(int j=i+1; j<arr.length; j++){
//                if(arr[j] < arr[i]) {
//                    int temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));

//        logn = 제곱승수

////        조합문제 : 모두 각기 다른 숫자의 배열이 있을때, 만들어질 수 있는 두 숫자의 조합을 문자열 형태로 출력
////        ex)(10,20) (10,30) (10,40) (10,50) (20,30) (20,40) (20,50) (30,~)
//        int[] intArr = {10,20,30,40,50};
//        for (int i=0; i<intArr.length-1; i++) {         //⭐-1해야하는 이유: 인덱스는 개수-1이니까
//            for (int j=i+1; j<intArr.length; j++) {
//                System.out.println("(" + intArr[i] + "," + intArr[j] + ")");
//            }
//        }

////        배열의 중복제거 : set자료구조(중복X, 순서X)를 활용하여 중복제거
//        int[] arr = {10,10,20,30,30,40};
//        Set<Integer> mySet = new HashSet<>();
//        for(int a : arr) {
//            mySet.add(a);
//        }
//        System.out.println(mySet);
//        int[] answer = new int[mySet.size()];   //⭐set.size() : set의 길이
//        int index = 0;
//        for(int a : mySet) {        //⭐set에서 값꺼내서 배열에 넣기
//            answer[index] = a;
//            index++;
//        }
//        Arrays.sort(answer);
//        System.out.println(Arrays.toString(answer));

////        ⭐프로그래머스-두 개 뽑아서 더하기(조합+중복제거)
//        //number의 i, i+1인덱스를 뽑아 더해서 answer[]에 넣기
//        //오름차순정렬
//        int[] numbers = {2,1,3,4,1};        //0~4
//        Set<Integer> mySet = new HashSet<>();
//
//        for(int i=0; i<numbers.length-1; i++) {     //0~4
//            for(int j=i+1; j<numbers.length; j++) {     //1~5
//                //연산결과를 set에서 중복제거하고 -> answer[]에 넣어야할거같음.
//                mySet.add(numbers[i] + numbers[j]);
//            }
//        }
//        int[] answer = new int[mySet.size()];
//        int index = 0;
//        for (int a : mySet) {
//            answer[index] = a;
//            index++;
//        }
//        Arrays.sort(answer);
//        System.out.println(Arrays.toString(answer));

////        배열의 검색
//        int[] arr = {5,3,1,8,7};
//        int target = 8;
////        8이 몇번째 index에 있는지 출력
//        for (int i=0; i<arr.length-1; i++) {        //index로 도니까 개수-1
//            if(arr[i] == target) {
//                System.out.println(i);
//                break;
//            }
//        }

////        ⭐이분탐색(이진검색) - binary search
////        사전에 데이터가 오름차순정렬돼 있을경우, 이분탐색 가능
//        int[] arr = {1,3,6,8,9,11,15};
////        값이 있으면 해당 index리턴
////        값이 없으면 마이너스 값
//        System.out.println(Arrays.binarySearch(arr, 15));   //-> 복잡도:logn
////        ⭐백준 - 수 찾기 (1920) -> 백준폴더에풀었음
////        그냥다돌리기(n^2) : 시간초과 -> 이분탐색(logn)

////        배열값 비교
//        int[] arr1 = {10,20,30};
//        int[] arr2 = {10,20,30};
//        System.out.println(arr1==arr2); //false
//        System.out.println(Arrays.equals(arr1, arr2)); //true

////        2차원배열의 선언과 값할당
////        {{1,2}, {1,2}, {1,2}}
//        int[][] arr = new int[3][2];        //[3]:전체 배열 개수 [2]:값의 개수
//        arr[0][0] = 1;
//        arr[0][1] = 2;
//        arr[1][0] = 3;
//        arr[1][1] = 4;
//        arr[2][0] = 5;
//        arr[2][1] = 6;
////        리터럴 방식
//        int[][] arr2 = {{1,2},{3,4},{5,6}};
//
////        ⭐가변배열 : 배열의 전체길이는 반드시 할당.
//        int[][] arr3 = {{1,2},{1,2,3},{1,2,3,4}};
////        2차원배열의 출력 : Arrays.deepToString
//        System.out.println(arr3);   //2차원배열의 주소값 : [[I@4c873330
//        System.out.println(Arrays.toString(arr3));  //각1차원배열의 주소값 모음 : [[I@119d7047, [I@776ec8df, [I@4eec7777]
//        System.out.println(Arrays.deepToString(arr3));  //각1차원배열의 값 : [[1, 2], [1, 2, 3], [1, 2, 3, 4]]
//
//        int[][] arr4 = new int[3][];    //[]:가변배열
//        arr3[0] = new int[2];
//        arr3[0][0] = 1; //값의 개수를 선언한 이후에 값할당 가능
//        arr3[1] = new int[3];
//        arr3[2] = new int[4];

////        [3][] 사이즈 배열을 선언하고 1~12까지 숫자값을 각 배열에 순차적으로 할당
////        {1,2,3,4}, {5,6,7,8}, {9,10,11,12}
////        내가푼거
//        int index = 1;
//        int[][] arrr = new int[3][];
//        for(int i=0; i<arrr.length; i++) {              //arrr.length-1에서 -1빼면됨!! 왜지??
//            arrr[i] = new int[4];
//            for(int j=0; j<arrr[i].length; j++) {
//                arrr[i][j] = index;
//                index++;
//            }
//        }
//        System.out.println(Arrays.deepToString(arrr));
////        강사님
//        int[][] arr = new int[3][4];
//        int num = 1;
//        for(int i=0; i<arr.length; i++) {
//            for(int j=0; j<arr[i].length; j++) {
//                arr[i][j] = num;
//                num++;
//            }
//        }
//        System.out.println(Arrays.deepToString(arr));

////        가변배열 값 채우기 -> 위에 내가푼거랑 같음
//        int[][] arr2 = new int[3][];
//        int num2 = 1;
//        for(int i=0; i<arr2.length; i++) {
//            arr2[i] = new int[4];
//            for(int j=0; j<arr2[i].length; j++) {
//                arr2[i][j] = num2;
//                num2++;
//            }
//        }
//        System.out.println(Arrays.deepToString(arr2));

////        프로그래머스-행렬의 덧셈
//        int[][] arr1 = {{1,2},{2,3}};
//        int[][] arr2 = {{3,4},{5,6}};
//
//        int[][] answer = new int[arr1.length][arr1[1].length];
//
//        for(int i=0; i<arr1.length; i++) {  //i:행   <2
//            for(int j=0; j<arr1[i].length; j++) {   //j:열   <2
//                answer[i][j] = arr1[i][j] + arr2[i][j];
//            }
//        }
//        System.out.println(Arrays.deepToString(answer));

////        ⭐프로그래머스-k번째수
//        int[] array = {1, 5, 2, 6, 3, 7, 4};
//        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
//
//        int[] answer = new int[commands.length];
//
//        for (int i=0; i<commands.length; i++) {     //0~2
//            int[] temp = new int[commands[i][1]-commands[i][0]+1];
//
//            //값담기
//            commands[i][j]
//
//            //array오름차순정렬
//            Arrays.sort(temp);
//            //k번째 인덱스 출력
//            answer[] = temp[x번째];
//            System.out.println(temp[]);

////        배열복사 -> 이거써서 위의 문제 다시 풀어보기
////        Arrays.copyOf(배열명, length), Arrays.copyOfRange(배열명, start, end)       //미만 주의
//        int[] arr = {1,2,3,5,7,5,3,1};
//        int[] arr1 =  Arrays.copyOf(arr, 4);
//        System.out.println(Arrays.toString(arr1));
//        int[] arr2 = Arrays.copyOfRange(arr, 3, 6);
//        System.out.println(Arrays.toString(arr2));
    }
}
