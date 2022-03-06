import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14696_딱지놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 총 게임 수

        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            int a_A = Integer.parseInt(st.nextToken()); //A의 그림 갯수
            int[] card_A = new int[5];
            for (int i = 0; i < a_A; i++) {
                int input = Integer.parseInt(st.nextToken());
                card_A[input]++;
            }

            st = new StringTokenizer(br.readLine()," ");
            int a_B = Integer.parseInt(st.nextToken()); //B의 그림 갯수
            int[] card_B = new int[5];
            for (int i = 0; i < a_B; i++) {
                int input = Integer.parseInt(st.nextToken());
                card_B[input]++;
            }

            boolean result =false;
            for (int i = 4; i > 0; i--) {
                if ( card_A[i] > card_B[i]) {
                    System.out.println("A");
                    result =true;
                    break;
                }
				else if(card_A[i] < card_B[i]){
                    System.out.println("B");
                    result =true;
                    break;
                }
            }
            if (!result) System.out.println("D");
        }
    }
}
