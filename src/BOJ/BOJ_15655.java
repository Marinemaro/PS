package BOJ;

import java.io.*;
import java.util.Arrays;

/*
문제 해결 아이디어
1. 같은 수가 중복하여 출력되면 안되므로 visit[] 역할을 하는 boolean형 배열을 만든다.
2. 고른 수열은 오름차순이어야 하므로 현재 깊이가 0이거나 바로 이전 깊이의 수보다 현재 수가 크다면
   배열의 현재 깊이에 수를 저장하고 깊이에 1을 더한 뒤 재귀호출한다.
3. 현재 깊이가 m에 도달했다면 수열에 저장된 모든 값을 출력한다.
 */

public class BOJ_15655 {
    static int n, m;
    static int[] a;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void f(int depth, boolean[] v, int[] arr) throws IOException {
        if(depth == m) {
            for(int i=0; i<m; i++) bw.write(arr[i]+" ");
            bw.newLine();
        } else {
            for(int i=0; i<n; i++) {
                if(!v[i] && (depth==0 || arr[depth-1]<a[i])) {
                    v[i] = true;
                    arr[depth] = a[i];
                    f(depth+1, v, arr);
                    v[i] = false;
                    arr[depth] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");

        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        a = new int[n];

        in = br.readLine().split(" ");
        for(int i=0; i<n; i++) a[i] = Integer.parseInt(in[i]);
        boolean[] v = new boolean[n];
        int[] arr = new int[m];
        Arrays.sort(a);

        f(0, v, arr);
        bw.flush();
    }
}
