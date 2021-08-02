package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[1] = arr[0];
        if(n>1) dp[2] = arr[0]+arr[1];
        for(int i=3; i<=n; i++) {
            // i-3번째까지의 최적해 + 직전과 현재 포도주를 고른 경우 vs i-2번째까지의 최적해 + 현재 포도주를 고른 경우
            dp[i] = Math.max(dp[i-3]+arr[i-2]+arr[i-1], dp[i-2]+arr[i-1]);
            // i-1번째 까지의 최적해 vs 위의 결과
            dp[i] = Math.max(dp[i], dp[i-1]);
        }
        System.out.print(dp[n]);
    }
}
