import java.util.*;
import java.io.*;

public class BOJ_15652_N과M4 {
    static int N, M;
    static int[] arr;
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        backtracking(0);
        System.out.println(sb);
    }

    private static void backtracking(int index){
        if(index == M){
            boolean flag = true;
            for(int i = 1 ; i < M ; i++){
                if(arr[i-1] > arr[i]){
                    flag = false;
                }
            }
            if(flag){
                for(int i = 0 ; i < M ; i++){
                    sb.append(arr[i] + " ");
                }
                sb.append("\n");
            }
            return;
        }
        for(int i = 1; i <= N ; i++){
            arr[index] = i;
            backtracking(index + 1);
        }

    }

}
