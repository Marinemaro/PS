package 이코테;

import java.io.*;
import java.util.StringTokenizer;

// 이것이 코딩 테스트다 챕터 4 - 1번째 문제 : 상하좌우

public class CT_C4Q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int x = 1, y = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            char code = st.nextToken().charAt(0);
            switch(code) {
                case 'R': if(x<n) x++; break;
                case 'U': if(y>1) y--; break;
                case 'L': if(x>1) x--; break;
                case 'D': if(y<n) y++; break;
            }
        }

        System.out.println(y+" "+x);
    }
}
