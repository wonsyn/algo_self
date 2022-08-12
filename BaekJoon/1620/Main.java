package bj_1620_나는야포켓몬마스터이다솜;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<Integer, String> map1 = new HashMap<>();
		Map<String, Integer> map2 = new HashMap<>();
		
		for(int i = 1; i <= N; i++) {
			String str = br.readLine();
			map1.put(i, str);
			map2.put(str, i);
		}
		
		for(int i = 0; i < M; i++) {
			String q = br.readLine();
			char c = q.charAt(0);
			
			if('0' <= c && c <='9') {
				sb.append(map1.get(Integer.parseInt(q))).append("\n");
			} else {
				sb.append(map2.get(q)).append("\n");
			}
		}
		
		System.out.print(sb.toString());
	}
}
