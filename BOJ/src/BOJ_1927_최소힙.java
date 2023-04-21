import java.util.*;
import java.io.*;

public class BOJ_1927_최소힙 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2) -> {
            return o1 - o2;
        });
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N ; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                }
                else{
                    sb.append(pq.poll()).append("\n");
                }
            }
            else{
                pq.offer(num);
            }
        }

        System.out.println(sb);
    }
}
