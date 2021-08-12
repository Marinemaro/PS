package BOJ;

/*
문제 해결 아이디어
1. 입력의 크기 n 만큼의 배열 생성
2. 배열을 오름차순으로 정렬한 후 현재 등수(i값)와 예상 등수(a[i-1])의 절댓값을 변수 sum 에 저장
3. sum 출력
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i=0; i<n; i++) a[i] = Integer.parseInt(br.readLine());

        Arrays.sort(a);

        long sum = 0;
        for(int i=0; i<n; i++) sum += Math.abs(i+1-a[i]);

        System.out.print(sum);
    }
}
