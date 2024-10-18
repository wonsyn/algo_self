class Solution {
    public int solution(String[] board) {
        int x = 0; int o = 0;
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i].charAt(j) == 'X') {
                    x++;
                } else if(board[i].charAt(j) == 'O') {
                    o++;
                }
            }
        }
        
        if(x > o) return 0;
        if(o - x >= 2) return 0;
        
        int[] check = check(board);
        if(check[0] >= 1 && o == x) return 0;
        if(check[1] >= 1 && o == x + 1) return 0;
        
        return 1;
    }
    
    static int[] check(String[] board) {
        int x = 0, o = 0;
        for(int i = 0; i < 3; i++) {
            if(board[i].charAt(0) == board[i].charAt(1) 
               && board[i].charAt(0) == board[i].charAt(2)) {
                if(board[i].charAt(0) == 'X') x++;
                else if(board[i].charAt(0) == 'O') o++;
            }
        }
        
        for(int j = 0; j < 3; j++) {
            if(board[0].charAt(j) == board[1].charAt(j) && board[0].charAt(j) == board[2].charAt(j)) {
                if(board[0].charAt(j) == 'X') x++;
                else if(board[0].charAt(j) == 'O') o++;
            }
        }
        
        if(board[0].charAt(0) == board[1].charAt(1) && board[0].charAt(0) == board[2].charAt(2)) {
            if(board[0].charAt(0) == 'X') x++;
            else if(board[0].charAt(0) == 'O') o++;
        }
        
        if(board[2].charAt(0) == board[1].charAt(1) && board[2].charAt(0) == board[0].charAt(2)) {
            if(board[2].charAt(0) == 'X') x++;
            else if(board[2].charAt(0) == 'O') o++;
        }
        
        return new int[] {o, x};
    }
}