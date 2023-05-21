import java.util.*;
import java.io.*;

public class BOJ_11508_2더하기1세일 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer [N];

        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Comparator.reverseOrder());

        int answer = 0;
        for(int i = 0 ; i < N ; i++){
            if(i % 3 == 2) continue;
            answer += arr[i];
        }

        System.out.println(answer);
    }
}
