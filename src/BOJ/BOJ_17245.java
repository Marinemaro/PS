package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_17245 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        int lo = 0;
        int hi = 10_000_000;
        int sec = 10_000_000;
        while(lo <= hi) {
            int mid = (lo+hi)/2;
            long total = 0;
            long cold = 0;
            // mid(냉기 높이)보다 컴퓨터 개수가 낮으면 컴퓨터의 개수를, 냉기의 높이보다 컴퓨터의 개수가 많으면 냉기의 높이를 더한다.
            for(int[] row : map)
                for(int com : row) {
                    total += com;
                    cold += Math.min(com, mid);
                }
            if(cold*2 >= total) {
                sec = mid;
                hi = mid-1;
            } else lo = mid+1;
        }

        System.out.println(sec);
    }
}

