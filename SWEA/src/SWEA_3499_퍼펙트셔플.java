import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3499_퍼펙트셔플 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String [] arr1 = new String[N/2 + (N%2)];
            String [] arr2 = new String[N/2];
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = st.nextToken();
            }
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = st.nextToken();
            }

            System.out.print("#"+tc+" ");
            for (int i = 0; i < arr2.length; i++) {
                System.out.print(arr1[i]+" ");
                System.out.print(arr2[i]+" ");
            }
            if(N%2 == 1){
                System.out.print(arr1[arr1.length-1]);
            }
            System.out.println();

        }
    }
}
