import java.util.*;

class Solution {
    static boolean[][] visited1, visited2;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static int cnt;
    
    public int solution(int[][] land) {
        int max = Integer.MIN_VALUE;
        int max_color = Integer.MIN_VALUE;
        Oil[][] calc = new Oil[land.length][land[0].length];
        visited1 = new boolean[land.length][land[0].length];
        visited2 = new boolean[land.length][land[0].length];
        int code = 0;
        for(int i = 0; i < land.length; i++) {
            for(int j = 0; j < land[0].length; j++) {
                if(!visited1[i][j] && land[i][j] == 1) {
                    cnt = 0;
                    visited1[i][j] = true;
                    dfs(land, i, j);
                    record(calc, i, j, cnt, code++);
                }
            }
        }
        
        for(int j = 0; j < land[0].length; j++) {
            cnt = 0;
            boolean[] check = new boolean[code];
            for(int i = 0; i < land.length; i++) {
                if(land[i][j] == 1 && !check[calc[i][j].code]) {
                    cnt += calc[i][j].size;
                    check[calc[i][j].code] = true;
                }
            }
            max = Math.max(max, cnt);
        }
        
        return max;
    }
    
    static void dfs(int[][] land, int r, int c) {
        cnt++;
        
        for(int d = 0; d < 4; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if(0 <= nr && nr < land.length && 0 <= nc && nc < land[0].length && !visited1[nr][nc] && land[nr][nc] == 1) {
                visited1[nr][nc] = true;
                dfs(land, nr, nc);
            }
        }
    }

    static void record(Oil[][] calc, int r, int c, int number, int code) {
        Queue<Node> q = new ArrayDeque<>();
        visited2[r][c] = true;
        q.offer(new Node(r, c));
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            calc[cur.r][cur.c] = new Oil(code, number);
            
            for(int d = 0; d < 4; d++) {
                int nr = cur.r + dir[d][0];
                int nc = cur.c + dir[d][1];
                if(0 <= nr && nr < calc.length && 0 <= nc && nc < calc[0].length && visited1[nr][nc] && !visited2[nr][nc]) {
                    visited2[nr][nc] = true;
                    q.offer(new Node(nr, nc));
                }
            }
        }
    }
    
    static class Node {
        int r; int c;
        Node(int r, int c) {
            this.r = r; this.c = c;
        }
    }
    
    static class Oil {
        int code; int size;
        Oil(int code, int size) {
            this.code = code; this.size = size;
        }
    }
}