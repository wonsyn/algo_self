package bj_13023_ABCDE;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] isFriends;
    static boolean[] visited;
    static boolean res;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/bj_13023_ABCDE/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isFriends = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            isFriends[i] = new ArrayList<>();
        }
        visited = new boolean[N];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            isFriends[a].add(b); isFriends[b].add(a);
        }

        for(int i = 0; i < N; i++) {
            if(res) break;
            visited[i] = true;
            dfs(i, 0);
            visited[i] = false;
        }

        System.out.println(res? 1 : 0);
        br.close();
    }

    static void dfs(int start, int count) {
        if(res) return;

        if(count == 4) {
            res = true;
            return;
        }

        for(int i = 0; i < isFriends[start].size(); i++) {
            int cur = isFriends[start].get(i);
            if(!visited[cur]) {
                visited[cur] = true;
                dfs(cur, count + 1);
                visited[cur] = false;
            }
        }
    }
}
