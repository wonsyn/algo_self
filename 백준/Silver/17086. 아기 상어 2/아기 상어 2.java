import java.io.*;
import java.util.*;

public class Main {
    static int N, M, max = Integer.MIN_VALUE;
    static int[][] map,
    dir = {{-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 1) {
                    max = Math.max(max, 0);
                    continue;
                }
                bfs(i, j);
            }
        }

        System.out.println(max);
        br.close();
    }

    static void bfs(int x, int y) {
        Queue<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        visited[x][y] = true;
        q.offer(new Node(x, y, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            if((x != cur.r || y != cur.c) && map[cur.r][cur.c] == 1) {
                max = Math.max(max, cur.cnt);
                return;
            }

            for(int d = 0; d < 8; d++) {
                int nx = cur.r + dir[d][0];
                int ny = cur.c + dir[d][1];
                if(0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny, cur.cnt + 1));
                }
            }
        }
    }

    static class Node {
        int r, c;
        int cnt;
        Node(int r, int c, int cnt) {
            this.r = r; this.c = c;
            this.cnt = cnt;
        }
    }
}
