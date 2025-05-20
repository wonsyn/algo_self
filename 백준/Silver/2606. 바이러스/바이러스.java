import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] computers;
    static boolean[] infected;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int com = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());

        computers = new boolean[com + 1][com + 1];
        infected = new boolean[com + 1];
        infected[1] = true;

        for(int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            computers[x][y] = computers[y][x] = true;
        }

        infect(1);

        count = 0;
        for(int i = 2; i < com + 1; i++) {
            if(infected[i]) count++;
        }
        System.out.println(count);

        br.close();
    }

    static void infect(int start) {
        for(int i = 1; i < computers.length; i++) {
            if(computers[start][i]) {
                if(!infected[i]) {
                    infected[i] = true;
                    infect(i);
                }
            }
        }
    }
}