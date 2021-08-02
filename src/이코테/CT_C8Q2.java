package 이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이것이 코딩 테스트다 챕터 8 - 2번째 문제 : 개미 전사

public class CT_C8Q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] map = new int[n];
        String[] in = br.readLine().split(" ");
        for(int i=0; i<n; i++)
            map[i] = Integer.parseInt(in[i]);
        int[] dp = new int[n];
        dp[0] = map[0];
        dp[1] = Math.max(map[0], map[1]);
        for(int i=2; i<n; i++)
            dp[i]=Math.max(dp[i-1], map[i]+dp[i-2]);    // max(현상 유지, 현재 창고의 값 + 2칸 이전까지의 최적해);
        System.out.println(dp[n-1]);
    }
}
