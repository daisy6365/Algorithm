import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기 {
    static int N;
    static int[] num_arr;
    static int[] operator_arr;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num_arr = new int[N];
        operator_arr = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num_arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator_arr[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, num_arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    /**
     * backtracking(재귀)에서 초기화의 개념 없음
     * 재귀호출을 하는 과정에서 재귀 param의 값이 초기화됨
     * 재귀가 다 끝나고 나서 값을 초기화 하지 않는다.
     *
     * param 값을 계산 할때엔 backtracking() 인자값 안에 바로 계산해줘야함
     * 아니면 재귀호출 하는 과정에서 값이 이상하게 나옴..
     */
    private static void backtracking(int index, int result){
        if(index == N-1){
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int j = 0; j < 4; j++) {
            if(operator_arr[j] > 0){
                operator_arr[j]--;
                if(j == 0){
                    // +
                    backtracking(index+1, result + num_arr[index + 1]);
                }
                else if(j == 1){
                    // -
                    backtracking(index+1, result - num_arr[index + 1]);
                }
                else if(j == 2){
                    // *
                    backtracking(index+1, result * num_arr[index + 1]);
                }
                else {
                    // /
                    backtracking(index+1, result / num_arr[index + 1]);
                }
                operator_arr[j]++;
            }
        }
    }
}
