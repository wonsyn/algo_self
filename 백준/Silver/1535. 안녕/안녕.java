import java.io.*;
import java.util.*;

public class Main {
    static int[] L, J;
    static int N, max = 0;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        L = new int[N];
        J = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            J[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            if(100 - L[i] > 0) {
                visited[i] = true;
                dfs(i, 100 - L[i], J[i]);
                visited[i] = false;
            }
        }

        System.out.println(max);
        br.close();
    }

    static void dfs(int start, int l, int j) {
        max = Math.max(max, j);

        for(int i = start; i < N; i++) {
            if(!visited[i]) {
                if(l - L[i] > 0) {
                    visited[i] = true;
                    dfs(i + 1, l - L[i], j + J[i]);
                    visited[i] = false;
                }
            }
        }
    }
}