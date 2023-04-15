package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class 튜플 {
    public static void main(String[] args) {
        int[] result1 = solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"); // [2, 1, 3, 4]
        System.out.println(Arrays.toString(result1));

        int[] result2 = solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"); // [2, 1, 3, 4]
        System.out.println(Arrays.toString(result2));

        int[] result3 = solution("{{20,111},{111}}"); // [111, 20]
        System.out.println(Arrays.toString(result3));

        int[] result4 = solution("{{123}}"); // 	[123]
        System.out.println(Arrays.toString(result4));

        int[] result5 = solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"); // [3, 2, 4, 1]
        System.out.println(Arrays.toString(result5));
    }
    public static int[] solution(String s) {
        // 괄호 제거
        s = s.substring(2, s.length()-2);
        String[] temp_arr = s.split("},\\{");

        int[] answer = new int[temp_arr.length];
        HashSet<String> hashSet = new HashSet<>();

        int i = 0; // 원소들을 탐색
        int j = 0; // 결과 배열 카운팅
        while(true){
            if(i >= temp_arr.length){
                if(hashSet.size() == temp_arr.length){
                    break;
                }
                i = 0; continue;
            }

            // , 을 기준으로 다시 배열에 담기
            String[] temp = temp_arr[i].split(",");
            if(temp.length == (hashSet.size()+1)){
                for (int k = 0; k < temp.length; k++) {
                    if(hashSet.contains(temp[k])) {
                        continue;
                    }
                    answer[j] = Integer.parseInt(temp[k]);
                    hashSet.add(temp[k]);
                }
                i++;
                j++;
                continue;
            }
            i++;
        }
        return answer;
    }
}
