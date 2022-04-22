import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_161998_에너지모으기 {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result=0;
        recur(0,0);
        System.out.println(result);
    }

    public static void recur(int idx, int sum){
        if (idx == N-2) {
            result = Math.max(sum, result);
            return;
        }

        for (int i = 1; i < N-1; i++) {
            if(visited[i]) continue;
            int left = i, right = i;
                while(left-- > 0) {
                    if (!visited[left]) break;
                }
                while(right++ < N - 1) {
                    if (!visited[right]) break;
                }
            visited[i] = true;
            recur(idx + 1, sum + (arr[left] * arr[right]));
            visited[i] = false;
        }
    }
}