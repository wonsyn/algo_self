package bj_1707_이분그래프;

import java.util.*;
import java.io.*;

public class Main {
    static int K, V, E;
    static ArrayList<Integer>[] adjL;
    static int[] visited;
    static boolean ans;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/bj_1707_이분그래프/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(br.readLine());

        for(int t = 0; t < K; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            adjL = new ArrayList[V + 1];
            for(int v = 1; v < V + 1; v++) {
                adjL[v] = new ArrayList<>();
            }

            visited = new int[V + 1];

            for(int e = 0; e < E; e++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adjL[a].add(b);
                adjL[b].add(a);
            }
            ans = true;
            for(int i = 1; i < V + 1; i++) {
                if(visited[i] == 0) {
                    visited[i] = 1;
                    dfs(i, 1);
                }
            }
            sb.append(ans ? "YES\n" : "NO\n");
        }
        System.out.println(sb);
        br.close();
    }

    static void dfs(int start, int group) {
        if(!ans) {
            return;
        }

        for(int next : adjL[start]) {
            if(visited[next] == group) {
                ans = false;
                return;
            }
            if(visited[next] == 0) {
                if(group == 1) {
                    visited[next] = 2;
                    dfs(next, 2);
                } else if(group == 2) {
                    visited[next] = 1;
                    dfs(next, 1);
                }
            }
        }
    }
}
