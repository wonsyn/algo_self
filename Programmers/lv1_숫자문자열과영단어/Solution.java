package programmers_lv1_숫자문자열과영단어;

class Solution {
    public int solution(String s) {
    	String[] strNumbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    	String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    	
    	for(int i = 0; i < 10; i++) {
    		s = s.replaceAll(strNumbers[i], numbers[i]);
    	}
    	
        int answer = Integer.parseInt(s);
        return answer;
    }
}
