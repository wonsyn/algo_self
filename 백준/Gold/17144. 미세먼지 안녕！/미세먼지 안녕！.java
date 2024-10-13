import java.io.*;
import java.util.*;

public class Main {
    static int R, C, T, ans, top, bot;
    static int[][] room;
    static int[][] upDir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] downDir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        room = new int[R][C];

        top = -2; bot = -2;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if(room[i][j] == -1) {
                    if(top == -2) top = i;
                    else bot = i;
                }
            }
        }

        for(int t = 0; t < T; t++) {
            diffusion();
            upper();
            lower();
        }

        ans = 2;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                ans += room[i][j];
            }
        }

        System.out.println(ans);
        br.close();
    }

    static void diffusion() {
        int[][] next = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(room[i][j] > 0) {
                    int cur = room[i][j];
                    int div = cur / 5;
                    if(div != 0) {
                        for (int d = 0; d < 4; d++) {
                            int nr = i + upDir[d][0];
                            int nc = j + upDir[d][1];
                            if (0 <= nr && nr < R && 0 <= nc && nc < C && room[nr][nc] != -1) {
                                next[nr][nc] += div;
                                cur -= div;
                            }
                        }
                    }
                    next[i][j] += cur;
                }
            }
        }
        next[top][0] = -1;
        next[bot][0] = -1;
        room = next;
    }

    static void upper() {
        int r = top;
        int c = 0;
        int d = 0;
        do {
            int nr = r + upDir[d][0];
            int nc = c + upDir[d][1];
            if(nr < 0 || nr > top || nc < 0 || nc >= C) {
                room[top][0] = 0;
                d++;
                continue;
            }
            room[r][c] = room[nr][nc];
            r = nr; c = nc;
        } while(r != top || c != 0);
        room[top][0] = -1;
    }
    static void lower() {
        int r = bot;
        int c = 0;
        int d = 0;
        do {
            int nr = r + downDir[d][0];
            int nc = c + downDir[d][1];
            if(nr < bot || nr >= R || nc < 0 || nc >= C) {
                room[bot][0] = 0;
                d++;
                continue;
            }
            room[r][c] = room[nr][nc];
            r = nr; c = nc;

        } while(r != bot || c != 0);
        room[bot][0] = -1;
    }
}
