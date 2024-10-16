import java.util.*;
import java.io.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Arrays.sort(cards);
        for(int i = 0; i < M; i++) {
            boolean isContain = binary(cards, Integer.parseInt(st.nextToken()));
            if(!isContain) {
                sb.append(0).append(" ");
            } else {
                sb.append(1).append(" ");
            }
        }
        System.out.println(sb);
        br.close();
    }

    static boolean binary(int[] cards, int num) {
        int max = cards.length;
        int min = 0;

        while(min < max) {
            int mid = (max + min) / 2;
            int card = cards[mid];
            if(card > num) {
                max = mid;
            } else if (card < num){
                min = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
