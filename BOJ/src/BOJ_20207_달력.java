import java.util.*;
import java.io.*;

public class BOJ_20207_달력 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] schedule = new int[366];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for(int j = start ; j <= end ; j++){
                // 일정만큼 ++해줌 같으면 +1 되겠지
                schedule[j]++;
            }
        }

        int result = 0;
        int height = 0;
        int width = 0;
        for(int i = 0 ; i < 366 ; i++){
            if(schedule[i] == 0){
                // 끊어가야함
                result += (width * height);
                width = 0;
                height = 0;
                continue;
            }
            width++;
            height = Math.max(height, schedule[i]);
        }
        // 마지막
        result+= (width * height);

        System.out.println(result);
    }
}
