import java.util.*;
import java.io.*;

public class BOJ_8911_거북이 {
    static int minX, maxX, minY, maxY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int t = 0 ; t < T; t++){
            int direction = 1; // 현재 거북이의 방향 1: 상 2: 좌 3: 하 4: 우
            int turtleX = 0, turtleY = 0; // 현재 거북이의 위치
            // 영역 구하기
            minX = Integer.MAX_VALUE;
            maxX = Integer.MIN_VALUE;
            minY = Integer.MAX_VALUE;
            maxY = Integer.MIN_VALUE;
            saveMinMax(turtleX, turtleY); // 초기화된 위치도 영역에 들어감

            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            // 거북 이동
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(c == 'R'){
                    // 방향만 바꿈
                    if(direction == 4) {direction = 1;}
                    else{direction++;}
                }
                else if(c == 'L'){
                    // 방향만 바꿈
                    if(direction == 1) {direction = 4;}
                    else{direction--;}
                }
                else if(c == 'F'){
                    // 방향에 따라 거북 이동
                    if(direction == 1){turtleY++;}
                    else if(direction == 2){turtleX--;}
                    else if(direction == 3){turtleY--;}
                    else {turtleX++;}

                    saveMinMax(turtleX, turtleY);
                }
                else {
                    // B
                    // 방향에 따라 거북 이동
                    if(direction == 1){turtleY--;}
                    else if(direction == 2){turtleX++;}
                    else if(direction == 3){turtleY++;}
                    else {turtleX--;}

                    saveMinMax(turtleX, turtleY);
                }
            }
            int area = Math.abs(maxX - minX) * Math.abs(maxY - minY);
            sb.append(area).append("\n");
        }

        System.out.println(sb);
    }
    public static void saveMinMax(int turtleX, int turtleY){
        minX = Math.min(turtleX, minX);
        maxX = Math.max(turtleX, maxX);
        minY = Math.min(turtleY, minY);
        maxY = Math.max(turtleY, maxY);
    }
}
