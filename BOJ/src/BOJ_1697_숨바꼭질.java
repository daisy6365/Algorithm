import java.util.*;
import java.io.*;

public class BOJ_1697_숨바꼭질 {
    static int N, K, count;
    static int[] isSelected = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();
    }
    private static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        if(N == K){
            System.out.println(0);
            return;
        }
        q.offer(N);
        isSelected[N] = 1;

        while(!q.isEmpty()){
            int now = q.poll();
            // +1, -1, *2
            for(int i = 0 ; i < 3 ; i++){
                int next;
                if(i == 0){
                    next = now + 1;
                }
                else if (i == 1){
                    next = now - 1;
                }
                else{
                    next = now * 2;
                }

                if(next == K){
                    System.out.println(isSelected[now]);
                    return;
                }

                if(next >= 0 && next < isSelected.length && isSelected[next] == 0){
                    q.offer(next);
                    isSelected[next] = isSelected[now] + 1;
                }

            }
        }
    }
}
