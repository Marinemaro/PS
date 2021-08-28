package BOJ;

import java.io.*;
import java.util.*;

/*
문제 해결 아이디어 (투포인터) / 2467번과 매우 유사
1. 입력이 정렬되지 않은 상태로 들어오므로 먼저 정렬을 해준 뒤, 양 쪽 끝에서부터 서로 만나기 전까지
   음수라면 왼쪽 포인터 증가, 아니라면 오른쪽 포인터 감소로 O(NlogN) 시간 안에 답을 도출해낼 수 있다.
2. 이전의 최적해와 현재 값을 비교하여 현재 값이 더 적다면 A와 B에 각 인덱스를 저장하고, 최적해를 갱신한다.
 */

public class BOJ_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(a);

        int lo = 0;
        int hi = n-1;
        int A = lo;
        int B = hi;
        int before = Math.abs(a[A]+a[B]);
        while(lo < hi) {
            int abs = Math.abs(a[lo]+a[hi]);
            if(abs < before) {
                before = abs;
                A = lo;
                B = hi;
            }
            if(a[lo]+a[hi]==0) break;
            else if(a[lo]+a[hi] < 0) lo++;
            else hi--;
        }

        System.out.println(a[A]+" "+a[B]);
    }
}
