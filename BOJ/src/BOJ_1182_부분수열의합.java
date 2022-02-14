import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182_부분수열의합 {
    static int N,S;
    static int result;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        int [] num_arr = new int[N];
        isSelected = new boolean[N];
        st =  new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            num_arr[n] = Integer.parseInt(st.nextToken());
        }

        recursion(0,num_arr,0);
        System.out.println(result-1);
    }
    static void recursion(int cnt, int num_arr[], int sum) {
        if (cnt == N) {
            int falseCnt = 0;
            for (int i = 0; i < N; i++) {
                if (!isSelected[i]) {
                    falseCnt++;
                }
            }
            if (falseCnt != N) {
                if (sum == S) {
                    result++;
                }

            }
            return;
        }
        isSelected[cnt] = true;
        recursion(cnt + 1, num_arr, sum + num_arr[cnt]);
        isSelected[cnt] = false;
        recursion(cnt + 1, num_arr, sum);
    }

}