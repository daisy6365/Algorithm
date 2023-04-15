package level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 이진변환반복하기 {
    public static void main(String[] args) {
        String s = "1111111";
        System.out.println(Arrays.toString(solution(s)));
    }
    public static int[] solution(String s) {
        int[] answer = {0,0};

        while(true){
            String[] arr = s.split(""); // 제거할 0을 세기 위한 배열

            // s 가 1일 때 멈춤
            if(s.equals("1")) break;

            // 제거할 0의 갯수
            answer[1] += s.length() - s.replace("0","").length();
            // 0 제거한것의 길이
            s = s.replace("0","");
            int s_len = s.length();


            //길이를 다시 이진변환
            s = "";
            while (true){
                if(s_len <= 0) break;
                s = (s_len % 2) + s;
                s_len /= 2 ;
            }
            answer[0]++; // 이진변환 횟수
        }
        return answer;
    }
}
