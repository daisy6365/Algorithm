import java.util.*;
import java.io.*;

public class BOJ_13335_트럭 {
    static int n, w, L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        Queue<Integer> truck = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            truck.offer(Integer.parseInt(st.nextToken()));
        }

        int sumL = 0; // 현재 건너고 있는 버스들의 하중
        int count = 0; // 시간
        Queue<Integer> bridge = new LinkedList<>();

        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }

        while(!bridge.isEmpty()){
            count++;
            sumL -= bridge.poll();
            if(!truck.isEmpty()){ // 못건넌 트럭이 있을때
                if(sumL + truck.peek() <= L) {
                    int newTruck = truck.poll();
                    sumL += newTruck;
                    bridge.offer(newTruck);
                }else {
                    bridge.offer(0);
                }
            }
        }

        System.out.println(count);

    }
}
