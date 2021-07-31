package 이코테;

import java.awt.*;
import java.io.*;
import java.util.*;

// 이것이 코딩 테스트다 챕터 5 - 2번째 문제 : 미로 탈출

public class CT_C5Q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");

        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        int[][] map = new int[n][m];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), "01", true);
            for(int j=0; j<m; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));

        while(!q.isEmpty()) {
            Point curr = q.poll();
            int r = curr.x;
            int c = curr.y;
            for(int i=0; i<4; i++) {
                int nr = r+dr[i];
                int nc = c+dc[i];
                if(nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length && map[nr][nc]==1) {
                    map[nr][nc] = map[r][c]+1;
                    q.add(new Point(nr, nc));
                }
            }
        }

        System.out.println(map[n-1][m-1]);
    }
}
