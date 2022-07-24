package bj_10816_숫자카드2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(map.containsKey(num)) map.put(num, map.get(num) + 1);
			else map.put(num, 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(map.containsKey(num)) sb.append(map.get(num)).append(" ");
			else sb.append("0 ");
		}
		
		System.out.print(sb.toString());
	}
}
