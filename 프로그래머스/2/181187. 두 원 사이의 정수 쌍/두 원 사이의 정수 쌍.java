class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for(int i = 1; i <= r2; i++) {
            long large = (long)Math.floor(Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2)));
            long small = (long)Math.ceil(Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2)));
            answer += large - small + 1;
        }
        
        return answer * 4;
    }
}