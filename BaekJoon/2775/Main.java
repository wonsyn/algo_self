package bj_2775_부녀회장이될테야;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[k + 1][n + 1];
			
			for(int i = 1; i <= n; i++) {
				arr[0][i] = i;
			}
			
			for(int i = 1; i <= k; i++) {
				for(int j = 1; j <= n; j++) {
					int num = 0;
					for(int m = 1; m <= j; m++) {
						num += arr[i - 1][m];
					}
					
					arr[i][j] = num;
				}
			}
			System.out.println(arr[k][n]);
		}
	}
}
