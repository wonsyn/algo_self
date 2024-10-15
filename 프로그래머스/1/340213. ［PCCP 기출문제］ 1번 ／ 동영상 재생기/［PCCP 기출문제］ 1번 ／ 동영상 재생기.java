import java.util.*;
import java.io.*;

class Solution {
        public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        StringTokenizer st = new StringTokenizer(video_len, ":");
        Position videoLen = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(pos, ":");
        Position cur = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(op_start, ":");
        Position opStart = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(op_end, ":");
        Position opEnd = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Position start = new Position(0, 0);

        if(cur.compareTo(opStart) >= 0 && cur.compareTo(opEnd) <= 0) {
            cur.minute = opEnd.minute;
            cur.second = opEnd.second;
        }
            
        for(int i = 0; i < commands.length; i++) {
            String command = commands[i];
            if(command.equals("prev")) {
                cur.second -= 10;
                if(cur.second < 0) {
                    cur.minute--;
                    cur.second += 60;
                }
                if(cur.compareTo(start) < 0) {
                    cur.minute = 0;
                    cur.second = 0;
                }
            } else if(command.equals("next")) {
                cur.second += 10;
                if(cur.second >= 60) {
                    cur.minute++;
                    cur.second -= 60;
                }
                if(cur.compareTo(videoLen) > 0) {
                    cur.minute = videoLen.minute;
                    cur.second = videoLen.second;
                }
            }
            
            if(cur.compareTo(opStart) >= 0 && cur.compareTo(opEnd) <= 0) {
                cur.minute = opEnd.minute;
                cur.second = opEnd.second;
            }
        }

        StringBuilder sb = new StringBuilder();
        
        if(cur.minute < 10) {
            sb.append("0");
        }
        sb.append(cur.minute).append(":");
        if(cur.second < 10) {
            sb.append("0");
        }
        sb.append(cur.second);
            
            
        return sb.toString();
    }

    static class Position implements Comparable<Position>{
        int minute;
        int second;
        
        Position(int m, int s) {
            this.minute = m;
            this.second = s;
        }

        @Override
        public int compareTo(Position p) {
            if(this.minute == p.minute) {
                return this.second - p.second;
            } else {
                return this.minute - p.minute;
            }
        }
    }
}