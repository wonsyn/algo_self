import java.util.*;
import java.io.*;

public class Main {
    static int R, C, cnt;
    static boolean visit;
    static char[][] grid;
    static int[] dx = {1, 1, 1};    // 우상, 우, 우하
    static int[] dy = {-1, 0, 1};

    static boolean isPath(int row, int col){
        if(row<0 || row>=R || col<0 || col>=C){
            return false;
        }
        return true;
    }

    static void DFS(int row, int col){
        if(col == C-1){
            visit = true;
            cnt++;
            return;
        }

        for(int d = 0; d<3; d++){
            int nextR = row + dy[d];
            int nextC = col + dx[d];

            if(isPath(nextR, nextC) && grid[nextR][nextC] == '.'){
                grid[row][col] = 'x';
                DFS(nextR, nextC);
                if(visit) return;
            }

        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        grid = new char[R][C];

        for(int i = 0; i<R; i++){
            grid[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i<R; i++){
            visit = false;
            DFS(i, 0);
        }

        System.out.println(cnt);
        br.close();
    }
}