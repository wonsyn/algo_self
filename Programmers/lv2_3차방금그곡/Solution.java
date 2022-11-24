package programmers_lv2_3차방금그곡;

public class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int maxPlay = -1;
        m = changeMelody(m);

        for(int i = 0; i < musicinfos.length; i++) {
            String musicinfo = musicinfos[i];
            String[] info = musicinfo.split(",");
            String[] temp = info[0].split(":");
            int start = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
            temp = info[1].split(":");
            int end = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
            int time = end - start;
            info[3] = changeMelody(info[3]);
            StringBuilder sb = new StringBuilder();
            if(time >= info[3].length()) {
                for(int j = 0; j < (time / info[3].length()); j++) {
                    sb.append(info[3]);
                }
            }
            sb.append(info[3].substring(0, time % info[3].length()));
            info[3] = sb.toString();
            if(info[3].contains(m) && maxPlay < time) {
                answer = info[2];
                maxPlay = time;
            }
        }
        return maxPlay == -1 ? "(None)" : answer;
    }

    public String changeMelody(String s) {
        s = s.replaceAll("C#", "H");
        s = s.replaceAll("D#", "I");
        s = s.replaceAll("F#", "J");
        s = s.replaceAll("G#", "K");
        s = s.replaceAll("A#", "L");
        return s;
    }
}
