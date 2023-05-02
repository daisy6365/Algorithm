package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 문자열내맘대로정렬하기 {
    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"};
        String[] resultArr = solution(strings, 1);
        for (String s : resultArr) {
            System.out.println(s);
        }
    }
    public static String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        int[] arr= {1,2,3,4,5};
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        List<String> tempArr = new ArrayList<>();
        for (String str : strings) {
            tempArr.add(str.charAt(n) + str);
        }
        Collections.sort(tempArr);
        for (int i=0; i<tempArr.size(); i++) {
            answer[i] = tempArr.get(i).substring(1);
        }
        return answer;
    }
}
