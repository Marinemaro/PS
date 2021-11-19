package BOJ;

import java.io.*;

public class BOJ_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] in = br.readLine().split(" ");

        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        int[][] map = new int[n+1][n+1];

        for(int i=0; i<n; i++) {
            in = br.readLine().split(" ");
            for(int j=0; j<n; j++)
                map[i+1][j+1] = map[i][j+1] + map[i+1][j] + Integer.parseInt(in[j]) - map[i][j];
        }

        for(int i=0; i<m; i++) {
            in = br.readLine().split(" ");
            int x1 = Integer.parseInt(in[0]);
            int y1 = Integer.parseInt(in[1]);
            int x2 = Integer.parseInt(in[2]);
            int y2 = Integer.parseInt(in[3]);
            bw.write((map[x2][y2]-map[x2][y1-1]-map[x1-1][y2]+map[x1-1][y1-1])+"\n");
        }

        bw.flush();
    }
}
