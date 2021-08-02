package 이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이것이 코딩 테스트다 챕터 7 - 2번째 문제 : 떡볶이 떡 만들기

public class CT_C7Q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        int[] arr = new int[n];
        in = br.readLine().split(" ");

        int max = 0;
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(in[i]);
            if(max < arr[i]) max = arr[i];
        }

        long lo = 1;
        long hi = max;
        long ans = 0;
        while(lo <= hi) {
            long mid = (lo+hi)/2;
            long sum = 0;
            for(int a : arr)
                if(a > mid) sum += a-mid;
            if(sum >= m) {
                ans = Math.max(ans, mid);
                lo = mid+1;
            } else hi = mid-1;
        }

        System.out.println(ans);
    }
}
