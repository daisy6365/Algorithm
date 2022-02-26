import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963_섬의개수 {
    static int[] di = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dj = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int W, H;
    static int[][] map;
    static boolean[][] isSelected;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            if (W == 0 && H == 0) {
                break;
            }

            map = new int[H][W];
            isSelected = new boolean[H][W];
            count = 0;

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine()," ");
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int h = 0; h < H; h++) {
                for (int w = 0; w < W; w++) {
                    if (map[h][w] == 1 && !isSelected[h][w]) {
                        //dfs(h, w);
                        bfs(h,w);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }

    public static void dfs(int nowi,int nowj){
        isSelected[nowi][nowj] = true;
        for (int i = 0; i < 8; i++) {
            int nexti = nowi + di[i];
            int nextj = nowj + dj[i];

            if (nexti >= 0 && nextj >= 0 && nexti < H && nextj < W) {
                if (!isSelected[nexti][nextj] && map[nexti][nextj] == 1) {
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

            for (int i = 0; i < 8; i++) {
                int nexti = nowi + di[i];
                int nextj = nowj + dj[i];

                if (nexti >= 0 && nextj >= 0 && nexti < H && nextj < W) {
                    if (!isSelected[nexti][nextj] && map[nexti][nextj] == 1) {
                        bfs(nexti, nextj);
                    }
                }

            }
        }
    }
}
