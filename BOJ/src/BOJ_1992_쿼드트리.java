import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1992_쿼드트리 {
    static int N;
    static int[][] quadTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        quadTree = new int[N][N];

        //배열에 넣기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j <N; j++) {
                quadTree[i][j] = s.charAt(j)-'0';
            }
        }

        generateQuad(0,0, (int)Math.pow(2,N),1<<N);
    }
    static void generateQuad(int si,int sj,int ei,int ej){
        int mi = (si+ei)/2;
        int mj = (sj+ej)/2;
    }
}
