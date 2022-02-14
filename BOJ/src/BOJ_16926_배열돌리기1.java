import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926_배열돌리기1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N][M];
        int copy[][] = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                copy[i][j] = arr[i][j];
            }
        }

        int min = Math.min(N, M);
        while (R-- > 0) {
            for (int circle = 0; circle < min / 2; circle++) {
                int li = circle;
                int lj = circle;
                int ri = N - 1 - circle;
                int rj = M - 1 - circle;
                for (int i = lj; i < rj; i++) {
                    arr[li][i] = copy[li][i + 1];
                }
                for (int i = li + 1; i < ri + 1; i++) {
                    arr[i][lj] = copy[i - 1][lj];
                }
                for (int i = lj + 1; i < rj + 1; i++) {
                    arr[ri][i] = copy[ri][i - 1];
                }
                for (int i = ri - 1; i >= li; i--) {
                    arr[i][rj] = copy[i + 1][rj];
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    copy[i][j] = arr[i][j];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
