package bj_2178_미로탐색;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, count;
    static boolean[][] possible, visited;
    static int[][] dir = {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/bj_2178_미로탐색/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        possible = new boolean[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                if(str.charAt(j) == '1') {
                    possible[i][j] = true;
                }
            }
        }

        bfs();
        System.out.println(count);
        br.close();
    }

    static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        visited[0][0] = true;
        q.offer(new int[] {0, 0, 1});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] == N - 1 && cur[1] == M - 1) {
                count = cur[2];
                return;
            }

            for(int d = 0; d < 4; d++) {
                int r = cur[0] + dir[d][0];
                int c = cur[1] + dir[d][1];
                if(r >= 0 && r < N && c >= 0 && c < M && possible[r][c] && !visited[r][c]) {
                    visited[r][c] = true;
                    q.offer(new int[] {r, c, cur[2] + 1});
                }
            }
        }
    }
}
