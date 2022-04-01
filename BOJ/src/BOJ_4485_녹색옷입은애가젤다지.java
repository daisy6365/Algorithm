import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4485_녹색옷입은애가젤다지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] di = { 0, -1, 0, 1 };
        int[] dj = { 1, 0, -1, 0 };

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = map[0][0];
        int temp = Integer.MAX_VALUE;
        int r=0,c=0;
        while(true){
            if(r == N-1 && c == N-1) break;
            for (int k = 0; k < 4; k++) {
                int nexti = r + di[k];
                int nextj = c + dj[k];

                if(nexti >= 0 && nexti<N && nextj >=0 && nextj < N){
                    System.out.println("r : "+ r+" c : "+c+ "temp : "+temp+" min : " + min);
                    if(map[nexti][nextj] < temp){
                        min += map[nexti][nextj];
                        temp = map[nexti][nextj];
                        r = nexti;
                        c = nextj;
                        System.out.println("real r : "+ r+"real c : "+c+ "real temp : "+temp+"real min : " + min);
                    }
                    else{
                        min += temp;
                    }
                }
            }
        }
        System.out.println(min);
    }
}
