
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_2304.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Stack<Stick> s1 = new Stack<>();
		Stack<Stick> s2 = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Stick> arr = new ArrayList<>();
		
		for(int l = 0; l < N; l++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr.add(new Stick(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(arr);
		
		for (int i = 0; i < N; i++) {
			Stick s = arr.get(i);
			if(s1.empty()) s1.push(s);
			if(s1.peek().h <= s.h) s1.push(s);
		}
		for (int i = N - 1; i >= 0; i--) {
			Stick s = arr.get(i);
			if(s2.empty()) s2.push(s);
			if(s2.peek().h <= s.h) s2.push(s);
			if(s1.peek().h == s.h) {
				s1.pop();
				s1.push(s);
			}
		}
		
		int sum = 0;
		int center = ((s1.peek().idx + 1) - s2.peek().idx) * s1.peek().h;
		sum += center;
		
		while(!s1.isEmpty()) {
			Stick high = s1.pop();
			if(!s1.isEmpty()) {
				Stick low = s1.peek();
				sum += (high.idx - low.idx) * low.h;
			}
		}
		while(!s2.isEmpty()) {
			Stick high = s2.pop();
			if(!s2.isEmpty()) {
				Stick low = s2.peek();
				sum += ((low.idx + 1) - (high.idx + 1)) * low.h;
			}
		}
		
		System.out.println(sum);
		
	}
	
	static class Stick implements Comparable<Stick>{
		int idx;
		int h;
		
		Stick (int idx, int h){
			this.idx = idx;
			this.h = h;
		}

		@Override
		public int compareTo(Stick o) {
			if(this.idx > o.idx) return 1;
			else if (this.idx < o.idx) return -1;
			return 0;
		}
		
		@Override
		public String toString() {
			return "{" + this.idx + ", " + this.h + "}";
		}
	}
}
