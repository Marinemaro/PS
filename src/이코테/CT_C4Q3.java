package 이코테;

import java.io.*;

// 이것이 코딩 테스트다 챕터 4 - 3번째 문제 : 왕실의 나이트

public class CT_C4Q3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();

        int[] dx = {2, 2, 1, 1, -2, -2, -1, -1};
        int[] dy = {1, -1, 2, -2, 1, -1, 2, -2};

        int ans = 0;
        int r = in.charAt(1)-'0'-1;
        int c = in.charAt(0)-'a';

        for(int i=0; i<8; i++)
            if(check(c+dx[i], r+dy[i])) ans++;
        System.out.println(ans);
    }
    public static boolean check(int x, int y) { return x>=0 && x<8 && y>=0 && y<8; }
}
