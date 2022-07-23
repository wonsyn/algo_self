package bj_2839_설탕배달;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int end = (N / 5);
		int res = -1;
		
		for(int i = end; 0 <= i; i--) {
			if((N - (5 * i)) % 3 == 0) {
				res = i;
				res += (N - (5 * i)) / 3;
				break;
			}
		}
		
		System.out.println(res);
	}
}
