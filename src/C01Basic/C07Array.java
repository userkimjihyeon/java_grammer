package C01Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

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
////        배열표현식3.예시
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
//
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

////        ⭐배열 뒤집기
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

//        ⭐선택정렬 알고리즘 직접구현 : 1)min값찾기 2)자리바꾸기 3)이중for문(index주의)
//        -> 예습하기. 정렬알고리즘: dfs,bfs,그리디…
        int[] arr = {17,12,20,10,15};
        int temp = 0;

//        자리를 결정
        for(int i=0; i<arr.length-1; i++){
//            min값을 찾기위한 for문
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));


    }
}
