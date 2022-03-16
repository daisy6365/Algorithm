import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1197_최소스패닝트리 {
    static int V,E;
    static int[] parents;
    static Edge[] edgeList;

    //단위 집합 생성
    public static void makeSet(){
        parents = new int[V+1];
        // 자신의 부모노드를 자신의 값으로 세팅
        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }
    }
    //a의 집합 찾기(대표자 찾기)
    public static int findSet(int a){
        if(a==parents[a]) return a;
        //루트노드의 값으 나의 부모로 대체
        return parents[a] = findSet(parents[a]);
    }

    //a, b 두집합 합치기
    public static boolean union(int a, int b){
        //합쳐졌다면 true 합칠 필요가 없다면 false
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) return false;

        //a 뒤에 b 붙임 -> b의 루트가 a의 루트
        parents[bRoot] = aRoot;
        return true;
    }

    static class Edge implements Comparable<Edge>{
        int from,to,weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
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
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        V = Integer.parseInt(st.nextToken());    // 정점 개수
        E = Integer.parseInt(st.nextToken());    // 간선 개수

        edgeList = new Edge[E];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList[i] = new Edge(from,to,weight);
        }
        Arrays.sort(edgeList); //간선비용의 오름차순 정렬

        makeSet();
        int result = 0,cnt =0;
        for (Edge e : edgeList) {
            if(union(e.from,e.to)){
                result += e.weight;
                if(++cnt == V-1) break;
            }
        }
        System.out.println(result);

    }
}
