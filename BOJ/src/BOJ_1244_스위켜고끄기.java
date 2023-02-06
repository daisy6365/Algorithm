import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1244_스위켜고끄기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int switch_count = Integer.parseInt(br.readLine());

        Boolean[] switch_arr = new Boolean[switch_count];
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < switch_count; i++) {

            // 삼항연산자
            if(Integer.parseInt(st.nextToken()) == 1) switch_arr[i] = true;
            else switch_arr[i] = false;
        }
        int student_num = Integer.parseInt(br.readLine());
        for (int i = 0; i < student_num; i++) {
            st= new StringTokenizer(br.readLine()," ");

            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if(gender == 1){
                //남자
                // j가 증가 할때 배수만큼 증가하도록
                for (int j = 1; j <= switch_count ; j++) {
                    if(j % number == 0){
                        // 배수일때 바꿈
                        switch_arr[j-1] = !switch_arr[j-1];
                    }
                }
            }
            else{
                //여자
                // 일단 자기자신 번호 바꿈
                switch_arr[number-1] = !switch_arr[number - 1];
                // 대칭 & 같은 상태인것 바꿈
                for (int j = 1; j < switch_count/2;  j++) {
                    // 양끝이면 break
                    if(number - 1 + j >= switch_count || number - 1 - j < 0) break;
                    if(switch_arr[number - 1 - j] == switch_arr[number - 1 + j]) {
                        switch_arr[number - 1 - j] = !switch_arr[number - 1 - j];
                        switch_arr[number - 1 + j] = !switch_arr[number - 1 + j];
                    }
                    else break;
                }
            }
        }

        for(int i=0; i<switch_count; i++) {
            if(switch_arr[i]){
                System.out.print("1 ");
            }
            else
                System.out.print("0 ");
            if((i+1) % 20 == 0)
                System.out.println();
        }
    }
}