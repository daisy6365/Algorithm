import java.util.*;
class 옹알이1 {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] word = {"aya", "ye", "woo", "ma"};

        for(int i =0; i < babbling.length ; i++){
            for(int j = 0; j < word.length ; j++){
                if(babbling[i].contains(word[j])){
                    babbling[i] = babbling[i].replace(word[j], "#");
                }

            }
            babbling[i] = babbling[i].replace("#", "");
            if(babbling[i].isEmpty()){
                answer++;
            }
        }

        return answer;
    }
}