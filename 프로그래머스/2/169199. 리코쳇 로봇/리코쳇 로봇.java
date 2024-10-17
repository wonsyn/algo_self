import java.util.*;

class Solution {
    static boolean[][] visited;
    static int startR, startC, answer;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    
    public int solution(String[] board) {
        answer = -1;
        
        visited = new boolean[board.length][board[0].length()];
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length(); j++) {
                if(board[i].charAt(j) == 'R') {
                    startR = i; startC = j;
                }
            }
        }    
        
        bfs(startR, startC, board);
        
        return answer;
    }
    
    static void bfs(int r, int c, String[] board) {
        Queue<Node> q = new ArrayDeque<>();
        visited[r][c] = true;
        q.offer(new Node(r, c, 0));
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(board[cur.r].charAt(cur.c) == 'G') {
                answer = cur.cnt;
                return;
            }
            
            for(int d = 0; d < 4; d++) {
                int t = 1;
                int nr, nc;
                while(true) {
                    nr = cur.r + dir[d][0] * t;
                    nc = cur.c + dir[d][1] * t;
                    if(0 <= nr && nr < board.length && 0 <= nc && nc < board[nr].length()
                      && board[nr].charAt(nc) != 'D') {
                        t++;
                    } else {
                        t--;
                        break;
                    }
                }
                
                nr = cur.r + dir[d][0] * t;
                nc = cur.c + dir[d][1] * t;
                if(0 <= nr && nr < board.length && 0 <= nc && nc < board[nr].length()
                   && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new Node(nr, nc, cur.cnt + 1));
                }
            }
        }
    }
    
    static class Node {
        int cnt;
        int r, c;
        Node(int r, int c, int cnt) {
            this.r = r; this.c = c; this.cnt = cnt;
        }
    }
}