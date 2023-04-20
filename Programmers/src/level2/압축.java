package level2;

import java.util.*;

public class 압축 {
    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args){
        System.out.println(Arrays.toString(solution("KAKAO")));


        System.out.println(Arrays.toString(solution("TOBEORNOTTOBEORTOBEORNOT")));

        System.out.println(Arrays.toString(solution("ABABABABABABABAB")));

        System.out.println(Arrays.toString(solution("THATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITIS")));
    }

    public static int[] solution(String msg) {
        initDic();
        List<Integer> answer = new ArrayList<>();

        int max = 26;
        flag: for(int i = 0 ; i < msg.length(); i++){
            for(int j = i+1 ; j <= msg.length(); j++){
                String temp = msg.substring(i,j);
                if(!map.containsKey(temp)){
                    // 이전 글자의 색인번호 출력
                    String temp_before = msg.substring(i,j-1);
                    answer.add(map.get(temp_before));
                    // 사전 추가
                    max++;
                    i = j-2;
                    map.put(temp, max);
                    break;
                }
                if(j == msg.length() || i == msg.length()-1){
                    answer.add(map.get(temp));
                    break flag;
                }
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void initDic(){
        int a = 65;
        for(int i = 1; i <= 26; i++){
            map.put(Character.toString(a), i);
            a++;
        }
    }
}
