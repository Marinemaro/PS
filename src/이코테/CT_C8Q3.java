package 이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이것이 코딩 테스트다 챕터 8 - 3번째 문제 : 바닥 공사

public class CT_C8Q3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 3;
        for(int i=2; i<n; i++) dp[i] = (dp[i-1]+dp[i-2]*2)%796796;
        System.out.println(dp[n-1]);
    }
}
