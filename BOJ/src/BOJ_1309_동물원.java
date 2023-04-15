import java.util.*;
import java.io.*;


public class BOJ_1309_동물원 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 배열을 경우의 수로 나눔
        int[][] dp = new int[N][3]; // 아예없는 , 왼쪽, 오른쪽
        int result = 0;
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;


        for(int i = 1 ; i < N ; i++){
            // 방의 크기를 돌며 경우의 수에 따라 계산을 함

            // 아예없음 -> 이전방에는 어디에나 넣어도 상관 없음
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
            // 왼쪽에 있음 -> 이전방에는 아예없거나 오른쪽에만 가능
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
            // 오른쪽에 있음 -> 이전방에는 아예없거나 왼쪽에만 가능
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;
        }

        for(int i = 0; i < 3 ; i++){
            result += dp[N-1][i];
        }

        System.out.println(result % 9901);

    }
}
