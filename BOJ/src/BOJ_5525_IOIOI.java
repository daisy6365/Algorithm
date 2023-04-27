import java.util.*;
import java.io.*;

public class BOJ_5525_IOIOI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int S = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();

        int count = 0;
        int result = 0;
        for(int i = 1; i < S-1 ; i++){
            if(s[i-1] == 'I' && s[i] == 'O' && s[i+1] == 'I' ){
                // IOI 일때
                count++;
                if(count == N){
                    // IOI의 규칙이 맞을 때
                    count--;
                    result++;
                }

                i++;
            }
            else{
                count = 0; // 초기화
            }
        }

        System.out.println(result);

    }
}
