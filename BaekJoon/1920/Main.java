package bj_1920_수찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arrN = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrN);
		
		int M = Integer.parseInt(br.readLine());
		int[] arrM = new int[M];
		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < M; i++) {
			arrM[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int m = 0; m < M; m++) {
			int start = 0;
			int end = N - 1;
			int mid;
			boolean hasNum = false;
			if(arrM[m] < arrN[start] || arrN[end] < arrM[m]) {
				sb.append("0\n");
				continue;
			}
			
			while(start <= end) {
			mid = (start + end) / 2;
				if(arrM[m] < arrN[mid]) {
					end = mid - 1;
				} else if(arrM[m] > arrN[mid]) {
					start = mid + 1;
				} else {
					sb.append("1\n");
					hasNum = true;
					break;
				}
			}
			if(!hasNum) {
				sb.append("0\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}
