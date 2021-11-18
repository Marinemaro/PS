package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");

        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        int b = Integer.parseInt(in[2]);
        int[][] map = new int[n][m];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            in = br.readLine().split(" ");
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(in[j]);
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        int ans = Integer.MAX_VALUE;
        int ansFloor = 0;

        for(int floor = min; floor<=max; floor++) {
            int s = 0;
            int block = b;
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    int h = map[i][j];
                    while(h < floor) {
                        s++;
                        block--;
                        h++;
                    }
                    while(h > floor) {
                        s+=2;
                        block++;
                        h--;
                    }
                }
            }
            if(block<0) s = Integer.MAX_VALUE;
            if(s<=ans) {
                ans = s;
                ansFloor = floor;
            }
        }

        System.out.println(ans+" "+ansFloor);
    }
}
