package BOJ;

import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static void hanoi(int n, int from, int mid, int to) throws IOException {
        if(n>0) {
            hanoi(n-1, from, to, mid);
            bw.write(from+" "+to+"\n");
            hanoi(n-1, mid, from, to);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        bw.write((2<<n-1)-1+"\n");
        hanoi(n, 1, 2,3);
        bw.flush();
    }
}
