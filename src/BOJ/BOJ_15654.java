package BOJ;

import java.io.*;
import java.util.Arrays;

/*
문제 해결 아이디어
1. boolean형 배열 v[]로 visit 체크, depth가 m에 도달했다면 tmp[] 에 저장된 모든 값을 출력한다.
 */

public class BOJ_15654 {
    static int m;
    static int[] tmp;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void f(int[] a, boolean[] v, int depth) throws IOException {
        if(m > depth){
            for(int i=0; i<a.length; i++) {
                if(!v[i]) {
                    v[i] = true;
                    tmp[depth] = a[i];
                    f(a, v, depth+1);
                    v[i] = false;
                }
            }
        } else {
            for(int i : tmp) bw.write(i+" ");
            bw.newLine();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        int[] a = new int[n];
        in = br.readLine().split(" ");
        for(int i=0; i<n; i++) a[i] = Integer.parseInt(in[i]);
        boolean[] v = new boolean[n];
        Arrays.sort(a);
        tmp = new int[m];
        f(a, v, 0);
        bw.flush();
    }
}
