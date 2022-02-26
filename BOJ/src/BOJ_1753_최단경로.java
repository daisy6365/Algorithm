import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1753_최단경로 {
    static int V,E;
    static int start;
    static LinkedList<Edge>[] adjList;
    static int[] dist;


    public static class Edge implements Comparable<Edge>{
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }


        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        adjList = new LinkedList[V+1];
        for (int v = 1; v <= V; v++) {
            adjList[v] = new LinkedList<>();//정점의 갯수만큼 리스트 객체 생성
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[from].add(new Edge(to,weight)); //방향성 없는 양방향 그래프는 양쪽에 추가하면 됨
        }
        dijkstra();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=V ; i++) {
            if(dist[i] == Integer.MAX_VALUE) sb.append("INF");
            else sb.append(dist[i]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void dijkstra(){
        dist = new int[V+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        //경유지 설정
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[start] =0; //출발점에서 출발점 까지의 거리 0
        pq.add(new Edge(start,0));

        boolean[] isSelected = new boolean[V+1];
        while(!pq.isEmpty()){
            Edge edge = pq.poll(); //현재 있는 가장 잛은 간선이 나옴 -> 그 끝에 달려있는 정점을 경유지로 비교하기

            int curr = edge.to; // 현재 거쳐가는 것을 고려하는 경유지

            if(isSelected[curr]) continue;
            for(Edge e : adjList[curr]){ //현재 경유지에서 나가는 간선들을 탐색
                if(dist[e.to] > dist[curr]+e.weight){ // 해당 간선으로 가는 정점까지의 기존 거리와 경유지 거쳐가는 거리 비교
                    dist[e.to] = dist[curr]+ e.weight; //경유지 거쳐가는게 더 짧은 거리니까 거리갱신
                    pq.add(new Edge(e.to, dist[e.to])); // 지금 나타난 거리가 짧으니까 그 정점까지의 거리정보 넣어서 이따 경유지 되게함
                }
            }
        }
    }
}