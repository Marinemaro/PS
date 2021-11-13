package BOJ;

import java.io.*;
import java.util.Arrays;

/*
문제 해결 아이디어
1. 이전 문제들과는 달리 수가 '중복되어' 입력된다.
   또한, 정렬되어있지 않으므로, 사전 순으로 증가하는 출력을 위해 정렬을 해준다.
2. "이전 수열의 마지막 항과 새로 추가할 값이 같다면 중복된 수열"이 되므로,
   이전 수열의 마지막 항을 저장할 변수 before를 생성하고, 새로 추가할 값 a[i]와 비교하면 된다.
3. 수를 중복하여 선택할 수 없으므로, visit[] 역할을 하는 boolean[]형 v를 만들어 위의 before와 함께 체크하여
   조건에 맞는 수만 tmp[] 에 넣고 출력할 수 있게끔 하면 된다.
4. 비내림차순 조건을 만족하기 위해 depth가 0인 경우 또는 depth가 1 이상인 경우에
   이전 요소 tmp[depth-1]와 현재 요소 a[i]를 비교하여 a[i]가 더 크거나 같은 경우에만 tmp[depth]를 갱신하게 한다.
 */

public class BOJ_15664 {
    static int n;
    static int m;
    static int[] a;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void f(boolean[] v, int[] p, int depth) throws IOException {
        if(depth == m) {
            for(int i=0; i<m; i++) bw.write(p[i]+" ");
            bw.newLine();
        }
        else {
            int before = 0;
            for(int i=0; i<n; i++) {
                if(!v[i] && (before != a[i]) && (depth==0 || p[depth-1]<=a[i])) {
                    v[i] = true;
                    before = a[i];
                    p[depth] = a[i];
                    f(v, p, depth + 1);
                    v[i] = false;
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
        Arrays.sort(a);

        boolean[] v = new boolean[n];
        int[] tmp = new int[m];
        f(v, tmp, 0);

        bw.flush();
    }
}
