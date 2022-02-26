import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109_빵집_DFS {
    static int map[][];
    static boolean[][] visit;
    static int R,C,count;
    static int[] di = {-1, 0, 1}; //위, 직진, 아래
    static int[] dj = {1, 1, 1}; //싹다 오른쪽
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i <R ; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < C; j++) {
                map[i][j] = (s.charAt(j)=='.') ? 0:1;
            }
        }

        count =0;
        for (int i = 0; i < R; i++) {
            DFS(i,0);
        }
        System.out.println(count);
    }

    public static boolean DFS(int nowi, int nowj) {
        visit[nowi][nowj] = true;

        if(nowj == C-1){
            count++;
            return true;
        }
        for (int d = 0; d <3 ; d++) {
            int nexti = nowi + di[d];
            int nextj = nowj + dj[d];
            if(nexti>=0 && nexti<R && nextj>=0 && nextj<C && map[nexti][nextj] == 0 && !visit[nexti][nextj]){
                boolean result = DFS(nexti,nextj);
                if(result == true) return true;

            }

        }
        return false;
    }
}
