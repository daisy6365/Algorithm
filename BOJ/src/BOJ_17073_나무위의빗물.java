import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17073_나무위의빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken()); //트리노드의 수
        int W = Integer.parseInt(st.nextToken()); //1번노드에 고인 물의 양

        int[] tree = new int[N+1];

        //N-1개의 간선 정보
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine()," ");

            int U = Integer.parseInt(st.nextToken()); //트리노드의 수
            int V = Integer.parseInt(st.nextToken()); //1번노드에 고인 물의 양
            tree[U]++;
            tree[V]++;
        }

        int count = 0; //자손노드 갯수
        for (int i = 2; i<=N; i++) {
            if(tree[i] ==1){
                count++;
            }
        }
        System.out.println((double) W/count);
    }
}
