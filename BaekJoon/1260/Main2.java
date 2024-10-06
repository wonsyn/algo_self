package bj_1260_DFS와BFS;

import java.util.*;
import java.io.*;
public class Main2 {
    static StringBuilder sb;
    static boolean[][] graph;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/bj_1260_DFS와BFS/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[r][c] = graph[c][r] = true;
        }

        dfs(V);
        visited = new boolean[N + 1];
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
        br.close();
    }

    public static void dfs(int start) {
        sb.append(start).append(" ");
        visited[start] = true;
        for(int i = 1; i < graph.length; i++) {
            if(graph[start][i] && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        q.offer(start);

        while(!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" ");

            for(int i = 1; i < graph.length; i++) {
                if(graph[now][i] && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}
