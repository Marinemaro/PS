package 이코테;

import java.io.*;

// 이것이 코딩 테스트다 챕터 4 - 4번째 문제 : 게임 개발

public class CT_C4Q4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        in = br.readLine().split(" ");
        int y = Integer.parseInt(in[0]);
        int x = Integer.parseInt(in[1]);
        int d = Integer.parseInt(in[2]);

        int[][] map = new int[n][m];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        for(int i=0; i<n; i++) {
            in = br.readLine().split(" ");
            for(int j=0; j<m; j++) map[i][j] = Integer.parseInt(in[j]);
        }

        int cnt = 1;
        map[y][x] = 2;

        OUTER:
        while(true) {
            for(int i=0; i<4; i++) {
                d = turnLeft(d);
                int nx = x+dx[d];
                int ny = y+dy[d];
                if(map[ny][nx]==0) {
                    y = ny;
                    x = nx;
                    cnt++;
                    map[y][x] = 2;
                    continue OUTER;
                }
            }
            y = y-dy[d];
            x = x-dx[d];
            if(map[y][x]==1) break;
        }

        System.out.println(cnt);
    }
    public static int turnLeft(int d) { return d-1<0?3:d-1; }
}
