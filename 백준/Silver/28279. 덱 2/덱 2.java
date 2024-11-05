import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            switch(command) {
                case 1:
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case 3:
                    if(dq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(dq.pollFirst()).append("\n");
                    }
                    break;
                case 4:
                    if(dq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(dq.pollLast()).append("\n");
                    }
                    break;
                case 5:
                    sb.append(dq.size()).append("\n");
                    break;
                case 6:
                    sb.append(dq.isEmpty()? 1 : 0).append("\n");
                    break;
                case 7:
                    if(dq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(dq.peekFirst()).append("\n");
                    }
                    break;
                case 8:
                    if(dq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(dq.peekLast()).append("\n");
                    }
                    break;
            }
        }

        System.out.println(sb);
        br.close();
    }
}