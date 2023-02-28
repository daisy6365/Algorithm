import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 인접행렬 + DFS 사용
public class BOJ_2606_바이러스 {
    static int[][] graph;
    static boolean[] isSelected;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        graph = new int[V+1][V+1];
        isSelected = new boolean[V+1];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int edge_x = Integer.parseInt(st.nextToken());
            int edge_y = Integer.parseInt(st.nextToken());
            graph[edge_x][edge_y] = 1; // 그래프 서로 연결
            graph[edge_y][edge_x] = 1; // 그래프 서로 연결
        }

        count = 0;
        virus_dfs(1);

        System.out.println(count);
    }

    private static void virus_dfs(int v){
        // 방문체크
        isSelected[v] = true;
        // 해당 정점v를 기준으로 탐색 -> 1부터 graph 크기까지만
        for (int i = 1; i < graph.length; i++) {
            // 해당 그래프의 정점들이 서로 연결되어있고( == 1), 방문하지 않았을 때
            if(graph[v][i] == 1 && !isSelected[i]){
                // 카운팅
                count++;
                // 그다음꺼 dfs 탐색
                virus_dfs(i);
            }
        }
    }
}
