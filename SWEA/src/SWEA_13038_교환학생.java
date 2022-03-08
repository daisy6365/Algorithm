import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_13038_교환학생 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC ; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[] weeks = new int[7];

            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int i = 0; i < 7; i++) {
                weeks[i] =  Integer.parseInt(st.nextToken());
            }

            int min = Integer.MAX_VALUE;
            for (int start = 0; start < 7; start++) {
                if(weeks[start] == 0) continue;
                int day = start,count=0;
                while(true){
                    if(weeks[day%7]==1) count++;
                    ++day;
                    if(count == n){
                        //머무른 최소일수
                        min = Math.min(min,day-start);
                        break;
                    }
                }
            }
            System.out.println("#"+tc+" "+min);
        }
    }
}
