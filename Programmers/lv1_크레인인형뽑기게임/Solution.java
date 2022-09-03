package programmers_lv1_크레인인형뽑기게임;

import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
    	int answer = 0;
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	for(int i = 0; i < moves.length; i++) {
    		for(int j = 0; j < board.length; j++) {
    			if(board[j][moves[i] - 1] != 0) {
    				if(stack.size() == 0) {
    					stack.push(board[j][moves[i] - 1]);
    					board[j][moves[i] - 1] = 0;
    				} else {
    					if(stack.peek() == board[j][moves[i] - 1]) {
    						stack.pop();
    						board[j][moves[i] - 1] = 0;
    						answer += 2;
    					} else {
    						stack.push(board[j][moves[i] - 1]);
    						board[j][moves[i] - 1] = 0;
    					}
    				}
                    break;
    			}
    		}
    	}
    	
        return answer;
    }
}