package bj_1261_알고스팟;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, ans;
    static boolean[][] map;
    static int[][] visited;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};


    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/bj_1261_알고스팟/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new boolean[N + 1][M + 1];
        visited = new int[N + 1][M + 1];

        for(int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        ans = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i + 1][j + 1] = line.charAt(j) == '1';
            }
        }

        bfs(1, 1);
        System.out.println(ans);
        br.close();
    }

    static void bfs(int r, int c) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(r, c, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.r == N && cur.c == M) {
                ans = Math.min(ans, cur.crash);
                continue;
            }

            for(int d = 0; d < 4; d++) {
                int nr = cur.r + dir[d][0];
                int nc = cur.c + dir[d][1];
                if(nr > 0 && nr <= N && nc > 0 && nc <= M) {
                    if(visited[nr][nc] > cur.crash && !map[nr][nc]) {
                        visited[nr][nc] = cur.crash;
                        q.offer(new Node(nr, nc, cur.crash));
                    } else if(cur.crash + 1 <= N * M && visited[nr][nc] > cur.crash + 1 && map[nr][nc]) {
                        visited[nr][nc] = cur.crash + 1;
                        q.offer(new Node(nr, nc, cur.crash + 1));
                    }
                }
            }
        }
    }

    static class Node {
        int r;
        int c;
        int crash;

        Node(int r, int c, int crash) {
            this.r = r;
            this.c = c;
            this.crash = crash;
        }
    }
}
