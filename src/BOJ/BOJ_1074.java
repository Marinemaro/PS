package BOJ;

import java.io.*;

/*
문제 해결 아이디어
1. 2*2 크기의 2차원 배열이 될 때 까지 사분면으로 나누기
2. 한 사분면에서 왼쪽 사분면으로 이동하면 (사분면의 변 길의)^2의 차이가 나고,
3. 한 사분면에서 위쪽 사분면으로 이동하면 (사분면의 변 길의)^2*2의 차이가 나는 성질을 활용.
4. 따라서 m*m(2번값)과 m*m*2(3번값)의 합과 가장 작은 2차원 배열(2*2크기)의 현재 요소 값을 더한 값이 정답이다.
 */

public class BOJ_1074 {
    public static int z(int m, int r, int c) {
        int sum = 0;
        int[][] map = {{0, 1},{2, 3}};
        while(m>=2){
            if(m<=r) {
                r-=m;
                sum+=m*m*2;
            }
            if(m<=c) {
                c-=m;
                sum+=m*m;
            }
            m/=2;
        }
        return map[r][c]+sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int r = Integer.parseInt(in[1]);
        int c = Integer.parseInt(in[2]);
        int m = 2 << n;
        System.out.println(z(m/2, r, c));
    }
}