import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int r = 0;
        int c = 0;
        boolean[][] map = new boolean[N][M];
        map[r][c] = true;

        int cnt = 0;
        int d = 0;
        while(true) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if(0 > nr || nr >= N || 0 > nc || nc >= M || map[nr][nc]) {
                if(!isPossible(r, c, map)) break;
                d = (d + 1) % 4;
                cnt++;
                continue;
            }
            map[nr][nc] = true;
            r = nr; c = nc;
        }

        System.out.println(cnt);
        br.close();
    }

    static boolean isPossible(int r, int c, boolean[][] map) {
        for(int d = 0; d < 4; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if(0 <= nr && nr < N && 0 <= nc && nc < M && !map[nr][nc]) {
                return true;
            }
        }
        return false;
    }
}
