package BOJ;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        MaroReader mr = new MaroReader(64, 64, true);
        int n = mr.nextInt();
        int r = mr.nextInt();
        int c = mr.nextInt();
        int m = 1<<n;
        int sum = 0;
        while(n-->0) {
            m/=2;
            sum += (2*((m<=r)?1:0) + ((m<=c)?1:0))*m*m;
            r -= (m<=r)?m:0;
            c -= (m<=c)?m:0;
        }
        System.out.println(sum);
    }
}
