import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5643_키순서 {

    static int N, M;
    static boolean[] visited;
    static int[][] adjMatrix;
    static StringBuilder sb = new StringBuilder();
    static int gtDfsCnt, ltDfsCnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            adjMatrix = new int[N + 1][N + 1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjMatrix[from][to] = 1;

            }
            int ans = 0;
            for (int i = 1; i <= N; i++) {
                gtDfsCnt = ltDfsCnt=0;
                gtDfs(i,new boolean[N+1]);
                ltDfs(i,new boolean[N+1]);
                if (gtDfsCnt + ltDfsCnt == N - 1) {
                    ans++;
                }


//				if (gtBfs(i) + ltBfs(i) == N - 1) {
//					ans++;
//				}
            }
            System.out.println(ans);
        }

    }

    static int gtBfs(int start) {// 자신보다 큰애를 따라서 탐색 행으로 보기
        Queue<Integer> q = new LinkedList<Integer>();
        boolean[] visit = new boolean[N + 1];
        q.offer(start);
        visit[start] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i <= N; i++) {
                if (!visit[i] && adjMatrix[cur][i] == 1) {
                    q.offer(i);
                    visit[i] = true;
                    ++cnt;
                }
            }

        }
        return cnt;
    }

    static int ltBfs(int start) {// 자신보다 작은 학생을 따라서 탐색 열로 보기
        Queue<Integer> q = new LinkedList<Integer>();
        boolean[] visit = new boolean[N + 1];
        q.offer(start);
        visit[start] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i <= N; i++) {
                if (!visit[i] && adjMatrix[i][cur] == 1) {
                    q.offer(i);
                    visit[i] = true;
                    ++cnt;
                }
            }
        }
        return cnt;
    }

    static void gtDfs(int cur, boolean[] visited) {// 자신보다 큰애를 따라서 탐색 행으로 보기
        visited[cur] = true;// 현재학생은 탐색을했습니다!!
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && adjMatrix[cur][i] == 1) {
                ++gtDfsCnt;
                gtDfs(i, visited);
            }
        }
    }

    static void ltDfs(int cur, boolean[] visited) {// 자신보다 큰애를 따라서 탐색 행으로 보기
        visited[cur] = true;// 현재학생은 탐색을했습니다!!
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && adjMatrix[i][cur] == 1) {
                ++ltDfsCnt;
                ltDfs(i, visited);
            }
        }
    }

}