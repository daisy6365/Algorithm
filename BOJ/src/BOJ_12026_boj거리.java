import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_12026_boj거리 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[] map = new char[N];
        map = br.readLine().toCharArray();

        int max = Integer.MAX_VALUE;
        int[] dist = new int[N];
        Arrays.fill(dist, max);
        dist[0] = 0;	// 처음은 0(B)

        for (int i = 0; i < N; i++) {
            if (dist[i]==max) {	// 갈수없음
                continue;
            }
            for (int j = i+1; j < N; j++) {
                if (map[i] == 'B' && map[j]== 'O') {
                    dist[j]=Math.min(dist[j], (j-i)*(j-i)+dist[i]);
                }
                if (map[i] == 'O' && map[j]== 'J') {
                    dist[j]=Math.min(dist[j], (j-i)*(j-i)+dist[i]);
                }
                if (map[i] == 'J' && map[j]== 'B') {
                    dist[j]=Math.min(dist[j], (j-i)*(j-i)+dist[i]);
                }
            }
        }
        if (dist[N-1]!=max) {	// 마지막 max가 아니면 답 출력
            System.out.println(dist[N-1]);
        }else {
            System.out.println(-1);
        }

    }
}
