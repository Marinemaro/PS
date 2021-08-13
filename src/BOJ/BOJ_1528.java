package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
문제 해결 아이디어
1. 최대 입력값까지의 금민수 리스트를 구하는 전처리 과정 넣기
2. 현재 입력값까지 금민수를 사용하여 표현할 수 있는지 DP를 통해 금민수의 최소 사용 개수 dp[n]을 구함
3. 표현할 수 없다면, 즉 dp[n]값이 무한이라면 -1 출력, 표현할 수 있다면, 즉 dp[n]값이 무한이 아니라면 다음 단계 진행
4. 어떤 금민수가 사용되었는지 dp 테이블에서 금민수 리스트에 저장된 수들을 통해 역추적
   여기서 dp[n-t] 값이 무한이 아니라면, 금민수 t를 사용했다는 의미이다.
   역추적 과정에서 가장 작은 값을 찾고, 작은 값이 여러개일 경우, 가장 작은 인덱스를 추적
5. ans 리스트에 저장된 값을 정렬하고 출력하면 정답이다.
 */

public class BOJ_1528 {
    public static ArrayList<Integer> list = new ArrayList<>();
    public static void f(int i) {
        if(i>=1_000_000) return;
        list.add(i);
        f(i *10+4);
        f(i *10+7);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        f(4);
        f(7);
        Collections.sort(list);

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i : list)
            for(int j=i; j<=n; j++)
                if(dp[j-i] != Integer.MAX_VALUE) dp[j] = Math.min(dp[j], dp[j-i]+1);

        if(dp[n]==Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while(n!=0) {
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            for(int i=0; i<list.size(); i++) {
                int t = list.get(i);
                if(n-t >= 0 && dp[n-t] != Integer.MAX_VALUE && min > dp[n-t]) {
                    min = dp[n-t];
                    minIdx = i;
                }
            }
            if(min == Integer.MAX_VALUE) break;
            n -= list.get(minIdx);
            ans.add(list.get(minIdx));
        }

        Collections.sort(ans);

        for(int i : ans) System.out.print(i+" ");
    }
}
