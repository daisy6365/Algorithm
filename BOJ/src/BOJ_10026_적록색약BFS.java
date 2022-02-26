import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026_적록색약BFS {
    static int[] di = { 0, -1, 0, 1 };
    static int[] dj = { 1, 0, -1, 0 };
    static int N;
    static char[][] RGB;
    static boolean[][] isSelectedNomal,isSelectedSpecial;
    static int countNomal, countSpecial;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        RGB = new char[N][N];
        isSelectedNomal = new boolean[N][N];
        isSelectedSpecial = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                RGB[i][j] = s.charAt(j);
            }
        }

        countNomal=0;
        countSpecial =0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!isSelectedNomal[i][j]){
                    nomalBFS(i,j);
                    //bfs(i,j)
                    countNomal++;
                }
                if(!isSelectedSpecial[i][j]){
                    specialBFS(i,j);
                    //bfs(i,j)
                    countSpecial++;
                }
            }
        }
        System.out.println(countNomal+" "+countSpecial);
    }
    public static void nomalBFS(int nowi, int nowj){
        Queue<int[]> qu = new LinkedList<int[]>();
        qu.add(new int[] { nowi, nowj });

        while (!qu.isEmpty()) {
            nowi = qu.peek()[0];
            nowj = qu.peek()[1];
            isSelectedNomal[nowi][nowj] = true;
            qu.poll();

            for (int i = 0; i < 4; i++) {
                int nexti = nowi + di[i];
                int nextj = nowj + dj[i];

                if(nexti >=0 && nextj >= 0 && nexti < N && nextj<N ){
                    if(!isSelectedNomal[nexti][nextj] && RGB[nowi][nowj] == RGB[nexti][nextj]){
                        nomalBFS(nexti,nextj);
                    }
                }

            }
        }
    }
    public static void specialBFS(int nowi, int nowj) {
        Queue<int[]> qu = new LinkedList<int[]>();
        qu.add(new int[] { nowi, nowj });

        while (!qu.isEmpty()) {
            nowi = qu.peek()[0];
            nowj = qu.peek()[1];
            isSelectedSpecial[nowi][nowj] = true;
            qu.poll();

            for (int i = 0; i < 4; i++) {
                int nexti = nowi + di[i];
                int nextj = nowj + dj[i];

                if(nexti >=0 && nextj >= 0 && nexti < N && nextj<N ){
                    if(!isSelectedSpecial[nexti][nextj]){
                        if((RGB[nowi][nowj] == 'G' && RGB[nexti][nextj]=='R') ||
                                (RGB[nowi][nowj] == 'R' && RGB[nexti][nextj]== 'G') ||
                                (RGB[nowi][nowj] == RGB[nexti][nextj])){
                            specialBFS(nexti,nextj);
                        }
                    }
                }

            }
        }
    }
}
