package TEST;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int INF = 10001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        int[] dp = new int[m+1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for(int i=0; i<n; i++) {
            int k = Integer.parseInt(br.readLine());
            for(int j=k; j<=m; j++) {
                dp[j] = Math.min(dp[j], dp[j-k]+1);
            }
        }
        System.out.println(dp[m]==INF?"-1":dp[m]);
    }
}