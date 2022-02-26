import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2798_블랙잭 {
    static int N,M;
    static int max_result = Integer.MIN_VALUE;
    static int[] cards;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); // 총카드 갯수
        M = Integer.parseInt(st.nextToken()); // 최대 합

        cards = new int[N];
        result = new int[3];
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        combination(0,0);
        System.out.println(max_result);

    }

    public static void combination(int cnt, int start) {
        if(cnt == 3) { //numbers[R]까지 다 채웠다면
            int sum=0;
            for (int i = 0; i < 3; i++) {
                sum += result[i];
            }
            if(sum <= M){
                max_result = Math.max(max_result,sum);
            }
            return;
        }
        // 순서없이 고르기 때문에 다음 루프때는 현재+1부터만 조회하면 됨
        for(int i=start; i<N; i++) {
            result[cnt] = cards[i];
            combination(cnt+1, i+1);
        }
    }
}
