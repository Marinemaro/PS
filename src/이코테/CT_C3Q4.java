package 이코테;

import java.io.*;
import java.util.*;

// 이것이 코딩 테스트다 챕터 3 - 4번째 문제 : 1이 될 때까지

public class CT_C3Q4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        while(n>1) {
            if(n%k==0) {
                n/=k;
                cnt++;
            }
            else {
                int m = n%k;
                n-=m;
                cnt+=m;
            }
        }

        System.out.println(cnt);
    }
}

