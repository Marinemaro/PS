package BOJ;

import java.io.*;
import java.util.*;

/*
문제 해결 아이디어 (BFS)
1. 7576번 토마토 문제의 3차원 버전으로, 가중치가 없는 그래프에서 다중 시작점으로부터 모든 칸까지의 최단 거리를 구하는 문제.
2. 토마토가 있을 수 있는 전체 수는 h*n*m개로, 만약 0이 아닌 -1 또는 1 값으로 가득 차게 된다면,
   더이상 익을 토마토가 없으므로 0을 출력한다.
3. 큐에 익은 토마토의 좌표를 저장하고, 한 번에 q.size() (시작점의 개수)만큼
   인접한 토마토에 현재 토마토의 값+1을 저장하고, q에 현재 좌표를 offer()한다.
4. 위 과정이 끝나고 map[][][]을 완전탐색하여 0이 있다면 -1 출력, 없다면 최대 값-1을 출력하면 정답이다.
 */

public class BOJ_7569 {
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dy = {1, 0, -1, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static class Coord {
        int x;
        int y;
        int z;
        public Coord(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static void main(String[] args) throws IOException {
        MaroReader mr = new MaroReader(65536, 16, false);
        int m = mr.nextInt();
        int n = mr.nextInt();
        int h = mr.nextInt();

        int[][][] map = new int[h][n][m];
        int totalCnt = h*n*m;
        Queue<Coord> q = new ArrayDeque<>();

        for(int i=0; i<h; i++)
            for(int j=0; j<n; j++)
                for(int k=0; k<m; k++) {
                    map[i][j][k] = mr.nextInt();
                    if(map[i][j][k] != 0) totalCnt--;
                    if(map[i][j][k] == 1) q.offer(new Coord(k, j, i));
                }

        if(totalCnt == 0) {
            System.out.print(0);
            return;
        }

        while(!q.isEmpty()) {
            int size = q.size();
            while(size-->0) {
                Coord curr = q.poll();
                for(int i=0; i<6; i++) {
                    assert curr != null;
                    int x = curr.x;
                    int y = curr.y;
                    int z = curr.z;
                    int nx = x+dx[i];
                    int ny = y+dy[i];
                    int nz = z+dz[i];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n && nz >= 0 && nz < h && map[nz][ny][nx]==0) {
                        map[nz][ny][nx] = map[z][y][x]+1;
                        q.add(new Coord(nx, ny, nz));
                    }
                }
            }
        }

        int max = 0;
        for(int[][] sur : map)
            for(int[] row : sur)
                for(int i : row)
                    if(i == 0) {
                        System.out.print(-1);
                        return;
                    } else max = Math.max(max, i);

        System.out.print(max-1);
    }
}
