package bj_10250_ACM호텔;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int H = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int floor = N % H;
			int room = N / H + 1;
			
			if(floor == 0) {
				sb.append(H);
				room--;
			} else {
				sb.append(floor);
			}
			
			if(room < 10) {
				sb.append("0");
			}
			sb.append(room).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}
