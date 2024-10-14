import java.io.*;
import java.util.*;

public class Main {
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static char[][] map;
    static char[] select;
    static Set<String> set;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];
        select = new char[6];
        set = new HashSet<>();

        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                select[0] = map[i][j];
                dfs(i, j, 1);
            }
        }

        System.out.println(set.size());
        br.close();
    }

    static void dfs(int r, int c, int cnt) {
        if(cnt == 6) {
            String num = "";
            for(int i = 0; i < 6; i++) {
                num += select[i];
            }
            set.add(num);
            return;
        }

        for(int d = 0; d < 4; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if(0 <= nr && nr < 5 && 0 <= nc && nc < 5) {
                select[cnt] = map[nr][nc];
                dfs(nr, nc, cnt + 1);
            }
        }
    }
}

