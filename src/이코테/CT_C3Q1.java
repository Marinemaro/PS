package 이코테;

import java.io.*;

// 이것이 코딩 테스트다 챕터 3 - 1번째 문제 : 거스름돈

public class CT_C3Q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        int ans = 0;
        int[] coins = {500, 100, 50, 10};

        for(int c : coins) {
            ans +=money/c;
            money%=c;
        }

        System.out.println(ans);
    }
}