package BOJ;

import java.io.*;

public class BOJ_1874 {
    public static void main(String[] args) throws IOException {
        MaroReader mr = new MaroReader(65536, 10, true);
        MaroWriter mw = new MaroWriter(65536);
        StringBuilder sb = new StringBuilder();
        int n = mr.nextInt();
        int[] s1 = new int[n];
        for(int i=0; i<n; i++) s1[i] = mr.nextInt();
        int t1 = 0;
        int[] s2 = new int[n];
        int t2 = -1;
        for(int i=1; i<=n; i++) {
            s2[++t2] = i;
            sb.append("+\n");
            while(t2>=0 && t1>=0 && s2[t2] == s1[t1]) {
                s2[t2--] = 0;
                s1[t1++] = 0;
                sb.append("-\n");
            }
        }
        mw.write(t2<0?sb.toString():"NO");
        mw.flush();
    }
}
