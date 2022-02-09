import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3499_퍼펙트셔플 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for(int tc =1 ;tc<=TC;tc++){
            int N = Integer.parseInt(br.readLine());
            String[] before_arr = new String[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i=0;i<N;i++){
                before_arr[i] = st.nextToken();
            }

            int half = (N+1)/2;
            String[] head_arr = new String[N];
            String[] tail_arr = new String[N];
            for(int j=0;j<half-1;j++){
                if(j %2 ==0){
                    head_arr[j] = before_arr[j];
                }
                if(j %2 == 1){
                    tail_arr[j] = before_arr[j+half];
                }
            }
            System.out.print("#"+tc+" ");
            for(int i=0;i<N;i++){
            }
            System.out.println();
        }
    }
}
