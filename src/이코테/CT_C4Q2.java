package 이코테;

import java.io.*;

// 이것이 코딩 테스트다 챕터 4 - 2번째 문제 : 시각

public class CT_C4Q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int i=0; i<=n; i++) {
            if(i%10==3) sum+=3600;
            else sum+=45*15+15*60;
        }
        System.out.println(sum);
    }
}
