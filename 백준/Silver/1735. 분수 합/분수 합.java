import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int top1 = Integer.parseInt(st.nextToken());
        int bot1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int top2 = Integer.parseInt(st.nextToken());
        int bot2 = Integer.parseInt(st.nextToken());

        int bot = bot1 * bot2;
        int top = (bot1 * top2) + (bot2 * top1);
        int gcd = gcd(Math.max(bot, top), Math.min(bot, top));

        System.out.println((top / gcd) + " " + (bot / gcd));

        br.close();
    }

    public static int gcd(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}