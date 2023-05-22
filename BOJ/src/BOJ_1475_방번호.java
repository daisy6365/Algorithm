import java.util.*;
import java.io.*;

public class BOJ_1475_방번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        String num = br.readLine();

        for(int i = 0; i < num.length(); i++){
            int temp = Character.getNumericValue(num.charAt(i));

            if (temp == 6) {
                arr[9]++;
            }else{
                arr[temp]++;
            }
        }

        int answer = 0;
        for(int i = 0 ; i < 9 ;i++){
            answer = Math.max(answer, arr[i]);
        }

        int nine = arr[9] / 2;
        if(arr[9] % 2 == 1) nine++;
        answer = Math.max(answer, nine);
        System.out.println(answer);
    }
}
