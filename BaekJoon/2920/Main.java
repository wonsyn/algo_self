package bj_2920_음계;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int arr[] = new int[8];
		String str = "";
		for(int i = 0; i < 8; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		if(arr[0] > arr[1]) {
			str = "descending";
			for(int i = 1; i < 8; i++) {
				if(arr[i] > arr[i - 1]) {
					str = "mixed";
					break;
				}
			}
		} else if(arr[0] < arr[1]) {
			str = "ascending";
			for(int i = 1; i < 8; i++) {
				if(arr[i] < arr[i - 1]) {
					str = "mixed";
					break;
				}
			}
		}
		
		System.out.println(str);
	}
}
