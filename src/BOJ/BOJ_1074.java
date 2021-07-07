package BOJ;

import java.io.*;

public class BOJ_1074 {
    public static int z(int m, int r, int c) {
        int sum = 0;
        int[][] map = {{0, 1},{2, 3}};
        while(m>=2){
            if(m<=r) {
                r-=m;
                sum+=m*m*2;
            }
            if(m<=c) {
                c-=m;
                sum+=m*m;
            }
            m/=2;
        }
        return map[r][c]+sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int r = Integer.parseInt(in[1]);
        int c = Integer.parseInt(in[2]);
        int m = (int)Math.pow(2, n);
        System.out.println(z(m/2, r, c));
    }
}