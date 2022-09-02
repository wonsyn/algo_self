package programmers_lv1_키패드누르기;

class Solution2 {
	
    public String solution(int[] numbers, String hand) {
    	int[][] pad = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};
    	int[] left = {3, 0};
    	int[] right = {3, 2};
        String answer = "";

    	for(int i = 0; i < numbers.length; i++) {
    		if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
    			left[0] = pad[numbers[i]][0];
    			left[1] = pad[numbers[i]][1];
    			answer += "L";
    		} else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
    			right[0] = pad[numbers[i]][0];
    			right[1] = pad[numbers[i]][1];
    			answer += "R";
    		} else {
    			int leftDist = Math.abs(left[0] - pad[numbers[i]][0]) + Math.abs(left[1] - pad[numbers[i]][1]);
    			int rightDist = Math.abs(right[0] - pad[numbers[i]][0]) + Math.abs(right[1] - pad[numbers[i]][1]);
    			if(leftDist < rightDist) {
    				left[0] = pad[numbers[i]][0];
        			left[1] = pad[numbers[i]][1];
        			answer += "L";
    			} else if(leftDist > rightDist){
    				right[0] = pad[numbers[i]][0];
        			right[1] = pad[numbers[i]][1];
        			answer += "R";
    			} else {
    				if(hand.equals("left")) {
        				left[0] = pad[numbers[i]][0];
            			left[1] = pad[numbers[i]][1];
            			answer += "L";
    				} else {
        				right[0] = pad[numbers[i]][0];
            			right[1] = pad[numbers[i]][1];
            			answer += "R";
    				}
    			}
    		}
    	}
    	
        return answer;
    }
}
