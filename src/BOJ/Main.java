package BOJ;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        long x = Long.parseLong(in[0]);
        long y = Long.parseLong(in[1]);
        long z = y*100/x;

        long lo = 1;
        long hi = 1000000000;
        long cnt = -1;
        while(lo <= hi) {
            long mid = (lo+hi)/2;
            long v = (y+mid)*100/(x+mid);
            if(v > z) {
                cnt = mid;
                hi = mid-1;
            } else lo = mid+1;
        }

        System.out.println(cnt);
    }
}
