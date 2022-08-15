package bj_1764_듣보잡;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> set = new HashSet<>();
		for(int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		ArrayList<String> arr = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			if(set.contains(str)) {
				arr.add(str);
			}
		}
		
		Collections.sort(arr);
		
		for(String str : arr) {
			sb.append(str).append("\n");
		}
		
		System.out.println(arr.size());
		System.out.print(sb.toString());
	}
}
