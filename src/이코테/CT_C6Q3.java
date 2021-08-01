package 이코테;

import java.io.*;
import java.util.Arrays;

// 이것이 코딩 테스트다 챕터 6 - 3번째 문제 : 두 배열의 원소 교체

public class CT_C6Q3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int k = Integer.parseInt(in[1]);

        int[] a = new int[n];
        int[] b = new int[n];

        in = br.readLine().split(" ");
        for(int i=0; i<n; i++) a[i] = Integer.parseInt(in[i]);
        in = br.readLine().split(" ");
        for(int i=0; i<n; i++) b[i] = Integer.parseInt(in[i]);

        Arrays.sort(a);
        Arrays.sort(b);
        for(int i=0; i<k; i++)
            if(a[i]<b[n-i-1]) a[i] = b[n-i-1];
            else break;

        long sum = 0;
        for(int i : a) sum += i;

        System.out.println(sum);
    }
}
