import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3985_롤케이크 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine()); // 롤케이크 갈이
        int N = Integer.parseInt(br.readLine()); // 방청객 수

        int[] rollCake = new int[L];
        int[] person = new int[N+1];
        int predictMax = Integer.MIN_VALUE;
        int predictNum = 0;
        int realMax = Integer.MIN_VALUE;
        int realNum = 0;
        person[0] = 0;
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int P = Integer.parseInt(st.nextToken()); //P번째 조각 부터
            int K = Integer.parseInt(st.nextToken()); //K번째 조각 까지
            if(predictMax < (K-P+1)){
                predictMax = Math.max(predictMax,(K-P+1));
                predictNum = i;
            }
            for (int j = P-1; j <= K-1; j++) {
                if(rollCake[j] == 0){
                    rollCake[j] = i;
                }
            }
        }

        for (int i = 1; i < person.length; i++) {
            for (int j = 0; j < rollCake.length; j++) {
                if(i == rollCake[j]){
                    person[i]++;
                }
            }
        }

        for (int i = 0; i < person.length; i++) {
            if(realMax < person[i]){
                realMax = person[i];
                realNum = i;
            }
        }
        System.out.println(predictNum);
        System.out.println(realNum);
    }
}
