package BOJ;

import java.io.*;

/*
문제 해결 아이디어
1. 2*1, 1*2, 1*1 크기의 타일로 채우는 경우의 수는 2*1 크기 벽의 경우, 2*1 1개 사용, 1*1 2개 사용으로 2가지 경우가 있으며,
   2*2 크기 벽의 경우, 2*1 2개 사용, 1*2 2개 사용, 1*2 1개와 1*1 2개 사용을 위/아래로, 2*1 1개와 1*1 2개 사용을 왼/오른쪽으로,
   1*1 4개 사용으로 7가지 경우가 있으므로, 이를 초깃값인 dp[0]과 dp[1]에 저장한다.
2. 이제 이를 크게 2*i-1의 경우, 2*i-2의 경우로 나누어서 보고, 2*i-1의 경우, 2*1 1개, 1*1 2개의 경우의 수가 있으며,
   2*i-2의 경우, 1*2 2개, 1*2 1개와 1*1 2개를 위/아래로 총 3개의 경우의 수가 있다.
3. 따라서 dp[i] = dp[i-1]*2 + dp[i-2]*3 라는 점화식을 세울 수 있다.
4. 하지만, 여기서 예외가 존재한다. 2*3의 경우,
   ㅇㅁㅁ  ㅁㅁㅇ
   ㅁㅁㅁ, ㅇㅁㅁ
   과 같은 모양이 가능하기 때문이다. 또한, 이는 2*4, 2*5, 2*n 모두 가능한 모양이다.
   따라서, DP를 2차원 배열로 만들고,
   (1칸 전의 예외(위에서 언급한 좌상단 모서리와 우상단 모서리)경우의 수 + 3칸 전의 경우의 수) * 2로 계산하면 된다.
   이를 점화식으로 나타내면 dp[i][0] = (dp[i-1][0] + dp[i-3][1])*2 로 세울 수 있다.
 */

public class BOJ_14852 {
    final static int MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 32);
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n+1][2];
        dp[1][1] = 2;
        if(n>1) {
            dp[2][1] = 7;
            dp[2][0] = 1;
        }
        for(int i=3; i<=n; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-3][1])%MOD;
            dp[i][1] = (dp[i][0]*2 + dp[i-1][1]*2 + dp[i-2][1]*3)%MOD;
        }
        System.out.println(dp[n][1]);
    }
}
