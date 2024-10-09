package bj_16967_배열복원하기;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/bj_16967_배열복원하기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[][] arr = new int[H + X][W + Y];
        int[][] res = new int[H][W];

        // 배열 입력
        for(int i = 0; i < H + X; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W + Y; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //안겹치는 윗행 받기
        for(int i = 0; i < X; i++) {
            for(int j = 0; j < W; j++) {
                res[i][j] = arr[i][j];
            }
        }
        // 안겹치는 왼쪽열 받기
        for(int j = 0; j < Y; j++) {
            for(int i = 0; i < H; i++) {
                res[i][j] = arr[i][j];
            }
        }

        for(int i = X; i < H; i++) {
            for(int j = Y; j < W; j++) {
                res[i][j] = arr[i][j] - res[i - X][j - Y];
            }
        }

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                sb.append(res[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
