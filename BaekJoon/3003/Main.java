package bj_3003_킹퀸룩비숍나이트폰;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int[] arr = {1, 1, 2, 2, 2, 8};
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < 6; i++) {
			sb.append(arr[i] - Integer.parseInt(st.nextToken())).append(" ");
		}
		
		System.out.print(sb.toString());
	}
}
