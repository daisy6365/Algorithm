import java.util.*;
import java.io.*;

public class BOJ_15663_N과M9 {
    static int N,M;
    static boolean[] isSelected;
    static int[] arr, result_arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result_arr = new int[M];
        isSelected = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        subSet(0);
    }

    private static void subSet(int count){
        if(count == M){
            for(int i = 0; i < M ; i++){
                System.out.print(result_arr[i] + " ");
            }
            System.out.println();
            return;
        }
        int temp = 0;
        for(int i = 0; i < N ; i++){
            if(!isSelected[i] && temp != arr[i]){
                isSelected[i] = true;
                result_arr[count] = arr[i];
                temp = arr[i];
                subSet(count + 1);
                isSelected[i] = false;
            }
        }
    }
}
