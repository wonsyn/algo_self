import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            list.add(s.substring(i));
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(String str : list) {
            sb.append(str).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}