package bj_10845_큐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new ArrayDeque<Integer>();
		int back = -1;
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("push")) {
				back = Integer.parseInt(st.nextToken());
				q.offer(back);
			} else if(cmd.equals("pop")) {
				if(q.isEmpty()) sb.append(-1);
				else sb.append(q.poll());
				sb.append("\n");
			} else if(cmd.equals("size")) {
				sb.append(q.size()).append("\n");
			} else if(cmd.equals("empty")) {
				if(q.isEmpty()) sb.append(1);
				else sb.append(0);
				sb.append("\n");
			} else if(cmd.equals("front")) {
				if(q.isEmpty()) sb.append(-1);
				else sb.append(q.peek());
				sb.append("\n");
			} else if(cmd.equals("back")) {
				if (q.isEmpty()) sb.append(-1);
				else sb.append(back);
				sb.append("\n");
			}
		}
		System.out.print(sb.toString());
	}
}
