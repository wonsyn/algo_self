package bj_4153_직각삼각형;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[3];
			int max = 0, maxIdx = 0;
			for(int i = 0; i < 3; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if(max < arr[i]) {
					max = arr[i]; maxIdx = i;
				}
			}
			
			if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
				break;
			}
			
			max = max * max;
			int sum = 0;
			for(int i = 0; i < 3; i++) {
				if(i == maxIdx) continue;
				sum += arr[i] * arr[i];
			}
			
			if(sum == max) sb.append("right");
			else sb.append("wrong");
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
