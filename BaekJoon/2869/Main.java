package bj_2869_달팽이는올라가고싶다;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		int gap = A - B;
		
		int res = (V - A) / gap;
		
		if((V - A) % gap == 0) {
			res++;
		} else {
			res += 2;
		}
		
		System.out.println(res);
	}
}
