package bj_1436_영화감독숌;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int num = 0, cnt = 0;
		
		while(true) {
			if(Integer.toString(num).contains("666")) {
				cnt++;
			}
			if(cnt == N) break;
			num++;
		}
		System.out.println(num);
	}
}
