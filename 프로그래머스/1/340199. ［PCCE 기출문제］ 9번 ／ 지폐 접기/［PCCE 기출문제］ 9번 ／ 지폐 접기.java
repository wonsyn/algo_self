class Solution {
    public int solution(int[] wallet, int[] bill) {
        int ans = 0;
        while(true) {
            if(isPossible(wallet, bill)) {
                break;
            }
            
            if(bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            
            ans++;
        }
        
        return ans;
    }
    
    boolean isPossible(int[] wallet, int[] bill) {
        if(wallet[0] >= bill[0]) {
            if(wallet[1] >= bill[1]) return true;
        }
        if(wallet[0] >= bill[1]) {
            if(wallet[1] >= bill[0]) return true;
        }
        return false;
    }
}