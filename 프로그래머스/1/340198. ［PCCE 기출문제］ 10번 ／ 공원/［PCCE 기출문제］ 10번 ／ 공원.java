class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        boolean[][] possible = new boolean[park.length][park[0].length];
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[0].length; j++) {
                if(park[i][j].equals("-1")) {
                    possible[i][j] = true;
                }
            }
        }
        
        next: for(int i = 0; i < mats.length; i++) {
            for(int r = 0; r <= park.length - mats[i]; r++) {
                for(int c = 0; c <= park[0].length - mats[i]; c++) {
                    if(isPossible(mats[i], r, c, possible)) {
                        answer = Math.max(answer, mats[i]);
                        continue next;
                    };
                }
            }
        }
        
        return answer;
    }
    
    boolean isPossible(int mat, int r, int c, boolean[][] possible) {
        for(int i = r; i < r + mat; i++) {
            for(int j = c; j < c + mat; j++) {
                if(!possible[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}