package bj_2609_최대공약수와최소공배수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int gcd = gcd(a, b);
		int lcm = lcm(a, b, gcd);
		
		System.out.println(gcd);
		System.out.print(lcm);
	}
	
	static int gcd(int a, int b) {
		while(true) {
			if(a < b) {
				int temp = a;
				a = b; b = temp;
			}
			
			if(a % b == 0) return b;
			a = a % b;
		}
	}
	
	static int lcm(int a, int b, int gcd) {
		return a * b / gcd;
	}
}
