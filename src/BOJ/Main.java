package BOJ;

import java.io.*;
import java.util.*;

public class Main {
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
