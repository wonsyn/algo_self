package bj_11651_좌표정렬하기2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			arr[n][0] = Integer.parseInt(st.nextToken());
			arr[n][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int y = o1[1] - o2[1];
				if(y == 0) {
					return o1[0] - o2[0];
				}
				return y;
			}
		});
		
		for(int n = 0; n < N; n++) {
			sb.append(arr[n][0]).append(" ").append(arr[n][1]).append("\n");
		}
		System.out.print(sb.toString());
	}
}
