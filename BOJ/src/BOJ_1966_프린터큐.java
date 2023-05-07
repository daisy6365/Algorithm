import java.util.*;
import java.io.*;

public class BOJ_1966_프린터큐 {
    static class Print{
        int docs; // 중요도
        int position; // 원래 위치

        public Print(int docs, int position){
            this.docs = docs;
            this.position = position;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int tc = 0 ; tc < TC ; tc++){
            Queue<Print> pq = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken()); // 문서 갯수
            int order = Integer.parseInt(st.nextToken()); // 위치가 궁금한 문서의 현재 위치

            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < num ; i++){
                pq.offer(new Print(Integer.parseInt(st.nextToken()), i));
            }

            int count = 0;
            while(true){
                Print p = pq.poll();
                boolean flag = true; //
                for(Print temp : pq){
                    if(p.docs < temp.docs){
                        // 맨앞보다 큰게 있다면
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    // 맨 앞이 제일 크다면
                    count++; // 순서 카운트
                    if(order == p.position) break;
                }
                else{
                    // 맨 앞보다 큰게 있다면
                    pq.offer(p); // 뒤로보냄
                }

            }
            System.out.println(count);

        }


    }
}
