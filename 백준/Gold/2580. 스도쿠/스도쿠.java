import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[9][9];
        for(int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        sudoku(0, 0);
    }

    static void sudoku(int r, int c) {
        if(c == 9) {
            sudoku(r + 1, 0);
            return;
        }
        if(r == 9) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if(map[r][c] == 0) {
            for(int i = 1; i <= 9; i++) {
                if (isPossible(r, c, i)) {
                    map[r][c] = i;
                    sudoku(r, c + 1);
                }
            }
            map[r][c] = 0;
        } else {
            sudoku(r, c + 1);
        }
    }

    static boolean isPossible(int r, int c, int num) {
        int[] square = {0, 3, 6};
        for(int i = 0; i < 9; i++) {
            if(map[r][i] == num || map[i][c] == num) {
                return false;
            }
        }
        int startX = square[r / 3];
        int startY = square[c / 3];

        for(int i = startX; i < startX + 3; i++) {
            for(int j = startY; j < startY + 3; j++) {
                if(map[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}