package BOJ;

import java.io.*;
import java.util.Arrays;

/*
문제 해결 아이디어
1. 같은 수를 여러 번 고를 수 있기 때문에 visit[] 배열은 만들지 않는다.
2. 깊이가 0(첫 호출) 이거나 이전에 저장된 수보다 크거나 같다면 '비내림차순' 조건에 해당하므로,
   arr[] 배열에 현재 깊이를 인덱스로 삼고 현재 수를 저장한 후 깊이를 늘려가며 재귀호출을 한다.
3. 만약 현재 깊이가 m에 도달했다면, arr[]에 저장된 모든 값을 출력하도록 한다.
4. 이전에 저장된 수가 다음 반복 때 영향을 주지 않게끔 재귀호출을 빠져나왔다면 현재 깊이에 저장된 수를 0으로 초기화해준다.
 */

public class BOJ_15657 {
    static int n, m;
    static int[] a;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void f(int depth, int[] arr) throws IOException {
        if(depth == m) {
            for(int i=0; i<m; i++) bw.write(arr[i]+" ");
            bw.newLine();
        } else {
            for(int i=0; i<n; i++) {
                if(depth==0 || arr[depth-1]<=a[i]) {
                    arr[depth] = a[i];
                    f(depth+1, arr);
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

        f(0, arr);
        bw.flush();
    }
}
