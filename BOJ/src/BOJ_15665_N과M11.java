import java.util.*;
import java.io.*;

public class BOJ_15665_N과M11 {
    static int N, M;
    static int[] num, arr;
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        isSelected = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        arr = new int[M];
        backtracking(0);
        System.out.println(sb);
    }

    private static void backtracking(int index){
        if(index == M){
            for(int i = 0 ; i < M ; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");

            return;
        }
        int temp = 0;
        for(int i = 0; i < N ; i++){
            if(temp != num[i]){
                temp = num[i];
                arr[index] = num[i];
                backtracking(index+1);
            }

        }
    }
}
