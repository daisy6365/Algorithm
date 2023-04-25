import java.util.*;
import java.io.*;

public class BOJ_2304_창고다각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] arr = new int[1001];
        int start = 1001;
        int end = 0;

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            arr[X] = Y;
            start = Math.min(X, start);
            end = Math.max(X, end);
        }


        Stack<Integer> stack = new Stack<>();
        int temp = arr[start];
        // -> 방향
        for(int i = start+1 ; i <= end; i++){
            if(arr[i] < temp){
                stack.push(i);
            }
            else{
                while(!stack.isEmpty()){
                    arr[stack.pop()] = temp;
                }
                temp = arr[i];
            }
        }
        stack.clear();

        temp = arr[end];
        // <- 방향
        for(int i = end-1 ; i >= start; i--){
            if(arr[i] < temp){
                stack.push(i);
            }
            else{
                while(!stack.isEmpty()){
                    arr[stack.pop()] = temp;
                }
                temp = arr[i];
            }
        }

        int result = 0;
        for(int i = start ; i <= end; i++){
            result += arr[i];
        }
        System.out.println(result);
    }
}