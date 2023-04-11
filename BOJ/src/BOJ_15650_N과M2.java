import java.util.*;
import java.io.*;

public class BOJ_15650_N과M2 {
    static int N, M;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isSelected = new boolean[N+1];
        backtracking(0, 1);
    }

    private static void backtracking(int index, int start){
        if(index == M){
            for(int i = 1 ; i <= N ; i++){
                if(isSelected[i]){
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            return;
        }
        for(int i = start; i <= N; i++){
            isSelected[i] = true;
            backtracking(index+1, i+1);
            isSelected[i] = false;
        }
    }
}
