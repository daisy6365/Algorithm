import java.util.*;
import java.io.*;

public class BOJ_11659_구간합구하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] num = new int[N+1];
        num[0] = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            num[i] = num[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(num[m] - num[n-1]).append("\n");
        }

        System.out.println(sb);

    }
}
