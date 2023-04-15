package level1;

import java.util.Arrays;
import java.util.Collections;

class 문자열내림차순으로배치하기 {
    public String solution(String s) {
        String answer = "";
        Character [] arr = new Character[s.length()];
        for(int i = 0; i < s.length(); i++){
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr, Collections.reverseOrder());

        for(int i = 0; i < arr.length; i++){
            answer += arr[i];
        }
        return answer;
    }
}