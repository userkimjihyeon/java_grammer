package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q2170_sort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();

        for(int i=0; i<n; i++) {
            String[] str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            list.add(new int[]{x,y});   //⭐
        }
        list.sort((a, b) -> {
            if(a[0]==b[0]) {
                return a[1]-b[1];
            } else {
                return a[0]-b[0];
            }
        });

        int total=0;
        int start = list.get(0)[0];
        int end = list.get(0)[1];

        for(int i=1; i<list.size(); i++) {
            int nx = list.get(i)[0];
            int ny = list.get(i)[1];

            if(nx <= end) {
                end = Math.max(end, ny);    //겹치면 end 확장
            } else {
                total += end - start;
                start = nx;
                end = ny;
            }
        }

        total += end - start;
        System.out.println(total);

    }
}
