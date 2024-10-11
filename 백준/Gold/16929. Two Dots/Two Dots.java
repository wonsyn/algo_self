import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static boolean isPossible;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        isPossible = false;

        for(int i = 0; i < N; i++) {
            if(isPossible) break;
            for(int j = 0; j < M; j++) {
                if(isPossible) break;
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j, map[i][j], 1, i, j);
                }
            }
        }

        System.out.println(isPossible? "Yes" : "No");
    }

    static void dfs(int x, int y, char color, int size, int startX, int startY) {
        if(isPossible) return;

        for(int d = 0; d < 4; d++) {
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];
            if(0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] == color) {
                if(nx == startX && ny == startY && size >= 4) {
                    isPossible = true;
                    return;
                }
                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, color, size + 1, startX, startY);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}
