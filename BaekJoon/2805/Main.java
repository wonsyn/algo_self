package bj_2805_나무자르기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] trees = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(trees);
		
		int start = 0, end = trees[N - 1];
		int mid = -1;
		
		while(start <= end) {
			mid = (start + end) / 2;
			long sum = 0;
			for(int i = 0; i < N; i++) {
				int num = trees[i] - mid;
				if (num > 0) {
					sum += trees[i] - mid;
				}
			}
			
			if(sum >= M) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		System.out.println(end);
	}
}
