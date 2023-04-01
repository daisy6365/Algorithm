import java.util.*;
import java.io.*;

public class BOJ_2075_N번째큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Double> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0 ; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N; j++){
                q.offer(Double.parseDouble(st.nextToken()));
            }
        }

        int count = 1;
        while(true){
            if(count == N){
                System.out.println(Math.round(q.poll()));
                return;
            }
            q.poll();
            count++;
        }

    }
}
