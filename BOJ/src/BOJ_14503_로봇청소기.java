import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다시 풀이
public class BOJ_14503_로봇청소기 {
    // 반시계방향으로 돌아감 상, 좌, 하, 우
    static int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static int[][] map;
    static int N, M, count, robot_di;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int robot_col = Integer.parseInt(st.nextToken()); // 행
        int robot_row = Integer.parseInt(st.nextToken()); // 열
        robot_di = Integer.parseInt(st.nextToken()); // 로봇의 방향 -> 0: 상 1: 우 2: 하 3: 좌

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 1;
        dfs(robot_col, robot_row, saveRobotDirection());
        System.out.println(count);
    }

    private static void dfs(int now_i, int now_j, int d){
        map[now_i][now_j] = 2;

        int next_i, next_j;
        for (int i = 0; i < 4; i++) {
            d = (d+1) % 4;
            next_i = now_i + direction[d][0];
            next_j = now_j + direction[d][1];

            if(next_i >= 0 && next_i < N && next_j >=0 && next_j < M && map[next_i][next_j] == 0){
                // 청소를 해야하는 곳이라면
                dfs(next_i, next_j, d);
                count++;
                return;
            }
        }

        // for문 4방 탐색을 다했는데도 청소할곳 0이 안나옴
        // 벽(1)이거나 청소를 한곳임(2)
        // 바라보는 방향을 유지한 채로 후진
        next_i = now_i - direction[d][0];
        next_j = now_j - direction[d][1];
        if(map[next_i][next_j] == 2){ // 청소를 다해서 후진을 해야해
            dfs(next_i, next_j, d);
        }
        else{ // 벽이야 작동 멈춰
            return;
        }


    }

    private static int saveRobotDirection(){
        if(robot_di == 0){
            return 0;
        }
        else if(robot_di == 1){
            return 3;
        }
        else if(robot_di == 2){
            return 2;
        }
        else {
            return 1;
        }
    }
}

//static int[] di = {0, 1, 0, -1};
//    static int[] dj = {-1, 0, 1, 0};
//
//    static int N, M;
//    static int[][] map;
//    static boolean[][] visited;
//    static int count;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine()," ");
//
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        st = new StringTokenizer(br.readLine()," ");
//        int r = Integer.parseInt(st.nextToken()); //로봇청소기 위치
//        int c = Integer.parseInt(st.nextToken()); //로봇청소기 위치
//        int d = 3 - Integer.parseInt(st.nextToken()); //로봇청소기 방향
//
//        map = new int[N][M];
//        visited = new boolean[N][M];
//
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine()," ");
//            for (int j = 0; j < M; j++) {
//                map[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        count = 1;
//        dfs(r, c, d, visited);
//        System.out.println(count);
//    }
//
//    public static void dfs(int r, int c, int d, boolean[][] visited) {
//
//        visited[r][c] = true;
//
//        int nexti, nextj;
//        for (int i = 0; i < 4; i++) {
//            d = ++d % 4; // 방향 돌아가며 탐색
//            nexti = r + di[d];
//            nextj = c + dj[d];
//
//            if (!visited[nexti][nextj] && map[nexti][nextj] != 1) {
//                dfs(nexti, nextj, d, visited);
//                count++;
//                return;
//            }
//        }
//
//        nexti = r - di[d];
//        nextj = c - dj[d];
//
//        if (map[nexti][nextj] != 1) {// 벽 아님
//            dfs(nexti, nextj, d, visited);// 후진
//        } else {// 벽 일때
//            return; //작동 멈추기
//        }
//
//    }
