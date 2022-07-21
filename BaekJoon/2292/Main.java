package bj_2292_벌집;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int num = 1;
		int idx = 1;
		
		while(true) {
			num = num + 6 * (idx - 1);
			if(N <= num) break;
			idx++;
		}
		
		System.out.println(idx);
	}
}
