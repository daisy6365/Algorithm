import java.util.*;
import java.io.*;


/**
 * 재귀 문제에서 시간 초과가 나면 StringBuilder를 사용하는 것이 좋음
 */
public class BOJ_15651_N과M3 {
    static int N,M;
    static int[] arr;
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
            for(int i = 0; i < arr.length ; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1 ; i <= N; i++){
            arr[index] = i;
            backtracking(index + 1);
        }
    }
}
