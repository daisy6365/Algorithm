import java.util.*;
import java.io.*;

public class BOJ_11008_복붙의달인 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 0; t < T ; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String copy = st.nextToken();
            int count = 0;

            while(true){
                if(!s.contains(copy)) break;
                int num = s.indexOf(copy);
                s = s.substring(0,num) +"*"+ s.substring(num + copy.length());
                count++;
            }

            for(int i = 0 ; i < s.length(); i++){
                if(s.charAt(i) != '*'){
                    count++;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
