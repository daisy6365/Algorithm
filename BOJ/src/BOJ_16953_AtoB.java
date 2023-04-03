import java.io.*;
import java.util.*;

public class BOJ_16953_AtoB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int answer = 1;
        while(true){
            if(B == A) break;
            if(B % 2 != 0){
                String B_temp = String.valueOf(B);
                if(B_temp.length() >= 2 && B_temp.charAt(B_temp.length()-1) == '1'){
                    B = Integer.parseInt(B_temp.substring(0, B_temp.length() -1));
                    answer++;
                    continue;
                }
                else{
                    System.out.println(-1);
                    return;
                }
            }
            else{
                B /= 2;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
