package bj_11050_이항계수1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int ans = fact(N) / (fact(K) * fact(N - K));
		
		System.out.print(ans);
	}
	
	static int fact(int n) {
		int total = 1;
		for(int i = 1; i <= n; i++) {
			total *= i;
		}
		return total;
	}
}
