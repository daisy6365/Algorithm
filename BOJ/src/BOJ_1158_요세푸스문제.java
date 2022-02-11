import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158_요세푸스문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 1; i <=N; i++) {
            queue.offer(i);
        }

        int out = 0;
        ArrayList<Integer> out_arr = new ArrayList<>();
        while(!queue.isEmpty()){
            for (int i = 1; i < K; i++) {
                int temp = queue.poll();
                queue.offer(temp);
            }
            out = queue.poll();
            out_arr.add(out);
        }
        System.out.print("<");
        for (int i = 0; i < N-1; i++) {
            System.out.print(out_arr.get(i)+", ");
        }
        System.out.print(out_arr.get(N-1)+">");
        System.out.println();
    }
}
