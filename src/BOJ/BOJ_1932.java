package BOJ;

import java.io.*;

public class BOJ_1932 {
    public static void main(String[] args) throws IOException {
        MaroReader mr = new MaroReader(65536);
        int n = mr.nextInt();
        int[][] map = new int[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<=i; j++) map[i][j] = mr.nextInt();
        int max = map[0][0];
        for(int i=1; i<n; i++) {
            for(int j=0; j<=i; j++) {
                if(j==0) map[i][j] += map[i-1][j];
                else map[i][j] += Math.max(map[i-1][j-1], map[i-1][j]);
                max = Math.max(max, map[i][j]);
            }
        }
        System.out.print(max);
    }
    static class MaroReader {
        private final InputStream in = System.in;
        private final byte[] b;
        private final int sz;
        private int idx, rCnt;
        public MaroReader(int sz) {this.b = new byte[this.sz=sz];}
        private void refill() throws IOException {
            rCnt = in.read(b, idx=0, sz);
            if(rCnt<0) b[0] = -1;
        }
        public byte read() throws IOException {if(idx >= rCnt) refill(); return b[idx++];}
        public int nextInt() throws IOException {
            int a;
            byte b=read();
            a=b-'0';
            while((b=read())>='0' && b<='9') a=a*10+b-'0';
            return a;
        }
    }
}
