import java.util.*;
import java.io.*;

public class BOJ_11286_절댓값힙 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
            if(Math.abs(o1) == Math.abs(o2)){
                return o1 - o2;
            }
            return Math.abs(o1) - Math.abs(o2);
        });

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < N ; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(q.isEmpty()) sb.append("0").append("\n");
                else{
                    sb.append(q.poll()).append("\n");
                }
            }
            else{
                q.offer(num);
            }
        }

        System.out.println(sb);
    }
}
