import java.util.*;
import java.io.*;

public class BOJ_2003_수들의합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] num = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int count = 0;
        int start = 0;
        int end = 0;

        while(true){
            if(sum >= M){
                // sum 이 M보다 크거나 같음
                // sum에서 빼주고 start++
                sum -= num[start++];
            }
            else if (end == N){
                // 끝남
                break;
            }
            else {
                // sum 이 M보다 작음
                // 그 다음수를(end++) 더 더해줌
                sum += num[end++];
            }

            if(sum == M){
                // 같다면
                count++;
            }
        }


        System.out.println(count);
    }
}
