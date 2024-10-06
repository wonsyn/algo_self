package bj_18258_큐2;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/bj_18258_큐2/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int commandCnt = Integer.parseInt(br.readLine());

        for(int i = 0; i < commandCnt; i++) {
            st = new StringTokenizer(br.readLine());

            switch(st.nextToken()) {
                case "push":
                    q.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    if(q.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(q.poll()).append("\n");
                    break;
                case "size" :
                    sb.append(q.size()).append("\n");
                    break;
                case "empty" :
                    if(q.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front" :
                    if (q.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(q.getFirst()).append("\n");
                    break;
                case "back" :
                    if(q.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(q.getLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
        br.close();
    }
}
