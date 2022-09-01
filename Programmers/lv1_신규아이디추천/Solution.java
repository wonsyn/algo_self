package programmers_lv1_신규아이디추천;

class Solution {
	public String solution(String new_id) {
    	String answer;
    	
    	answer = new_id.toLowerCase(); // 1단계
    	answer = answer.replaceAll("[^-a-z0-9_.]", ""); // 2단계
    	answer = answer.replaceAll("[.]{2,}", "."); // 3단계
    	answer = answer.replaceAll("^[.]|[.]$", ""); // 4단계
    	
    	if(answer.length() == 0) { // 5단계
    		answer = "a";
    	}
    	if(answer.length() >= 16) { // 6단계
    		answer = answer.substring(0, 15);
    		answer = answer.replaceAll("[.]$", "");
    	}
    	
    	if(answer.length() <= 2) { // 7단계
    		while(answer.length() <= 2) {
    			answer += answer.charAt(answer.length() - 1);
    		}
    	}

    	return answer;
    }
}
