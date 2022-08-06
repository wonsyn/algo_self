package bj_1074_Z;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, R, C, count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		count = 0;
		recur((int)Math.pow(2, N), R, C);
		
		System.out.print(count);
	}
	
	static void recur(int size, int r, int c) {
		if(size == 1) return;
		
		int half = size / 2;
		if(r < half && c < half) { } 
		else if(r < half && c >= half) {
			count += half * half;
			c -= half;
		} else if(r >= half && c < half) {
			count += half * half * 2;
			r -= half;
		} else if(r >= half && c >= half) {
			count += half * half * 3;
			r -= half; c -= half;
		}
		recur(half, r, c);
	}
}
