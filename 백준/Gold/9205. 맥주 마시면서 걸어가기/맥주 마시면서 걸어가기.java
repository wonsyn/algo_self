import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] c, g;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			c = new int[N + 2][2];
			g = new int[N + 2][N + 2];	// 시작 : 0, 도착 : N + 1
			for(int i = 0; i < N + 2; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				c[i][0] = Integer.parseInt(st.nextToken());
				c[i][1] = Integer.parseInt(st.nextToken());
			}
            
			boolean[] v = new boolean[N + 2];
			boolean isHappy = false;
			
			Queue<Integer> q = new ArrayDeque<>();
			v[0] = true;
			q.offer(0);
			
			while(!q.isEmpty() && !isHappy) {
				int cur = q.poll();
				
				for(int i = 0; i < N + 2; i++) {
					if(!v[i] && Math.abs(c[cur][0] - c[i][0]) + Math.abs(c[cur][1] - c[i][1]) <= 1000) {
						v[i] = true;
						if(i == N + 1) isHappy = true;
						q.offer(i);
					}
				}
			}
			sb.append(isHappy? "happy" : "sad").append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
}