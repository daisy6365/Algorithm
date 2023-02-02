import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5464_주차장 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 주차공간 갯수
        int[] parking_Fee = new int[N]; // 주차공간별 단위 요금 정보
        int[] parking_check = new int[N]; // 주차공간이 있는지 확인

        int M = Integer.parseInt(st.nextToken()); // 주차할 차량 갯수
        int[] car_weight = new int[M]; // 차량의 무게 정보

        for (int i = 0; i < N; i++) {
            parking_Fee[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            car_weight[i] = Integer.parseInt(br.readLine());
        }

        int total_fee = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < M*2; i++) {
            // inout값 받기
            int in_out = Integer.parseInt(br.readLine());

            if(in_out > 0) {
                // 주차
                // 주차장에 차량이 있는지 하나씩 확인
                boolean parking = false;
                for (int j = 0; j < N; j++) {
                    if(parking_check[j] == 0) {
                        // 공간 있음 주차하삼
                        parking_check[j] = in_out;
                        total_fee += (parking_Fee[j] * car_weight[in_out - 1]);
                        parking = true;
                        break;
                    }
                }
                if(!parking){
                    // 공간 없어서 주차 못함
                    // 대기
                    queue.add(in_out);
                }
            }
            else {
                // 주차 빼기
                for (int j = 0; j < N; j++) {
                    if(parking_check[j] == Math.abs(in_out)){
                        // 대기중인 애들 바로 주차시켜
                        if(!queue.isEmpty()){
                            // 대기중인애들 있음
                            // 제일 먼저온애 빼기
                            int car = queue.poll();
                            parking_check[j] = car;
                            total_fee += (parking_Fee[j] * car_weight[car - 1]);
                        }
                        else {
                            // 대기중인애들 없음
                            // 주차공간 빼
                            parking_check[j] = 0;
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(total_fee);
    }
}
