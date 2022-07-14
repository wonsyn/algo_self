package bj_1259_팰린드롬수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static ArrayList<String> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		list = new ArrayList<String>();
		
		while(true) {
			String num = br.readLine();
			if (num.equals("0")) break;
			list.add(num);
		}
		
		for(String num : list) {
			if(check(num)) {
				sb.append("yes\n");
			} else {
				sb.append("no\n");
			}
		}
		
		System.out.println(sb);
	}
	
	static boolean check(String num) {
		
		int len = num.length();
		int eo = len % 2;
		int left, right;
		
		if(eo == 0) { // 짝수 길이
			left = len / 2 - 1;
			right = len / 2;
		} else { // 홀수 길이
			left = len / 2 - 1;
			right = len / 2 + 1;
		}
		
		while(left >= 0) {
			if(num.charAt(left) != num.charAt(right)) return false;
			left--; right++;
		}
		
		return true;
	}
}
