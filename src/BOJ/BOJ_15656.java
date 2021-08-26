package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_15656 {
    static int n, m;
    static int[] a;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void f(int depth, int[] arr) throws IOException {
        if(depth == m) {
            for(int i=0; i<m; i++) bw.write(arr[i]+" ");
            bw.newLine();
        } else {
            for(int i=0; i<n; i++) {
                arr[depth] = a[i];
                f(depth+1, arr);
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
        int[] arr = new int[m];
        Arrays.sort(a);

        f(0, arr);
        bw.flush();
    }
}

