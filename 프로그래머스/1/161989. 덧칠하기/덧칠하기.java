class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        boolean[] wall = new boolean[n + 1];
        for(int s : section) {
            wall[s] = true;
        }
        
        for(int i = 1; i < wall.length; i++) {
            if(wall[i]) {
                for(int j = i; j < i + m; j++) {
                    if(j < wall.length) {
                        wall[j] = false;
                    }
                }
                answer++;
            }
        }
        
        return answer;
    }
}