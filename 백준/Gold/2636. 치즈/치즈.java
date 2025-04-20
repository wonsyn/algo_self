import java.io.*;
import java.util.*;

public class Main {
	static int N, M, cnt;
	static int[][] dish, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};	// 상 우 하 좌
	static boolean[][] v;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dish = new int[N][M];
		v = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				dish[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		while(!check()) {
			next: for(int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(dish[i][j] == 0 && !v[i][j]) {
						dfs(i, j);
						v = new boolean[N][M];
						time++;
						break next;
					}
				}
			}
		}
		sb.append(time).append("\n").append(cnt);
		System.out.println(sb);
		br.close();
	}
	
	static void dfs(int x, int y) {
		v[x][y] = true;
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dir[d][0];
			int ny = y + dir[d][1];
			if(0 <= nx && nx < N && 0 <= ny && ny < M) {
				if(dish[nx][ny] == 1 && !v[nx][ny]) {
					dish[nx][ny] = 0;
					v[nx][ny] = true;
				}
				if(dish[nx][ny] == 0 && !v[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
	}
	
	static boolean check() {
		int temp = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(dish[i][j] == 1) {
					temp++;
				}
			}
		}
		if (temp == 0) {
			return true;
		}
		
		cnt = temp;
		return false;
	}
}
