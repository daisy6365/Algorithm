
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1208_Flatten {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());

            int [] flatten = new int[100];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");


            for (int i = 0; i < 100; i++) {
                flatten[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                Arrays.sort(flatten);
                flatten[0] += 1;
                flatten[99] -= 1;
            }
            Arrays.sort(flatten);

            System.out.println("#"+tc+" "+(flatten[99]-flatten[0]));
        }
    }
}
