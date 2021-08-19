package BOJ;

import java.io.*;
import java.util.*;

/*
문제 해결 아이디어
1. F개의 요소로 이루어진 map[] 배열 생성 후, INF 값으로 초기화해준다.
2. 시작 위치를 Queue 에 넣고 BFS를 돌린다.
3. Queue의 top 값을 poll() 하고, top 값을 현재 층 변수(curr)에 저장한 후,
   현재 층이 g(목표 층)에 도달했다면, 반복문을 탈출한다.
4. 현재 층에서 u층 만큼 올라갔을 때 f보다 작거나 같다면(out of bounds가 아니라면)
   curr+u번 요소가 INF인지 확인하고, INF라면 현재 층까지 누른 횟수+1 값을 curr+u 층에 저장한 후 curr-d를 Queue에 add한다.
5. 현재 층에서 d층 만큼 내려갔을 때, 0보다 크다면(out of bounds가 아니라면)
   curr-d번 요소가 INF인지 확인하고, INF라면 현재 층까지 누른 횟수+1 값을 curr-d 층에 저장한 후 curr-d를 Queue에 add한다.
6. 반복문이 종료되면 map[g]의 값을 확인하는데, INF라면 도달한 적이 없다는 뜻이므로 "use the stairs" 출력, 아니라면 map[g]를 출력한다.
 */

public class BOJ_5014 {
    final static int INF = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int f = Integer.parseInt(in[0]);
        int s = Integer.parseInt(in[1]);
        int g = Integer.parseInt(in[2]);
        int u = Integer.parseInt(in[3]);
        int d = Integer.parseInt(in[4]);

        int[] map = new int[f+1];
        Arrays.fill(map, INF);
        Queue<Integer> q = new ArrayDeque<>();

        q.add(s);
        map[s] = 0;

        while(!q.isEmpty()) {
            int curr = q.poll();
            if(curr == g) break;
            int nu = curr+u;
            int nd = curr-d;
            if(nu <= f && map[nu]==INF) {
                map[nu] = map[curr]+1;
                q.add(nu);
            }
            if(nd > 0 && map[nd]==INF) {
                map[nd] = map[curr]+1;
                q.add(nd);
            }
        }

        System.out.println(map[g]==INF?"use the stairs":map[g]);
    }
}
