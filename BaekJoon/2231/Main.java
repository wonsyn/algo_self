package bj_2231_분해합;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int div = 1000000;
		int num = 0;
		for(int i = 6; i >= 0; i--) {
			int n = N / div;
			
			if(n != 0) {
				num = i + 1;
				break;
			}
			
			div /= 10;
		}
		
		int min = 9 * num;
		boolean flag = false;
		
		for(int i = N - min ; i <= N; i++) {
			int sum = i;
			
			for(int j = 1; j <= num; j++) {
				int plus = i % (int)Math.pow(10, j);
				if(j != 1) {
					plus /= (int)Math.pow(10, j - 1);
				}
				sum += plus;
			}

			if (sum == N) {
				flag = true;
				System.out.println(i);
				break;
			}
		}
		
		if(!flag) {
			System.out.println(0);
		}
	}
}
