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

        int arr []= {0,127,0,254};
        for (int i = 0; i < K; i++) {
            //int px= (whiteBall_y * arr[j] - whiteBall_y * arr[])*(x3-x4) - (x1-x2)*(x3*y4 - y3*x4);
            //int py= (x1*y2 - y1*x2)*(y3-y4) - (y1-y2)*(x3*y4 - y3*x4);
            //int p = (x1-x2)*(y3-y4) - (y1-y2)*(x3-x4);
        }

        int L = Integer.parseInt(br.readLine());//방향 변환 횟수
        
    }
}
