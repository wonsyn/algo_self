import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr = new int[9][9];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		for(int i = 0; i < 9; i++) {
			String s = br.readLine(); 
			for(int j = 0; j < 9; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		go(0, 0, 0);
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
	
	static boolean go(int x, int y, int cnt) {
		if(cnt == 81) {
			return true;
		}
		
		if(arr[x][y] == 0) {
			for(int i = 1; i <= 9; i++) {
				if(!isPossible(x, y, i)) continue;
				
				arr[x][y] = i;
				if(y == 8) {
					if(go(x + 1, 0, cnt + 1)) return true;
				}
				else {
					if(go(x, y + 1, cnt + 1)) return true;
				}
				
				arr[x][y] = 0;
			}
		}
		else {
			if(y == 8) {
				if(go(x + 1, 0, cnt + 1)) return true;
			}
			else {
				if(go(x, y + 1, cnt + 1)) return true;
			}
		}
		return false;
	}
	
	static boolean isPossible(int x, int y, int num) {
		for(int i = 0; i < 9; i++) {
			if(arr[i][y] == num || arr[x][i] == num) return false;
		}
		
		int r = x / 3 * 3;
		int c = y - y % 3;
		for(int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) {
				if(arr[i][j] == num) return false;
			}
		}
		return true;
	}
}
