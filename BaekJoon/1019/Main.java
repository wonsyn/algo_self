package bj_1019_체스판다시칠하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] paper;
	static int N, M, min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		paper = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				if(str.charAt(j) == 'B') paper[i][j] = false;
				else paper[i][j] = true;
			}
		}
		
		for(int i = 0; i <= N - 8; i++) {
			for(int j = 0; j <= M - 8; j++) {
				calc(i, j);
			}
		}
		
		System.out.println(min);
	}
	
	static void calc(int x, int y) {
		int next;
		int cnt = 0;
		boolean cur = paper[x][y];
		
		for(int i = x; i < x + 8; i++) {
			for(int j = y; j < y + 8; j++) {
				if(cur != paper[i][j]) {
					cnt++;
				}
				cur = !cur;
			}
			cur = !cur;
		}
		
		cnt = Math.min(cnt, 64 - cnt);
		min = Math.min(cnt, min);
	}
}
