import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16938_캠프준비 {
    static int N, L, R, X, result;
    static int[] problems;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        problems = new int[N];
        isSelected = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            problems[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0,0, 0, 0);
        System.out.println(result);
    }

    private static void backtracking(int index, int count, int sum, int sub){
        if(count >= 2){
            if(sum >= L && sum <= R && sub >= X){
                result += 1;
            }
        }

        for (int i = index; i < N; i++) {
            if(!isSelected[i]){
                isSelected[i] = true;
                backtracking(i + 1, count + 1, sum + problems[i], saveMax() - saveMin());
                isSelected[i] = false;
            }
        }
    }
    
    private static int saveMax(){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if(isSelected[i]){
                max = Math.max(max, problems[i]);
            }
        }
        return max;
    }
    private static int saveMin(){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (isSelected[i]){
                min = Math.min(min, problems[i]);
            }
        }
        return min;
    }
}
