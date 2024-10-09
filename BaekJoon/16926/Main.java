package bj_16926_배열돌리기1;

import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb;
    static int N, M, R, level;
    static int[][] array;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/bj_16926_배열돌리기1/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        level = Math.min(N, M) / 2;

        array = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r = 0; r < R; r++) {
            rotate();
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                sb.append(array[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static void rotate() {
        for(int l = 0; l < level; l++) {
            int r = l, c = l;
            int save = array[r][c];

            int d = 0;
            while(d != 4) {
                int nr = r + dir[d][0];
                int nc = c + dir[d][1];

                if(l <= nr && nr < N - l && l <= nc && nc < M - l) {
                    array[r][c] = array[nr][nc];
                    r = nr; c = nc;
                } else {
                    d++;
                }
            }
            array[l + 1][l] = save;
        }
    }

    static void swap(int r, int c, int preR, int preC) {
        int temp = array[r][c];
        array[r][c] = array[preR][preC];
        array[preR][preC] = temp;
    }
}
