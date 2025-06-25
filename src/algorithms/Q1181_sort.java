package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1181_sort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //1.길이가 짧은순서 2.길이같으면 사전순
        //중복제거, 정렬 -> treeSet
        TreeSet<String> treeSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()) {
                    return o1.length()-o2.length();
                } else {
                    return o1.compareTo(o2);
                }
            }
        });

        for(int i=0; i<n; i++) {
            treeSet.add(br.readLine());
        }

        for(String a : treeSet){
            System.out.println(a);
        }

    }
}
