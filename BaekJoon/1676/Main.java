package bj_1676_팩토리얼0의개수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int count = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int count = 0;
		
		while(N >= 5) {
			count += N / 5;
			N /= 5;
		}
		
		System.out.print(count);
	}
}
