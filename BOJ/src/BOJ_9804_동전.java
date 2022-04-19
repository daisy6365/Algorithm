import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9804_동전 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            int N = Integer.parseInt(br.readLine()); //동전 가지 수 N
            int[] coinArr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i <N; i++) {
                coinArr[i] = Integer.parseInt(st.nextToken()); //N가지 동전의 단위
            }

            int M = Integer.parseInt(br.readLine()); // 만들어야 할 금액 M
            int[] dp = new int[M+1];
            dp[0] = 1;


            for (int i = 0; i < N; i++) {
                for (int m = coinArr[i]; m <= M; m++) {
                    dp[m] += dp[m-coinArr[i]];
                }
            }

            System.out.println(dp[M]);
        }
    }
}
