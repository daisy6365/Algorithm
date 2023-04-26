import java.util.*;
import java.io.*;

public class BOJ_1138_한줄로서기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        List<Integer> list = new ArrayList<>();


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = N ; i >= 1; i--){
            list.add(arr[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for(int n : list){
            sb.append(n).append(" ");
        }

        System.out.println(sb);
    }
}
