package bj_1085_직사각형에서탈출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int x, y, w, h;
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		int ym = Math.min(Math.abs(y - h), y);
		int xm = Math.min(Math.abs(x - w), x);

		int min = Math.min(ym, xm);
		
		System.out.println(min);
	}
}
