import java.util.*;
import java.io.*;

public class BOJ_12919_A와B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        // 문제 :S를 T로 바꾸는 게임
        // 재귀를 돌면서 T를 S로 바꾸게 함

        System.out.println(per(S, T));

    }

    private static int per(String S, String T){
        if(S.length() == T.length()){
            if(S.equals(T)){
                return 1;
            }
            return 0;
        }
        int temp = 0;
        // 맨 뒤가 A
        if(T.charAt(T.length() - 1) == 'A'){
            temp += per(S, T.substring(0, T.length() - 1));
        }
        // 맨 앞이 B
        if(T.charAt(0) == 'B'){
            StringBuilder sb = new StringBuilder(T.substring(1));
            String T_temp = sb.reverse().toString();
            temp += per(S, T_temp);
        }

        // temp > 0 이면 재귀를 돌면서 같은 경우가 있음
        return temp > 0 ? 1 : 0;
    }
}
