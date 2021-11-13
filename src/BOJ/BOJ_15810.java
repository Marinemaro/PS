package BOJ;

import java.io.*;

public class BOJ_15810{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        int[] a = new int[n];
        in = br.readLine().split(" ");
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(in[i]);
            min = Math.min(a[i], min);
        }

        long lo = min;
        long hi = (long)min*m;
        long ans = Long.MAX_VALUE;

        while(lo<=hi){
            long mid = (lo+hi)/2;
            long cnt = 0;
            for(int i=0; i<n; i++) cnt += mid/a[i];
            if(cnt >= m) {
                ans = Math.min(ans, mid);
                hi = mid-1;
            } else lo = mid+1;
        }

        System.out.println(ans);
    }
}