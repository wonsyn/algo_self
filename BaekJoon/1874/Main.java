package bj_1874_스택수열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		ArrayList<Character> res = new ArrayList<>();
		boolean isPossible = true;
		
		int cur = 0;
		int num = 1;
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < N; i++) {
			stack.push(num++);
			res.add('+');
			
			while(!stack.isEmpty()) {
				if(stack.peek() == arr[cur]) {
					res.add('-');
					stack.pop();
					cur++;
				} else if(stack.peek() > arr[cur]) {
					isPossible = false;
					break;
				} else break;
			}
			
			if(!isPossible) break;
		}
		
		if(isPossible) {
			for(char i : res) {
				sb.append(i).append(" ");
			}
		} else {
			sb.append("NO");
		}
		System.out.println(sb.toString());
	}
}
