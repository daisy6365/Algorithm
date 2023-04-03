import java.util.*;
import java.io.*;

public class BOJ_1316_그룹단어체커 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 0 ; i < N ; i++){
            String s = br.readLine();
            boolean check[] = new boolean[26];
            boolean flag = true;

            for (int j = 0; j < s.length(); j++) {
                int index = s.charAt(j)-'a';
                if(check[index]) {
                    if(s.charAt(j) != s.charAt(j-1)) {
                        flag = false;
                        break;
                    }
                }else {
                    check[index] = true;
                }
            }
            if(flag) count++;
        }

        System.out.println(count);
    }
}
