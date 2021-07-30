package 이코테;

import java.io.*;
import java.util.StringTokenizer;

// 이것이 코딩 테스트다 챕터 5 - 1번째 문제 : 음료수 얼려 먹기

public class CT_C5Q1 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void dfs(int[][] map, int x, int y) {
        map[x][y] = 1;
        for(int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<map.length && ny>=0 && ny<map[0].length && map[nx][ny]!=1) dfs(map, nx, ny);
        }
    }
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

        int ans = 0;
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                if(map[i][j]==0) {
                    ans++;
                    dfs(map, i, j);
                }

        System.out.println(ans);
    }
}

/*
15 14
00000111100000
11111101111110
11011101101110
11011101100000
11011111111111
11011111111100
11000000011111
01111111111111
00000000011111
01111111111000
00011111111000
00000001111000
11111111110011
11100011111111
11100011111111

=> 8
 */
