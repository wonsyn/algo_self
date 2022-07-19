package bj_2108_통계학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		long avg = Math.round(((double)sum / N));
		sb.append(avg).append("\n");
		
		Arrays.sort(arr);
		
		int mid = arr[N / 2];
		sb.append(mid).append("\n");
		
		int count = 0, maxCount = -1;
		int freq = arr[0];
		boolean isMin = false;
		
		for(int i = 0; i < N - 1; i++) {
			if(arr[i] == arr[i + 1]) count++;
			else count = 0;
			
			if(maxCount < count) {
				maxCount = count;
				freq = arr[i];
				isMin = true;
			} else if(maxCount == count && isMin) {
				freq = arr[i];
				isMin = false;
			}
		}
		
		sb.append(freq).append("\n");
		
		int range = arr[N - 1] - arr[0];
		sb.append(range);
		
		
		System.out.println(sb.toString());
	}
}
