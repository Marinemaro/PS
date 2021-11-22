package BOJ;

import java.io.*;

public class BOJ_9663 {
    static boolean[] row;
    static boolean[] d1;
    static boolean[] d2;
    static int n;
    static int f(int r) {
        if(r == n) return 1;
        int ret = 0;
        for(int c=0; c<n; c++) {
            if(!row[c] && !d1[r+c] && !d2[r-c+n-1]) {
                row[c] = d1[r+c] = d2[r-c+n-1] = true;
                ret += f(r+1);
                row[c] = d1[r+c] = d2[r-c+n-1] = false;
            }
        }
        return ret;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        row = new boolean[n];
        d1 = new boolean[n*2-1];
        d2 = new boolean[n*2-1];
        System.out.println(f(0));
    }
}