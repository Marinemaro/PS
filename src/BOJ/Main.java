package BOJ;

import java.io.*;
import java.util.*;

public class Main {
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
