package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1181_sort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //중복제거 -> TreeSet
        Set<String> treeSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()-o2.length() == 0) {
                    return o1.compareTo(o2);    //사전순
                } else {
                    return o1.length()-o2.length(); //길이순
                }
            }
        });

        for(int i=0; i<n; i++) {
            treeSet.add(br.readLine());
        }


        for(String a : treeSet) {
            System.out.println(a);
        }
    }
}
