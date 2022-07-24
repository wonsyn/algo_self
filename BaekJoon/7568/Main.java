package bj_7568_덩치;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2]; // 0 : w, 1 : h
		int[] rank = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken()); // w
			arr[i][1] = Integer.parseInt(st.nextToken()); // h
		}
		
		for(int i = 0; i < N; i++) {
			int count = 1;
			
			for(int j = 0; j < N; j++) {
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					count++;
				}
			}
			
			rank[i] = count;
		}
		
		for(int i = 0; i < N; i++) {
			sb.append(rank[i]).append(" ");
		}
		
		System.out.print(sb.toString());
	}
}
