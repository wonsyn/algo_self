package bj_1541_잃어버린괄호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String exp = br.readLine();
		
		StringTokenizer st = new StringTokenizer(exp, "-");
		
		int res = 0;
		String str = st.nextToken();
		StringTokenizer st2 = new StringTokenizer(str, "+");
		while(st2.hasMoreTokens()) {
			res += Integer.parseInt(st2.nextToken());
		}
		
		while(st.hasMoreTokens()) {
			str = st.nextToken();
			st2 = new StringTokenizer(str, "+");
			int sum = 0;
			while(st2.hasMoreTokens()) {
				sum += Integer.parseInt(st2.nextToken());
			}
			res -= sum;
		}
		
		System.out.print(res);
	}
}
