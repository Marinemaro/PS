package 이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이것이 코딩 테스트다 챕터 8 - 1번째 문제 : 1로 만들기

public class CT_C8Q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1]+1;
            if(i%2==0) dp[i] = Math.min(dp[i], dp[i/2]+1);
            if(i%3==0) dp[i] = Math.min(dp[i], dp[i/3]+1);
            if(i%5==0) dp[i] = Math.min(dp[i], dp[i/5]+1);
        }
        System.out.println(dp[n]);
    }
}
