package bj_18111_마인크래프트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int total = N * M;
		int[] arr = new int[N * M];
		
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int val = Integer.parseInt(st.nextToken());
				arr[i * M + j] = val;
				if(max < val) max = val;
				if(min > val) min = val;
			}
		}
		
		int resS = Integer.MAX_VALUE, resH= 0;
		
		for(int i = min; i <= max; i++) {
			int sec = 0;
			int inv = B;
			
			for(int j = 0; j < total; j++) {
				int diff = arr[j] - i;
				
				if(diff > 0) {
					sec += diff * 2;
					inv += diff;
				} else if (diff < 0){
					sec -= diff;
					inv += diff;
				}
			}
			
			if(0 <= inv) {
				if(sec <= resS) {
					resS = sec;
					resH = i;
				}
			}
		}
		
		System.out.print(resS + " " + resH);
	}
}
