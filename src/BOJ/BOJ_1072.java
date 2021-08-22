package BOJ;

import java.io.*;

/*
문제 해결 아이디어
1. 전체 게임 횟수는 고정된 것이 아니다! 이걸 몰라서 오랫동안 헤맸다...
2. 앞으로의 모든 게임에서 지지 않으므로, 처음 구한 승률에서 더 커진 승률의 경우(ex. 80% -> 81%)만 체크하면 된다.
3. 추가 게임 횟수를 1부터 10억 사이로 두고, (이긴 게임+추가 게임)*100/(전체 게임+추가 게임)이 기존 승률에 비해
   커지는지에 대해 이분탐색으로 탐색하다가 만약 조건이 맞다면 cnt 변수를 갱신하게끔 하면 cnt에 저장된 마지막 값이 정답이다.
 */

public class BOJ_1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        long x = Long.parseLong(in[0]);
        long y = Long.parseLong(in[1]);
        long z = y*100/x;

        long lo = 1;
        long hi = 1000000000;
        long cnt = -1;
        while(lo <= hi) {
            long mid = (lo+hi)/2;
            long v = (y+mid)*100/(x+mid);
            if(v > z) {
                cnt = mid;
                hi = mid-1;
            } else lo = mid+1;
        }

        System.out.println(cnt);
    }
}
