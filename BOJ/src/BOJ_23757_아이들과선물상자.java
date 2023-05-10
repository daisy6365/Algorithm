import java.util.*;
import java.io.*;

public class BOJ_23757_아이들과선물상자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> presents = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> kids = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++){
            presents.offer(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M ; i++){
            kids.offer(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < M; i++){
            if(presents.isEmpty()) {
                System.out.println(0);
                return;
            }
            int kid = kids.poll();
            int present = presents.poll();
            if(kid > present){
                System.out.println(0);
                return;
            }
            if(present - kid != 0){
                presents.offer(present - kid);
            }
        }

        System.out.println(1);
    }
}
