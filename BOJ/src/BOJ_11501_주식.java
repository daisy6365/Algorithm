import java.util.*;
import java.io.*;

public class BOJ_11501_주식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < T ; i++){
            int N = Integer.parseInt(br.readLine());
            long[] arr = new long[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                arr[j] = Long.parseLong(st.nextToken());
            }

            long result = 0;
            long max = 0;
            for(int j = N-1 ; j >= 0 ; j--){
                if(max < arr[j]){
                    max = arr[j];
                }
                else{
                    result += (max - arr[j]);
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
