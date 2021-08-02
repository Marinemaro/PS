package TEST;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 3;
        for(int i=2; i<n; i++)
            dp[i] = (dp[i-1]+dp[i-2]*2)%10007;
        System.out.println(dp[n-1]);
    }
}