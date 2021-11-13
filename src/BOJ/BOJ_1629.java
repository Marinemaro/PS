package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
문제 해결 아이디어
1. 분할정복 제곱 구현 후 c로 나누는 과정만 추가해주면 된다.
 */

public class BOJ_1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        long a = Integer.parseInt(in[0]);
        long b = Integer.parseInt(in[1]);
        long c = Integer.parseInt(in[2]);
        System.out.println(pow(a,b,c));
    }

    private static long pow(long a, long b, long c) {
        if(b==1) return a % c;
        if(b%2==0) {
            long v = pow(a, b/2, c);
            return (v%c) * (v%c) % c;
        }
        return (a%c) * (pow(a, b-1, c)%c) % c;
    }
}
