package bj_13549_숨바꼭질;

import java.util.*;
import java.io.*;

public class Main {
    static int N, K;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/bj_13549_숨바꼭질/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int max = 100000;
        int min = Integer.MAX_VALUE;

        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[max + 1];
        visited[N] = true;
        q.offer(new int[] {N, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[0] == K) min = Math.min(min, cur[1]);

            if(cur[0] * 2 <= max && !visited[cur[0] * 2]) {
                visited[cur[0] * 2] = true;
                q.offer(new int[] {cur[0] * 2, cur[1]});
            }
            if(cur[0] - 1 >= 0 && cur[0] - 1 <= max && !visited[cur[0] - 1]) {
                visited[cur[0] - 1] = true;
                q.offer(new int[] {cur[0] - 1, cur[1] + 1});
            }
            if(cur[0] + 1 <= max && !visited[cur[0] + 1]) {
                visited[cur[0] + 1] = true;
                q.offer(new int[] {cur[0] + 1, cur[1] + 1});
            }
        }

        System.out.println(min);
    }
}
