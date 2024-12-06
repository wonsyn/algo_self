import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if('a' <= c && c <= 'z') {
                c = Character.toUpperCase(c);
            } else {
                c = Character.toLowerCase(c);
            }
            sb.append(c);
        }

        System.out.println(sb);
        br.close();
    }
}