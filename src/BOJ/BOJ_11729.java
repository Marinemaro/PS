package BOJ;

import java.io.*;

/*
문제 해결 아이디어
1. n개의 원반을 A -> C 탑으로 이동시키기 위해서는 n-1개의 원반을 A -> B, n번째 원판을 C로, n-1개의 원반을 B -> C로 이동하면 된다.
   즉, n-1개의 원반을 시작점 -> 경유점으로 이동, 원반 n을 시작점 -> 목적지로 이동, n-1개의 원반을 경유점 -> 목적지로 이동
2. 함수 hanoi(n, A, B, C) = n개의 원반을 B를 경유하여 A -> C로 이동시키는 함수
   hanoi(n-1, A, C, B) = n-1개의 원반을 C를 경유하여 A -> B로 이동
   print(A, C) = 시작점 -> 목적지 과정 출력
   hanoi(n-1, B, A, C) = n-1개의 원반을 A를 경유하여 B -> C로 이동
3. 하노이 탑의 최소 이동 횟수는 2^n-1이므로 따로 함수 내에서 구하지 않고 값을 바로 출력하도록 한다.
 */

public class BOJ_11729 {
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
