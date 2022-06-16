import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16956_늑대와양 {
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int R,C;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for(int i=0;i<R;i++) {
            String s = br.readLine();
            for(int j=0; j<C; j++) {
                map[i][j]= s.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'W') {
                    if (map[i][j]=='W') {
                        for (int d = 0; d < 4; d++) {
                            int nr = i + di[d];
                            int nc = j + dj[d];

                            if (!(nr>=0 && nr<R && nc>=0 && nc<C)) continue;
                            if (map[nr][nc]=='.') {
                                map[nr][nc]='D';
                            }
                            if (map[nr][nc]=='S') {
                                System.out.println("0");
                                System.exit(0);
                            }
                        }
                    }
                }
            }
        }
        System.out.println("1");
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
