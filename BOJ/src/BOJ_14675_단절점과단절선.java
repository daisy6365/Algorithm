import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 인접리스트 사용
// 트리(tree) : 사이클이 존재하지 않으며, 모든 정점이 연결되어 있는 그래프
public class BOJ_14675_단절점과단절선 {
    static ArrayList<Integer>[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 트리의 정점 개수
        trees = new ArrayList[N+1];

        for (int i = 0; i <= N; i++) {
            trees[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int edge1 = Integer.parseInt(st.nextToken());
            int edge2 = Integer.parseInt(st.nextToken());
            trees[edge1].add(edge2);
            trees[edge2].add(edge1);
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if(t == 2){
                // k번째 간선이 단절선인지
                // 간선을 제거하면 트리는 무조건 둘로 나뉘어짐
                System.out.println("yes");
            }
            else{
                // k번 정점이 단절점인지
                int count = 0;
                for (int e: trees[k]) {
                    count++;
                }
                if(count >= 2){
                    // 2개 이상 -> 둘로 나뉘어짐 (루트, 리프가 아님)
                    System.out.println("yes");
                }else{
                    // 1개 이하 -> 둘로 나눌수 없음 (루트, 리프임)
                    System.out.println("no");
                }
            }
        }
    }
}
