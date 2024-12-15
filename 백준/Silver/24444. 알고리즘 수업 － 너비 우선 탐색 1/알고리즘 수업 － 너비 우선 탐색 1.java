import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main{
    static int N, M, R, cnt;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for(int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        cnt = 1;
        visited = new int[N + 1];
        bfs(R);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[start] = cnt++;
        q.offer(start);

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int v : graph.get(cur)) {
                if(visited[v] == 0) {
                    visited[v] = cnt++;
                    q.offer(v);
                }
            }
        }
    }
}