import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> list = new ArrayList<>();
        
        StringTokenizer st = new StringTokenizer(today, ".");
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken()) + year * 12;
        int day = Integer.parseInt(st.nextToken()) + month * 28;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < terms.length; i++) {
            st = new StringTokenizer(terms[i]);
            char c = st.nextToken().charAt(0);
            int d = Integer.parseInt(st.nextToken()) * 28;
            map.put(c, day - d);
        }
        
        StringTokenizer st2;
        for(int i = 0; i < privacies.length; i++) {
            st = new StringTokenizer(privacies[i]);

            st2 = new StringTokenizer(st.nextToken(), ".");
            int y = Integer.parseInt(st2.nextToken());
            int m = Integer.parseInt(st2.nextToken()) + y * 12;
            int d = Integer.parseInt(st2.nextToken()) + m * 28;
            
            char t = st.nextToken().charAt(0);
            int td = map.get(t);
            if(td >= d) {
                list.add(i + 1);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}