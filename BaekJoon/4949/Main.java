package bj_4949_균형잡힌세상;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		while(true) {
			boolean flag = true;
			String str = br.readLine();
			
			if(str.equals(".")) break;
			
			Stack<Character> stack = new Stack<>();
			
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				
				if(c == '(' || c == '[') {
					stack.push(c);
				} else if(c == ')') {
					if(stack.isEmpty()) {
						flag = false;
						break;
					}
					
					char c2 = stack.pop();
					if(c2 != '(') {
						flag = false;
						break;
					}
				} else if(c == ']') {
					if(stack.isEmpty()) {
						flag = false;
						break;
					}
					
					char c2 = stack.pop();
					if(c2 != '[') {
						flag = false;
						break;
					}
				}
				else if(c == '.'){
					if(!stack.isEmpty()) {
						flag = false;
					}
				}
			}
			
			if(flag) {
				sb.append("yes").append("\n");
			} else {
				sb.append("no").append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}
