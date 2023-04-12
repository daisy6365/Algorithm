import java.util.*;
import java.io.*;

public class BOJ_15655_N과M6 {
    static int N, M;
    static int[] num, arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        arr = new int[M];
        backtracking(0, 0);
        System.out.println(sb);
    }

    private static void backtracking(int index, int start){
        if(index == M){
            for(int i = 0 ;i < arr.length ; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");

            return;
        }
        for(int i = start; i < N ; i++){
            arr[index] = num[i];
            backtracking(index+1, i+1);
        }
    }
}
