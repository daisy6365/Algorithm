import java.util.Arrays;

public class 모의고사 {
    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2};
        System.out.println(Arrays.toString(solution(answers)));

        int[] answers1 = {1,2,3,4,5};
        System.out.println(Arrays.toString(solution(answers1)));
    }
    public static int[] solution(int[] answers) {
        int[] omr1 = {1, 2, 3, 4, 5};
        int[] omr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] omr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int [] omr_arr = new int[]{search(omr1, answers), search(omr2, answers), search(omr3, answers)};

        int max = omr_arr[0];
        // 많이 맞은 사람들 수
        int index = 1;
        // 많이 맍은 사람들의 각각 번호
        for(int i = 1 ; i < omr_arr.length; i++){
            if(max == omr_arr[i]){
                index++;
            }
            else if(max < omr_arr[i]){
                max = omr_arr[i];
            }
        }

        int j = 0;
        int[] answer = new int[index];
        for (int i = 0; i < omr_arr.length; i++) {
            if(max == omr_arr[i]){
                answer[j] = i+1;
                j++;
            }
        }
        return answer;
    }

    private static int search(int[] omr, int[] answers){
        int count = 0;
        int i = 0;
        int j = 0;
        while(true){
            if(i == answers.length) break;
            if(j == omr.length) j = 0;
            if(omr[j] == answers[i]) {
                count++;
            }
            i++;
            j++;
        }
        return count;
    }
}
