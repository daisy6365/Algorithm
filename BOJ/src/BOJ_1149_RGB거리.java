import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] RGB = new int[N][3];
        StringTokenizer st= null;
        for (int i = 0; i < N; i++) {
            st =  new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < 3; j++) {
                RGB[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if(j == 0){
                    //빨간색
                    RGB[i][j] += Math.min(RGB[i - 1][1], RGB[i - 1][2]);
                }
                else if(j==1){
                    //초록색
                    RGB[i][j] += Math.min(RGB[i - 1][0], RGB[i - 1][2]);

                }
                else if(j==2){
                    //파란색
                    RGB[i][j] += Math.min(RGB[i - 1][0], RGB[i - 1][1]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(RGB[N-1][i],min);
        }

        System.out.println(min);
    }
}
