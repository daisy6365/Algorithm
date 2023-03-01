import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 인접리스트 + BFS + DFS
public class BOJ_1260_DFS와BFS {
    static ArrayList<Integer>[] graph;
    static boolean[] isSelected_dfs;
    static boolean[] isSelected_bfs;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int V = Integer.parseInt(st.nextToken()); // 정점 갯수
        int E = Integer.parseInt(st.nextToken()); // 간선 갯수
        int start_v = Integer.parseInt(st.nextToken()); // 시작 정점 번호

        // 인접리스트
        graph = new ArrayList[V+1];
        isSelected_dfs = new boolean[V+1];
        isSelected_bfs = new boolean[V+1];
        // 배열안에 리스트 초기화
        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int edge_x = Integer.parseInt(st.nextToken());
            int edge_y = Integer.parseInt(st.nextToken());
            graph[edge_x].add(edge_y);
            graph[edge_y].add(edge_x);
        }

        // 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문
        for (int i = 0; i <= V; i++) {
            Collections.sort(graph[i]);
        }

        dfs(start_v);
        sb.append("\n");
        bfs(start_v);

        System.out.println(sb);
    }

    private static void dfs(int start_v){
        isSelected_dfs[start_v] = true;
        sb.append(start_v + " ");
        for (int next_v :graph[start_v]) {
            if(!isSelected_dfs[next_v]){
                dfs(next_v);
            }
        }
    }

    private static void bfs(int start_v){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start_v);
        isSelected_bfs[start_v] = true;

        while (!queue.isEmpty()){
            int temp = queue.poll();
            sb.append(temp + " ");

            for (int next_v : graph[temp]) {
                if(!isSelected_bfs[next_v]){
                    queue.offer(next_v);
                    isSelected_bfs[next_v] = true;
                }
            }
        }
    }
}
