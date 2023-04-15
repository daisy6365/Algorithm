package level1;

import java.util.*;

public class 자릿수더하기 {
    public int solution(int n) {
        int answer = 0;
        while(true){
            answer += n % 10;
            if(n < 10){
                break;
            }
            n /= 10;
        }

        return answer;
    }
}