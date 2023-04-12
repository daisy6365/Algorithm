import java.io.*;
import java.util.*;

public class BOJ_2961_도영이가만든맛있는음식 {
    static int N;
    static int[][] arr;
    static int temp_sub, temp_min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        temp_sub = 0;
        temp_min = Integer.MAX_VALUE;

        per(0, 1, 0);
        System.out.println(temp_min);
    }
    private static void per(int count, int totalS, int totalB){
        if(count == N){
            if(totalB == 0) return;
            temp_sub = Math.abs(totalS - totalB);
            temp_min = Math.min(temp_sub, temp_min);
            return;
        }
        per(count + 1, arr[count][0] * totalS, arr[count][1] + totalB);
        per(count + 1, totalS, totalB);

    }
}
