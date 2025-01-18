import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean nb = false;
        boolean ob = false;

        if(M == 1 || M == 2) {
            nb = true;
        }
        if(M <= N && !nb) {
            ob = true;
        }

        if(nb) {
            System.out.println("NEWBIE!");
        } else if(ob) {
            System.out.println("OLDBIE!");
        } else {
            System.out.println("TLE!");
        }

        br.close();
    }
}