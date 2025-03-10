import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String emoji = br.readLine();
        int colon = 0;
        int under = 0;
        for(int i = 0; i < emoji.length(); i++) {
            if(emoji.charAt(i) == ':') {
                colon++;
            } else if(emoji.charAt(i) == '_') {
                under++;
            }
        }
        System.out.println(emoji.length() + colon + under * 5);
        br.close();
    }
}