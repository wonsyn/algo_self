import java.io.*;
import java.util.*;

public class Main {
    static int N, max = Integer.MIN_VALUE;
    static boolean[][] friends;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        friends = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++) {
                if(s.charAt(j) == 'Y') {
                    friends[i][j] = true;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            calc(i);
        }

        System.out.println(max);
        br.close();
    }

    static void calc(int me) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        visited[me] = true;
        q.offer(new int[] {me, 0});
        int cnt = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[1] == 2) continue;

            for(int i = 0; i < N; i++) {
                if(!visited[i] && friends[cur[0]][i]) {
                    cnt++;
                    visited[i] = true;
                    q.offer(new int[]{i, cur[1] + 1});
                }
            }
        }
        max = Math.max(max, cnt);
    }
}
