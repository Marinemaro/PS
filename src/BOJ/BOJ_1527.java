package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
문제 해결 아이디어
1. 최대 입력값만큼 금민수의 개수를 구하는 전처리 과정 넣기
2. 쿼리에 따른 결과값 출력
 */

public class BOJ_1527 {
    public static ArrayList<Long> list = new ArrayList<>();
    public static void f(long l) {
        if(l>=1_000_000_000) return;
        list.add(l);
        f(l*10+4);
        f(l*10+7);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        f(4);
        f(7);
        Collections.sort(list);

        String[] in = br.readLine().split(" ");
        int a = Integer.parseInt(in[0]);
        int b = Integer.parseInt(in[1]);

        int cnt = 0;
        for(long l : list)
            if(a <= l && b >= l) cnt++;

        System.out.println(cnt);
    }
}
