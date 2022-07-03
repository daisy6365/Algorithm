import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3307_최장증가수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            int N = Integer.parseInt(br.readLine());//수열의 길이
            int[] arr = new int[N];
            int[] count = new int[N];
            count[0] = 1;


            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }


            int resultMax = Integer.MIN_VALUE;
            for (int i = 1; i < N; i++) {
                count[i] = 1;
                for (int j = 0; j < i; j++) {
                    if(arr[i] > arr[j] && (count[j] + 1 > count[i])){
                        count[i] = count[j]+1;
                    }
                }
                resultMax = Math.max(count[i], resultMax);
            }

            System.out.println("#"+tc+" "+resultMax);
        }
    }
}
