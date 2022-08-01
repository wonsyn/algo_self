package bj_11866_요세푸스문제0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		sb.append("<");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			arr.add(i + 1);
		}
		int idx = K - 1;
		
		while(!arr.isEmpty()) {
			int cur = idx;
			sb.append(arr.remove(idx));
			if(arr.size() == 0)	{
				sb.append(">");
				break;
			}
			else {
				sb.append(", ");
				idx = (idx + K) % arr.size() - 1;
				if(idx == -1) idx = arr.size() - 1;
			}
		}
		
		System.out.print(sb.toString());
	}
}
