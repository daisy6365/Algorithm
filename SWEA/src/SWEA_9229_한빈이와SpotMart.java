import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_9229_한빈이와SpotMart {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int sum =0;
            int max = -1;

            st = new StringTokenizer(br.readLine()," ");
            int [] snack_Arr = new int[N];
            for (int i = 0; i < N; i++) {
                snack_Arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    sum = snack_Arr[i] + snack_Arr[j];
                    if(sum <= M){
                        max = Math.max(sum,max);
                    }
                }
            }
            System.out.println("#"+tc+" "+max);
        }
    }
}
