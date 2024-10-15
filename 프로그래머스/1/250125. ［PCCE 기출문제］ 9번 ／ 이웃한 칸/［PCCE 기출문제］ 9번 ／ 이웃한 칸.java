class Solution {
    int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        String color = board[h][w];
        
        for(int[] d : dir) {
            int nh = h + d[0];
            int nw = w + d[1];
            if(0 <= nh && nh < board.length && 0 <= nw && nw < board[0].length && 
              board[nh][nw].equals(color)) {
                answer++;
            }
        }
        
        return answer;
    }
}