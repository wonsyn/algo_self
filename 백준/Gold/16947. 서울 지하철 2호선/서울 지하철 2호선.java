import java.io.*;
import java.util.*;

public class Main {
    static int N, distance;
    static ArrayList<Integer>[] station;
    static boolean[] isCycle, visited;
    static int[] ans;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        station = new ArrayList[N + 1];
        ans = new int[N + 1];
        isCycle = new boolean[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++) {
            station[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            station[x].add(y);
            station[y].add(x);
        }

        for(int i = 1; i <= N; i++) {
            if(!isCycle[i]) {
                visited[i] = true;
                check(station[i], i, i, 0);
                visited[i] = false;
            }
        }

        for(int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            if(isCycle[i]) {
                ans[i] = 0;
                continue;
            }
            ans[i] = bfs(i);
        }

        for(int i = 1; i <= N; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
        br.close();
    }

    static int check(ArrayList<Integer> list, int cur, int start, int pre) {

        for(int next : list) {
            if(next == start && next != pre) {
                isCycle[next] = true;
                return next;
            }
            if(!visited[next]) {
                visited[next] = true;
                int cycle = check(station[next], next, start, cur);
                if(cycle == cur) {
                    isCycle[cycle] = true;
                    cycle = -1;
                }
                if(cycle != -1) {
                    isCycle[cycle] = true;
                }
                visited[next] = false;
            }
        }
        return -1;
    }

    static int bfs(int start) {
        Queue<Node> q = new ArrayDeque<>();
        visited[start] = true;
        q.offer(new Node(start, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(isCycle[cur.cur]) {
                return cur.cnt;
            }

            for(int s : station[cur.cur]) {
                if(!visited[s]) {
                    visited[s] = true;
                    q.offer(new Node(s, cur.cnt + 1));
                }
            }
        }
        return 0;
    }

    static class Node {
        int cur;
        int cnt;

        Node(int cur, int cnt) {
            this.cur = cur; this.cnt = cnt;
        }
    }
}
