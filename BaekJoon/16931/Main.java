package bj_16931_겉넓이구하기;

import java.util.*;
import java.io.*;

public class Main {
    static int ans, N, M;
    static int[][] arr, dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/bj_16931_겉넓이구하기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                for(int d = 0; d < 4; d++) {
                    int ni = i + dir[d][0];
                    int nj = j + dir[d][1];

                    if(ni < 0 || ni >= N || nj < 0 || nj >= M) {
                        ans += arr[i][j];
                    } else if(arr[i][j] > arr[ni][nj]) {
                        ans += arr[i][j] - arr[ni][nj];
                    }
                }
            }
        }

        ans += N * M * 2;

        System.out.println(ans);
        br.close();
    }
}
