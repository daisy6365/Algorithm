import java.util.*;
import java.io.*;

public class BOJ_10773_제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < N; i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0){
                stack.pop();
            }
            else{
                stack.push(temp);
            }
        }

        int sum = 0;
        for(int num : stack){
            sum += num;
        }

        System.out.println(sum);
    }
}
