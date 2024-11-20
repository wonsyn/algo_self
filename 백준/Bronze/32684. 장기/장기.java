import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int[] score;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        score = new int[] {13, 7, 5, 3, 3, 2};
        double cho = 0;
        double han = 1.5;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i : score) {
            cho += Integer.parseInt(st.nextToken()) * i;
        }
        st = new StringTokenizer(br.readLine());
        for(int i : score) {
            han += Integer.parseInt(st.nextToken()) * i;
        }

        System.out.println(cho < han ? "ekwoo" : "cocjr0208");
        br.close();
    }
}