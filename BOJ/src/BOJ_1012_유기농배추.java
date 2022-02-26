import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {
    static int[] di = { 0, -1, 0, 1 };
    static int[] dj = { 1, 0, -1, 0 };
    static int M, N, K;
    static int[][] farm;
    static boolean[][] isSelected;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC ; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            M = Integer.parseInt(st.nextToken()); // 가로길이
            N = Integer.parseInt(st.nextToken()); // 세로길이
            K = Integer.parseInt(st.nextToken()); // 배추갯수

            farm = new int[M][N];
            isSelected = new boolean[M][N];
            count = 0;

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int m = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                farm[m][n] = 1;
            }

            for (int m = 0; m < M; m++) {
                for (int n = 0; n < N; n++) {
                    if (farm[m][n] == 1 && !isSelected[m][n]) {
                        //dfs(m, n);
                        bfs(m,n);
                        count++;
                    }
                }
            }

            System.out.println(count);

        }
    }

    public static void dfs(int nowi,int nowj){
        isSelected[nowi][nowj] = true;
        for (int i = 0; i < 4; i++) {
            int nexti = nowi + di[i];
            int nextj = nowj + dj[i];

            if (nexti >= 0 && nextj >= 0 && nexti < M && nextj < N) {
                if (!isSelected[nexti][nextj] && farm[nexti][nextj] == 1) {
                    dfs(nexti, nextj);
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
                    if (!isSelected[nexti][nextj] && farm[nexti][nextj] == 1) {
                        bfs(nexti, nextj);
                    }
                }

            }
        }
    }
}
