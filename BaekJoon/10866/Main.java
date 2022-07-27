package bj_10866_덱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> dq = new ArrayDeque<>();

		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			
			String cmd = st.nextToken();
			
			switch(cmd) {
			case "push_front": 
				dq.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				dq.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if(dq.isEmpty()) sb.append(-1).append("\n");
				else sb.append(dq.removeFirst()).append("\n");
				break;
			case "pop_back":
				if(dq.isEmpty()) sb.append(-1).append("\n");
				else sb.append(dq.removeLast()).append("\n");
				break;
			case "size": 
				sb.append(dq.size()).append("\n");
				break;
			case "empty":
				if(dq.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case "front":
				if(dq.isEmpty()) sb.append(-1).append("\n");
				else sb.append(dq.peekFirst()).append("\n");
				break;
			case "back":
				if(dq.isEmpty()) sb.append(-1).append("\n");
				else sb.append(dq.peekLast()).append("\n");
				break;
			}
		}
		
		System.out.print(sb.toString());
	}
}
