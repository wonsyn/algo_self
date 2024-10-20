import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static int[][] dir = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int I = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int curR = Integer.parseInt(st.nextToken());
            int curC = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int dR = Integer.parseInt(st.nextToken());
            int dC = Integer.parseInt(st.nextToken());

            bfs(I, curR, curC, dR, dC);
        }
        
        System.out.println(sb);
        br.close();
    }

    static void bfs(int I, int r, int c, int dr, int dc) {
        boolean[][] visited = new boolean[I][I];
        Queue<Node> q = new ArrayDeque<>();
        visited[r][c] = true;
        q.offer(new Node(r, c, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.r == dr && cur.c == dc) {
                sb.append(cur.cnt).append("\n");
                break;
            }

            for(int d = 0; d < 8; d++) {
                int nr = cur.r + dir[d][0];
                int nc = cur.c + dir[d][1];
                if(0 <= nr && nr < I && 0 <= nc && nc < I && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new Node(nr, nc, cur.cnt + 1));
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
