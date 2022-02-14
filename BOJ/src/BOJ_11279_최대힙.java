import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_11279_최대힙 {
    public static void main(String[] args) throws IOException {
        // 입력 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 받는 수의 갯수
        int N = Integer.parseInt(br.readLine());

        //최소힙은 그냥 생성해도 되지만 최대힙은 Collections.reverseOrder()사용하여 생성
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            //일단 들어 오는 모든 수 넣기
            maxQueue.offer(num);

            //0이라면 최대힙을 이용하여 최대숫자 poll
            if(num == 0){
                System.out.println(maxQueue.poll());
            }
        }
    }
}
