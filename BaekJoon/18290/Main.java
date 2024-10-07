package bj_18290_NM과K;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K, max;
    static int[][] num;
    static boolean[][] visited;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/bj_18290_NM과K/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;

        num = new int[N][M];
        visited = new boolean[N][M];
        arr = new int[K];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        find(0);
        System.out.println(max);
        br.close();
    }

    static void find(int idx) {
        if(idx == K) {
            int temp = 0;
            for (int i = 0; i < K; i++) {
                temp += arr[i];
            }
            max = Math.max(max, temp);
            return;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(isPossible(i, j)) {
                    visited[i][j] = true;
                    arr[idx] = num[i][j];
                    find(idx + 1);
                    visited[i][j] = false;
                }
            }
        }
    }

    static boolean isPossible(int r, int c) {
        if(visited[r][c]) return false;

        if((r - 1 >= 0 && visited[r - 1][c]) || (r + 1 < N && visited[r + 1][c])
            || (c - 1 >= 0 && visited[r][c - 1]) || (c + 1 < M && visited[r][c + 1])) {
            return false;
        }

        return true;
    }
}
