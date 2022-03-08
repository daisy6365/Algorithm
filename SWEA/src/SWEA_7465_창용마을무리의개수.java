import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_7465_창용마을무리의개수 {
    static int N;
    static StringBuilder sb;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        int T = sc.nextInt();
        for(int t =1;t<=T;t++) {
            N = sc.nextInt();
            int M = sc.nextInt();
            map = new int[N+1][N+1];
            visited = new boolean[N+1];

            for(int i=0;i<M;i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();

                map[from][to]=map[to][from]=1;
            }
            int cnt=0;
            for(int i=1;i<=N;i++) {
                if(!visited[i]) {
                    bfs(i);
                    cnt++;
                }
            }
            sb.append("#"+t+" "+cnt+"\n");
        }
        System.out.print(sb.toString());
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.offer(start);
        visited[start]=true;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(int i=1;i<=N;i++) {
                if(!visited[i]&&map[current][i]!=0) {
                    visited[i]=true;
                    queue.offer(i);
                }
            }
        }
    }
}