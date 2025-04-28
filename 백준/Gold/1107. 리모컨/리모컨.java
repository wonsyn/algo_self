import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int dest = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		boolean[] err = new boolean[10];
		if(N != 0) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				err[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		int ans = Math.abs(dest - 100);
		for(int i = 0; i <= 999999; i++) {
			String cur = Integer.toString(i);
			
			boolean useErr = false;
			for(int j = 0; j < cur.length(); j++) {
				if(err[cur.charAt(j) - '0']) {
					useErr = true; break;
				}
			}
			
			if(!useErr) {
				ans = Math.min(ans, cur.length() + Math.abs(dest - i));
			}
		}
		
		System.out.print(ans);
	}
}
