import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3052_나머지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 10;

        int[] remains = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            remains[i] = num % 42;
        }

        int count =0;
        for (int i = 0; i < N; i++) {
            boolean flag = false;
            for (int j = i+1; j < N; j++) {
                if(remains[i] == remains[j]){
                    flag = true;
                }
            }
            if(flag){count++;}
        }

        System.out.println(10-count);
    }
}
