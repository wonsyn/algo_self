package bj_2798_블랙잭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int max = 0, N, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(new boolean[N], 0, 3);
		
		System.out.println(max);
	}
	
	static void comb(boolean[] visited, int start, int r) {
		if(r == 0) {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if(visited[i]) {
					sum += arr[i];
				}
			}
			
			if(max < sum && sum <= M) {
				max = sum;
			}
			return;
		}
		
		for(int i = start; i < N; i++) {
			visited[i] = true;
			comb(visited, i + 1, r - 1);
			visited[i] = false;
		}
	}
}
