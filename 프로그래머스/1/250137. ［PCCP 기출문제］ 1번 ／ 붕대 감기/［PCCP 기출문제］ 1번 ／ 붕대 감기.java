class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int keep = 0;
        int time = 0;
        int max = health;
        for(int[] attack : attacks) {
            int atkTime = attack[0];
            
            while(time < atkTime && health > 0) {
                health += bandage[1];
                keep++;
                if(keep == bandage[0]) {
                    health += bandage[2];
                    keep = 0;
                }
                if(health > max) {
                    health = max;
                }
                
                time++;
            }
            
            health -= attack[1];
            keep = 0;
            time++;
        }
        
        
        return health > 0 ? health : -1;
    }
}