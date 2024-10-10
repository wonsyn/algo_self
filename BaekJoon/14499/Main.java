package bj_14499_주사위굴리기;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, x, y, K;
    static int[][] map, dir = {{}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}}; // 1:우 2:좌 3:상 4:하
    static int[] dice;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/bj_14499_주사위굴리기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dice = new int[6];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int k = 0; k < K; k++) {
            roll(Integer.parseInt(st.nextToken()));
        }

        System.out.println(sb);
        br.close();
    }

    static void roll(int command) {
        int temp = dice[2];
        int nx = x + dir[command][0], ny = y + dir[command][1];
        if(nx < 0 || nx >= N || ny < 0 || ny >= M) return;
        x = nx; y = ny;
        switch (command) {
            case 1: // 3 2 6 4
                dice[2] = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[3];
                dice[3] = temp;
                break;
            case 2: // 3 4 6 2
                dice[2] = dice[3];
                dice[3] = dice[5];
                dice[5] = dice[1];
                dice[1] = temp;
                break;
            case 3: // 3 5 6 1
                dice[2] = dice[4];
                dice[4] = dice[5];
                dice[5] = dice[0];
                dice[0] = temp;
                break;
            case 4: // 3 1 6 5
                dice[2] = dice[0];
                dice[0] = dice[5];
                dice[5] = dice[4];
                dice[4] = temp;
                break;
            default:
        }
        if(map[x][y] != 0){
            dice[5] = map[x][y];
            map[x][y] = 0;
        } else {
            map[x][y] = dice[5];
        }
        sb.append(dice[2]).append("\n");
    }
}
