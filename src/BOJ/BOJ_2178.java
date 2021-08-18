package BOJ;

import java.io.*;
import java.util.*;

/*
문제 해결 아이디어
1. 좌표를 저장할 Coord 클래스 생성 (java.awt.Point 클래스를 사용해도 무방)
2. 방향벡터 배열을 생성하고, 전체 맵 상태를 저장할 map[][] 배열 생성 후 초기화
3. Queue에 시작 위치 (0,0)을 넣고 방향벡터를 통해 4방향 bfs 탐색 시도
4. 만약, 인덱스 nx와 ny가 Out of Bounds가 아니고, map[nx][ny] (현재 보고있는 칸)이 1이라면
   visit 하지 않았다는 의미이므로 이전 칸의 값을 더해주고, Queue에 추가해준다.
5. 위 과정이 끝나고 Queue가 비게 되면 map의 가장 오른쪽 아래에 저장된 값이 정답이다.
 */

public class BOJ_2178 {
    static class Coord {
        private final int x;
        private final int y;
        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int getX() { return x; }
        public int getY() { return y; }
    }
    public static void main(String[] args) throws IOException {
        final int[] dx = {0, 1, 0, -1};
        final int[] dy = {1, 0, -1, 0};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        int[][] map = new int[n][m];
        for(int i=0; i<n; i++) {
            String row = br.readLine();
            for(int j=0; j<m; j++) map[i][j] = row.charAt(j)-'0';
        }
        Queue<Coord> q = new ArrayDeque<>();
        q.add(new Coord(0, 0));
        while(!q.isEmpty()) {
            Coord curr = q.poll();
            int x = curr.getX();
            int y = curr.getY();
            for(int i=0; i<4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 1) {
                    map[nx][ny] += map[x][y];
                    q.add(new Coord(nx, ny));
                }
            }
        }
        System.out.println(map[n-1][m-1]);
    }
}
