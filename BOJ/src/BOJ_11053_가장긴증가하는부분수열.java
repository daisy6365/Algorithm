import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053_가장긴증가하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = 1;
            for (int j = 0; j < i; j++) {
                if(num[i] > num[j] && arr[i] < 1+ arr[j]){
                    arr[i] = 1 + arr[j];
                }
            }
            max = Math.max(max,arr[i]);
        }
        System.out.println(max);
    }
}
