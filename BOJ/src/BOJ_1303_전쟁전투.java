import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1303_전쟁전투 {
    static int[] di = { 0, -1, 0, 1 };
    static int[] dj = { 1, 0, -1, 0 };
    static int N,M; // 가로크기, 세로크기 
    static char[][] army;
    static boolean[][] isSelected;
    static int count,resultW =0, resultB =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        army = new char[M][N];
        isSelected = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                army[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(!isSelected[i][j]){
                    count =1;
                    //dfs(i,j);
                    bfs(i,j);
                    if(army[i][j] == 'W'){resultW += Math.pow(count,2);}
                    else{resultB += Math.pow(count,2);}
                }
            }
        }
        System.out.println(resultW +" "+ resultB);

    }
    public static void dfs(int nowi,int nowj){
        isSelected[nowi][nowj] = true;

        for (int i = 0; i < 4; i++) {
            int nexti = nowi + di[i];
            int nextj = nowj + dj[i];

            if(nexti >=0 && nextj>= 0 && nexti < M && nextj < N){
                if(!isSelected[nexti][nextj] && army[nowi][nowj] == army[nexti][nextj]){
                    count += 1;
                    dfs(nexti,nextj);
                }
            }
        }
    }

    public static void bfs(int nowi,int nowj){
        Queue<int[]> qu = new LinkedList<int[]>();
        qu.add(new int[] { nowi, nowj });

        while (!qu.isEmpty()) {
            nowi = qu.peek()[0];
            nowj = qu.peek()[1];
            isSelected[nowi][nowj] = true;
            qu.poll();

            for (int i = 0; i < 4; i++) {
                int nexti = nowi + di[i];
                int nextj = nowj + dj[i];

                if (nexti >= 0 && nextj >= 0 && nexti < M && nextj < N) {
                    if(!isSelected[nexti][nextj] && army[nowi][nowj] == army[nexti][nextj]){
                        count += 1;
                        bfs(nexti,nextj);
                    }
                }

            }
        }
    }
}
