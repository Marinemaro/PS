package BOJ;

import java.io.*;

/*
문제 해결 아이디어
1. 파라메트릭 서치 유형 문제이므로, 최소 상한액과 최대 상한액을 구한 후 이분탐색을 돌리면 된다.
2. 최소 상한액은 1, 최대 상한액은 각 지방의 예산요청들 중 최대값을 저장한다.
3. 최소 상한액(lo)과 최대 상한액(hi)의 중간 값(mi)을 현재 상한액으로 정한 후 반복문을 돌려 합(sum)을 계산한다.
4. 반복문이 끝난 후 sum이 총 예산(total) 보다 크다면 답이 될 수 없으므로,
   hi 값을 줄임으로써 mi 값을 내리면 되고, total과 같거나 작다면 답이 될 수 있으므로,
   현재 최대값(ans)와 비교하여 더 큰 값을 저장한 후, lo 값을 늘림으로써 mi 값을 올려주면 된다.
 */

public class BOJ_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");
        int[] a = new int[n];
        int lo = 1;
        int hi = 0;
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(in[i]);
            hi = Math.max(hi, a[i]);
        }
        int total = Integer.parseInt(br.readLine());
        int ans = 0;
        while(lo<=hi) {
            int mi = (lo+hi)/2;
            int sum = 0;
            for(int i=0; i<n; i++) sum += Math.min(a[i], mi);
            if(sum > total) hi = mi-1;
            else {
                ans = Math.max(ans, mi);
                lo = mi+1;
            }
        }
        System.out.println(ans);
    }
}
