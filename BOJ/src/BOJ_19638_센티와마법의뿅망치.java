import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_19638_센티와마법의뿅망치 {
    static int H;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 거인의 나라의 인구수
        H = Integer.parseInt(st.nextToken()); // 센티의 키
        int T = Integer.parseInt(st.nextToken()); // 마법의 뿅망치의 횟수 -> 뿅망치에 맞으면 키가 /2 으로 줄음
        int temp_t = T;

        // 큐 정렬
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            int giant_height = Integer.parseInt(br.readLine());
            priorityQueue.offer(giant_height);
        }

        boolean flag = false;
        while(true){
            if(check_height(priorityQueue.peek())) {
                // 센티가 크면
                flag = true;
                break;
            }
            if(temp_t == 0 || priorityQueue.peek() == 1) {
                // 횟수를 다 사용했거나, 거인의 키가 더이상 줄지 않을때
                // 센티의 키와 비교
                flag = check_height(priorityQueue.peek());
                break;
            }
            int hit_height = priorityQueue.poll();
            priorityQueue.offer(hit_height/2);
            temp_t--;
        }

        if(flag){
            // YES
            // 사용한 뿅망치 횟수
            System.out.println("YES");
            System.out.println(T - temp_t);
        }
        else{
            // NO
            // 키가 가장 큰 거인의 키
            System.out.println("NO");
            System.out.println(priorityQueue.peek());
        }
    }

    private static boolean check_height(int giant_height){
        if(H <= giant_height) return false;
        return true;
    }
}
