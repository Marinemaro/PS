package BOJ;

import java.io.*;

/*
문제 해결 아이디어
1. 조건에만 맞게끔 브루트포스식 단순 구현. 추후 수정 예정.
 */

public class BOJ_1526 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        OUTER:
        for(int i=n; i>0; i--) {
            int a = i;
            while(a>0) {
                if(a%10!=4 && a%10!=7) continue OUTER;
                a/=10;
            }
            System.out.print(i);
            return;
        }
    }
}
