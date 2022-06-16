import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {-1, 0, 1, 0};

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        int r = Integer.parseInt(st.nextToken()); //로봇청소기 위치
        int c = Integer.parseInt(st.nextToken()); //로봇청소기 위치
        int d = 3 - Integer.parseInt(st.nextToken()); //로봇청소기 방향

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 1;
        dfs(r, c, d, visited);
        System.out.println(count);
    }

    public static void dfs(int r, int c, int d, boolean[][] visited) {

        visited[r][c] = true;

        int nexti, nextj;
        for (int i = 0; i < 4; i++) {
            d = ++d % 4; // 방향 돌아가며 탐색
            nexti = r + di[d];
            nextj = c + dj[d];

            if (!visited[nexti][nextj] && map[nexti][nextj] != 1) {
                dfs(nexti, nextj, d, visited);
                count++;
                return;
            }
        }

        nexti = r - di[d];
        nextj = c - dj[d];

        if (map[nexti][nextj] != 1) {// 벽 아님
            dfs(nexti, nextj, d, visited);// 후진
        } else {// 벽 일때
            return; //작동 멈추기
        }

    }
}
