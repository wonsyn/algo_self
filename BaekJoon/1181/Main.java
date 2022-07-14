package bj_1181_단어정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		String[] arr = new String[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int len_diff = o1.length() - o2.length();
				if(len_diff == 0) {
					for(int i = 0; i < o1.length(); i++) {
						int char_diff = o1.charAt(i) - o2.charAt(i);
						if(char_diff != 0) return char_diff;
					}
					return 0;
				}
				return len_diff;
			}
		});
		
		for(int i = 0; i < N - 1; i++) {
			if(arr[i].equals(arr[i + 1])) continue;
			sb.append(arr[i]).append("\n");
		}
		
		sb.append(arr[N - 1]);
		
		System.out.println(sb);
	}
}
