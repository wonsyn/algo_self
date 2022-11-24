package bj_1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int answer = bfs(N, K);
        System.out.println(answer);
    }

    public static int bfs(int n, int k) {
        int[] visited = new int[100001];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);
        visited[n] = 1;
        while(!q.isEmpty()) {
            int cur = q.poll();
            if(cur == k) return visited[cur] - 1;

            if(cur - 1 >= 0 && visited[cur - 1] == 0) {
                visited[cur - 1] = visited[cur] + 1;
                q.offer(cur - 1);
            }
            if(cur + 1 < 100001 && visited[cur + 1] == 0) {
                visited[cur + 1] = visited[cur] + 1;
                q.offer(cur + 1);
            }
            if(cur * 2 < 100001 && visited[cur * 2] == 0) {
                visited[cur * 2] = visited[cur] + 1;
                q.offer(cur * 2);
            }
        }
        return -1;
    }
}
