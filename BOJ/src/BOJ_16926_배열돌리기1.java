import java.io.*;
import java.util.*;

public class BOJ_16926_배열돌리기1 {
    static int N, M, R;
    static int[][] arr;
    static int[][] copy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        copy = new int[N][M];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                copy[i][j] = arr[i][j];
            }
        }

        int min = Math.min(N, M) / 2; // min(N, M) mod 2 = 0
        for(int r = 0 ; r < R ; r++){
            for(int i = 0 ; i < min ; i++){
                int temp = arr[i][i]; // 0,0 1,1 2,2
                // 상
                for(int j = i+1 ; j < M- i ; j++){
                    arr[i][j-1] = arr[i][j]; // 오른쪽 값을 왼쪽으로 이동
                }
                // 우
                for(int j = i+1 ; j < N - i ; j++){
                    arr[j-1][M-1-i] = arr[j][M-1-i]; // 아래 값을 위로 이동
                }
                // 하
                for(int j = M-2-i ; j >= i ; j--){
                    arr[N-1-i][j+1] = arr[N-1-i][j]; // 왼쪽 값을 오른쪽으로 이동
                }
                // 좌
                for(int j = N-2-i ; j >= i ; j--){
                    arr[j+1][i] = arr[j][i]; // 위값을 아래로 이동
                }

                // 바로 아래에 넣기
                arr[i+1][i] = temp;
            }
        }

        for(int i = 0 ; i < N ; i++){
            for(int j =0 ; j < M ; j++){
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }

    }
}
//public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//        int R = Integer.parseInt(st.nextToken());
//        int arr[][] = new int[N][M];
//        int copy[][] = new int[N][M];
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            for (int j = 0; j < M; j++) {
//                arr[i][j] = Integer.parseInt(st.nextToken());
//                copy[i][j] = arr[i][j];
//            }
//        }
//
//        int min = Math.min(N, M);
//        while (R-- > 0) {
//            for (int circle = 0; circle < min / 2; circle++) {
//                int li = circle;
//                int lj = circle;
//                int ri = N - 1 - circle;
//                int rj = M - 1 - circle;
//                for (int i = lj; i < rj; i++) {
//                    arr[li][i] = copy[li][i + 1];
//                }
//                for (int i = li + 1; i < ri + 1; i++) {
//                    arr[i][lj] = copy[i - 1][lj];
//                }
//                for (int i = lj + 1; i < rj + 1; i++) {
//                    arr[ri][i] = copy[ri][i - 1];
//                }
//                for (int i = ri - 1; i >= li; i--) {
//                    arr[i][rj] = copy[i + 1][rj];
//                }
//            }
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < M; j++) {
//                    copy[i][j] = arr[i][j];
//                }
//            }
//        }
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//    }