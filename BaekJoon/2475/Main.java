package bj_2475_검증수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = 0;
		
		while(st.hasMoreTokens()) {
			int n = Integer.parseInt(st.nextToken());
			num += n * n;
		}
		
		num = num % 10;
		
		System.out.println(num);
	}
}
