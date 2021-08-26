package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_9742 {
    public static boolean nextPermutation(char[] c) {
        int idx = -1;   // 초기 인덱스는 -1
        // 1. 마지막부터 탐색하여 가장 처음 만나는 [i] < [i+1]를 찾고, idx 변수에 i 저장
        for(int i=c.length-1; i>0; i--)
            if(c[i-1]<c[i]) {
                idx = i-1;
                break;
            }
        // 2. idx 변수가 갱신되지 않았다면 false 반환
        if(idx < 0) return false;
        // 3. 가장 끝에 나오는 [idx] < [j]를 찾고, 찾음과 동시에 [idx]와 [j]를 swap 후 break
        // * 이미 [i] < [i+1]가 true 이므로 [idx] < [j]를 만족하는 [j]는 무조건 찾아진다.
        for(int j = c.length-1; j>= idx; j--)
            if(c[j]>c[idx]) {
                swap(c, j, idx);
                break;
            }
        // 4. [idx+1] 부터 [length-1]까지 reverse 해준다.
        idx++;
        int j = c.length-1;
        while(idx < j) swap(c, idx++, j--);
        return true;
    }
    public static void swap(char[] c, int a, int b) {
        char t = c[a];
        c[a] = c[b];
        c[b] = t;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] f = new int[10];
        f[0] = 1;
        for(int i=1; i<10; i++) f[i] = f[i-1]*(i+1);

        String str;
        while((str = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(str);
            char[] s = st.nextToken().toCharArray();
            int max = Integer.parseInt(st.nextToken());
            int cnt = 1;
            bw.write(s);
            bw.write(" "+max+" = ");
            if(max > f[s.length-1]) bw.write("No permutation\n");
            else do {
                if(cnt == max) {
                    bw.write(s);
                    bw.newLine();
                    break;
                } cnt++;
            } while(nextPermutation(s));
        }
        bw.flush();
    }
}
