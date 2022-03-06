import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_3190_뱀 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //지도 크기
        int K = Integer.parseInt(br.readLine()); //사과 갯수
        int[][] map = new int[N][N];
        int[][] apple = new int[K][2];

        for (int i = 0; i < K; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine()," ");
            apple[i][0] = Integer.parseInt(st.nextToken());
            apple[i][1] = Integer.parseInt(st.nextToken());
        }

        int L = Integer.parseInt(br.readLine());//방향 변환 횟수
        
    }
}
