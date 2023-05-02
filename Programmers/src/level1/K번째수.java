package level1;

import java.util.Arrays;

public class K번째수 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(solution(array, commands)));
    }
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int [] temp_arr = new int[commands[i][1] - commands[i][0] + 1];
            int num = commands[i][0]-1;

            // copyOfRange를 쓰면 좀 더 간결함!!
            for (int j = 0; j < temp_arr.length; j++) {
                temp_arr[j] = array[num++];
            }
            Arrays.sort(temp_arr);

            answer[i] = temp_arr[commands[i][2]-1];
        }

        return answer;
    }
}
