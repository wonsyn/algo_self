package bj_1003_피보나치함수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			if(N == 0) {
				sb.append("1 0\n");
				continue;
			}
			if(N == 1) {
				sb.append("0 1\n");
				continue;
			}
			
			int[][] arr = new int[N + 1][2];
			arr[0][0] = 1; arr[1][1] = 1;
			
			for(int i = 2; i <= N; i++) {
				arr[i][0] = arr[i - 1][0] + arr[i - 2][0];
				arr[i][1] = arr[i - 1][1] + arr[i - 2][1];
			}
			
			sb.append(arr[N][0]).append(" ").append(arr[N][1]).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}
