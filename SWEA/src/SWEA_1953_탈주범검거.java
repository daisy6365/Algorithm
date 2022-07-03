import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1953_탈주범검거 {
    static int[][] map;
    static int N, M, si, sj, L; // 맵크기, 시작점 좌표, 제한 시간

    // UP, RIGHT, DOWN, LEFT
    static int[] di = { -1, 0, 1, 0 };
    static int[] dj = { 0, 1, 0, -1 };

    static int[][] block_hole = {
            {}, // 0번 블럭 없음.
            {1,1,1,1}, //
            {1,0,1,0},
            {0,1,0,1},
            {1,1,0,0},
            {0,1,1,0},
            {0,0,1,1},
            {1,0,0,1}
    };

    static boolean[][] visit;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for(int tc=1; tc<=TC; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();

            map = new int[N][M];
            visit = new boolean[N][M];

            si = sc.nextInt(); // 시작지점
            sj = sc.nextInt();
            L = sc.nextInt(); // 제한시간

            for(int i=0; i<N; i++) { // 전체 파이프 맵 구조 입력
                for(int j=0; j<M; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            bfs();
            System.out.println("#"+tc+" "+ans);
        }
    }

    private static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(si, sj));
        visit[si][sj] = true;

        int time = 1; // 출발점에 진입하는데 이미 1시간 소요됨.
        ans = 1; // 큐에 집어넣는 장소가 탈주범이 있을수 있는 장소갯수임.
        while(!queue.isEmpty()) {
            //print();
            if(time>=L) break; // 제한시간이 흘러서 중단

            int size = queue.size();
            for(int s=0; s<size; s++) {
                Point now = queue.poll();

                for(int d=0; d<4; d++) {
                    if(block_hole[map[now.i][now.j]][d]==1) { // 현재 블럭에서 d 방향이 뚫려있는지 체크
                        int nexti = now.i + di[d];
                        int nextj = now.j + dj[d];

                        if(nexti<0 || nexti>=N || nextj<0 || nextj>=M || map[nexti][nextj]==0 || visit[nexti][nextj]) continue;

                        if(block_hole[map[nexti][nextj]][(d+2)%4]==1) { //옆 블럭의 현재방향d 반대방향(d+2)%4가 뚫려있는지 체크
                            queue.add(new Point(nexti, nextj));
                            visit[nexti][nextj] = true;
                            ans++;
                        }
                    }
                }
            }
            time++;
        }
    }
    static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j]) {
                    switch (map[i][j]) {
                        case 1:
                            System.out.print("┼ ");
                            break;
                        case 2:
                            System.out.print("│ ");
                            break;
                        case 3:
                            System.out.print("─ ");
                            break;
                        case 4:
                            System.out.print("└ ");
                            break;
                        case 5:
                            System.out.print("┌ ");
                            break;
                        case 6:
                            System.out.print("┐ ");
                            break;
                        case 7:
                            System.out.print("┘ ");
                            break;
                        default:
                            System.out.print("○ ");
                    }
                } else
                    System.out.print("X ");
            }
            System.out.println();
        }
    }
    static class Point{
        int i, j;
        Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}