
import java.io.*;
import java.util.*;

public class Main {
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};	// 상우하좌
	static char[][] pic;
	static boolean[][] visited;
	static int N, rgBlind = 0, normal = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		pic = new char[N][];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++)
			pic[i] = br.readLine().toCharArray();
		
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfs(i, j, true);
					rgBlind++;
				}
			}
		}
		
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfs(i, j, false);
					normal++;
				}
			}
		}
		
		System.out.println(normal + " " + rgBlind);
		br.close();
	}
	
	static void dfs(int x, int y, boolean isRedGreen) {
		visited[x][y] = true;
		char cur = pic[x][y];
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dir[d][0];
			int ny = y + dir[d][1];
			
			if(0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
				
				if(pic[nx][ny] == cur)
					dfs(nx, ny, isRedGreen);
				else {
					if(isRedGreen && (cur == 'R' || cur == 'G') && (pic[nx][ny] == 'R' || pic[nx][ny] == 'G'))
						dfs(nx, ny, isRedGreen);
				}
			}
		}
	}
}
