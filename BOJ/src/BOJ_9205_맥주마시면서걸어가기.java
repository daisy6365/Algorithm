import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_9205_맥주마시면서걸어가기 {
    static Point[] points; // 0:출발, 1~N:편의점, N+1:도착
    static boolean result; // 도착여부
    static boolean[] visit; // 해당정점 방문 여부
    static int N; // 편의점 갯수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();
        for(int tc=1; tc<=TC; tc++) {
            N = sc.nextInt();

            points = new Point[N+2];
            for(int i=0; i<=N+1; i++) {
                points[i] = new Point(sc.nextInt(), sc.nextInt());
            }
            visit = new boolean[N+2];
            result = false;
//			dfs(0);
            bfs();
            System.out.println(result?"happy":"sad");
        }

    }
    private static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        visit[0] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            if(now == N+1) {
                result = true;
                return;
            }
            for(int i=1; i<=N+1; i++) {
                int dist = Math.abs(points[now].x - points[i].x) + Math.abs(points[now].y - points[i].y);
                if(!visit[i] && dist<=1000) {
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
    }
    private static void dfs(int now) {
        visit[now] = true;

        if(now == N+1) { // 도착!
            result = true; // happy~~
            return;
        }

        for(int i=1; i<=N+1; i++) {
            int dist = Math.abs(points[now].x - points[i].x) + Math.abs(points[now].y - points[i].y);
            if(!visit[i] && dist<=1000) {
                dfs(i);
            }
        }

    }
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}