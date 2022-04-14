import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1929_소수구하기 {
    public static void main(String[] args) throws IOException { //이 줄에서부터
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        final int SIZE = 1000001;
        boolean[] arr = new boolean[SIZE];

        arr[1] = true;

        for (int i = 2; i <= N; i++) {
            for(int j = 2; i*j <= N ; j++) {
                arr[i*j] = true;
            }
        }

        for (int i = M; i <= N ; i++) {
            if(arr[i] == false) System.out.println(i);
        }

    }
}
