import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805_나무자르기 {
    static long[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        trees = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <N ; i++) {
            trees[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(trees);
        long result = binarySearch(M, 1, trees[trees.length-1]);
        System.out.println(result);

    }

    private static long binarySearch(long M, long left, long right){
        while (left <= right) {
            long mid = (left + right) / 2;
            long temp_M = calculate(mid);
            if (temp_M < M) right = mid - 1;
            else left = mid + 1;
        }
        return right;
    }

    private static long calculate(long mid){
        long sum = 0;
        for (int i = 0; i < trees.length; i++) {
            if(trees[i] > mid){
                sum += (trees[i] - mid);
            }
        }
        return sum;
    }
}
