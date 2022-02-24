import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_1251_하나로 {
    static int[] parents;
    static double ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for (int tc = 1; tc <= TC; tc++) {
            int N = sc.nextInt();

            int[] x = new int[N];
            int[] y = new int[N];

            for (int i = 0; i < N; i++) {
                x[i] = sc.nextInt();
            }
            for (int i = 0; i < N; i++) {
                y[i] = sc.nextInt();
            }
            double E = sc.nextDouble();
            // end input

            PriorityQueue<Edge> pq = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) { // i번섬과 j번섬 사이의 거리 제곱들 계산
                    long xx = (long)Math.abs(x[i]-x[j])*Math.abs(x[i]-x[j]);
                    long yy = (long)Math.abs(y[i]-y[j])*Math.abs(y[i]-y[j]);
                    pq.add(new Edge(i, j, xx*E+yy*E)); // x좌표 차이제곱 * y좌표 차이제곱 => 거리제곱 * 환경세율 = 환경부담금(간선비용)
                }
            }

            // 크루스칼로 mst 만들기 시작
            parents = new int[N];
            for(int i=0; i<N; i++) { // init
                parents[i] = i;
            }

            double ans = 0;
            int cnt=0; // 선택한 간선 갯수(섬의갯수 - 1)
            while(true) {
                Edge edge = pq.poll(); // 짧은 순서대로 간선 빼기
                if(union(edge.n1, edge.n2)) { // 해당 간선 연결해도 되는지 체크
                    cnt++;
                    ans += edge.fee;
                }
                if(cnt == N-1)
                    break;
            }
            System.out.println("#"+tc+" "+Math.round(ans));
            System.out.printf("#%d %.0f\n", tc, ans);
        }
    }

    static boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        if(p1==p2) return false;

        parents[p1] = p2;
        return true;
    }

    static int find(int n) {
        if(parents[n] == n)
            return n;
        return parents[n] = find(parents[n]);
    }

    static class Edge implements Comparable<Edge> { // 크루스칼에서 사용하는 간선객체
        int n1, n2;
        double fee; // 환경부담금 = 간선비용

        Edge(int n1, int n2, double fee) {
            this.n1 = n1;
            this.n2 = n2;
            this.fee = fee;
        }

        @Override
        public int compareTo(Edge o) {
            if(this.fee>o.fee)
                return 1;
            else if(this.fee < o.fee)
                return -1;
            return 0;
        }
    }
}