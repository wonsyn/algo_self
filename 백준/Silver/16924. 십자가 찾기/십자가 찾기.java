import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static int N, M;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static boolean[][] check;
    static ArrayList<Point> list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        check = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for(int i = 1; i < N - 1; i++) {
            for(int j = 1; j < M - 1; j++) {
                if(map[i][j] == '*') search(i, j);
            }
        }

        for(Point p : list) {
            check[p.r - 1][p.c - 1] = true;
            for(int d = 0; d < 4; d++) {
                for (int temp = 1; temp <= p.size; temp++) {
                    int nr = p.r - 1 + dir[d][0] * temp;
                    int nc = p.c - 1 + dir[d][1] * temp;
                    check[nr][nc] = true;
                }
            }
        }

        boolean isPossible = true;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == '*' && !check[i][j]) {
                    isPossible = false;
                }
            }
        }

        if(isPossible) {
            StringBuilder sb = new StringBuilder();
            sb.append(list.size()).append("\n");
            for(Point p : list) {
                sb.append(p.r).append(" ").append(p.c).append(" ").append(p.size).append("\n");
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }

        br.close();
    }

    static void search(int r, int c) {
        int cnt = 1;
        while(true) {
            int d = 0;
            while(d < 4) {
                int nr = r + dir[d][0] * cnt;
                int nc = c + dir[d][1] * cnt;
                if(0 > nr || nr >= N || 0 > nc || nc >= M || map[nr][nc] != '*') {
                    break;
                }
                d++;
            }
            if(d != 4) {
                cnt--;
                break;
            }
            else cnt++;
        }

        if(cnt != 0) {
            list.add(new Point(r + 1, c + 1, cnt));
        }
    }

    static class Point {
        int r, c, size;
        Point(int r, int c, int size) {
            this.r = r; this.c = c; this.size = size;
        }
    }
}
